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
 
import expenseManager.CyclicalTransaction; 
import expenseManager.Period;
import expenseManager.Transaction;

class CyclicalTransactionTest {

	@Test
	void createCyclicalTransactionTest() {
		Period period = Period.MONTHLY;
		Date startingDate = new Date();
		Transaction expenseTemplate = createExpenseTemplate();
		
		CyclicalTransaction cyclicalExpense = new CyclicalTransaction(expenseTemplate, period, startingDate);
		assertEquals(cyclicalExpense.getTransactionTemplate(), expenseTemplate);
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
		Transaction expenseTemplate = createExpenseTemplate();
		CyclicalTransaction cyclicalExpense = new CyclicalTransaction(expenseTemplate, period, startingDate);
		assertFalse(cyclicalExpense.isAfterPayDay(Calendar.getInstance().getTime()));
	}
	
	@Test
	void createPaymentTest() {
		Period period = Period.MONTHLY;
		Date startingDate = new Date();
		Transaction expenseTemplate = createExpenseTemplate();
		LocalDate date = LocalDate.now().plusDays(30);
		ZoneId defaultZoneId = ZoneId.systemDefault();
		Date nextPaymentDate = Date.from(date.atStartOfDay(defaultZoneId).toInstant());

		CyclicalTransaction cyclicalExpense = new CyclicalTransaction(expenseTemplate, period, startingDate);
		Transaction expense = cyclicalExpense.createPayment();
		assertEquals(expenseTemplate.data.amount, expense.data.amount);
		assertEquals(expenseTemplate.data.location, expense.data.location);
		assertEquals(expenseTemplate.data.tags, expense.data.tags);
		assertEquals(0, TimeUnit.DAYS.convert(cyclicalExpense.lastPaymentDate().getTime() - nextPaymentDate.getTime(), TimeUnit.MILLISECONDS));
		assertEquals(0, TimeUnit.DAYS.convert(expense.data.date.getTime() - nextPaymentDate.getTime(), TimeUnit.MILLISECONDS));
	}

	private Transaction createExpenseTemplate() {
		double newAmount = 345.8;
		String newLocation = "Tokyo"; 
		ArrayList <String> descriptions = new ArrayList<String>();
		descriptions.add("Fees");
		descriptions.add("Electric bill");
		Transaction.TransactionData transactionInformation = new Transaction.TransactionData();
		transactionInformation.amount = newAmount;
		transactionInformation.location = newLocation;
		transactionInformation.date = new Date();
		transactionInformation.tags = descriptions;
		return new Transaction(transactionInformation);
	}

}
