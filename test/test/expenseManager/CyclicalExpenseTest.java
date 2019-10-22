package test.expenseManager;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;

import expenseManager.CyclicalExpense;
import expenseManager.Expense;
import expenseManager.Period;

class CyclicalExpenseTest {

	@Test
	void createCyclicalExpenseTest() {
		Period period = Period.MONTHLY;
		Date startingDate = new Date();
		Expense expenseTemplate = createExpenseTemplate();
		
		CyclicalExpense cyclicalExpense = new CyclicalExpense(expenseTemplate, period, startingDate);
		assertEquals(cyclicalExpense.getExpenseTemplate(), expenseTemplate);
		assertEquals(cyclicalExpense.getPeriod(), period);
		assertEquals(cyclicalExpense.getStartingDate(), startingDate);
		assertEquals(cyclicalExpense.lastPaymentDate(), startingDate);
	}
	
	@Test
	void shouldPayBeforePeriod() {
		Period period = Period.MONTHLY;
		LocalDate date = LocalDate.now().minusDays(15);
		ZoneId defaultZoneId = ZoneId.systemDefault();
		Date startingDate = Date.from(date.atStartOfDay(defaultZoneId).toInstant());
		Expense expenseTemplate = createExpenseTemplate();
		
		CyclicalExpense cyclicalExpense = new CyclicalExpense(expenseTemplate, period, startingDate);
		assertFalse(cyclicalExpense.isAfterPayDay(Calendar.getInstance().getTime()));
	}
	
	@Test
	void createPaymentTest() {
		Period period = Period.MONTHLY;
		Date startingDate = new Date();
		Expense expenseTemplate = createExpenseTemplate();
		LocalDate date = LocalDate.now().plusDays(30);
		ZoneId defaultZoneId = ZoneId.systemDefault();
		Date nextPaymentDate = Date.from(date.atStartOfDay(defaultZoneId).toInstant());

		CyclicalExpense cyclicalExpense = new CyclicalExpense(expenseTemplate, period, startingDate);
		Expense expense = cyclicalExpense.createPayment();
		assertEquals(expenseTemplate.amount, expense.amount);
		assertEquals(expenseTemplate.location, expense.location);
		assertEquals(expenseTemplate.tags, expense.tags);
		assertEquals(0, TimeUnit.DAYS.convert(cyclicalExpense.lastPaymentDate().getTime() - nextPaymentDate.getTime(), TimeUnit.MILLISECONDS));
		assertEquals(0, TimeUnit.DAYS.convert(expense.date.getTime() - nextPaymentDate.getTime(), TimeUnit.MILLISECONDS));
	}

	private Expense createExpenseTemplate() {
		double newAmount = 345.8;
		String newLocation = "Tokyo";
		Date today = new Date();
		ArrayList <String> descriptions = new ArrayList<String>();
		descriptions.add("Fees");
		descriptions.add("Electric bill");
		
		return new Expense(newAmount, newLocation, today, descriptions);
	}

}
