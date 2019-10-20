package test.expenseManager;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import expenseManager.Expense;

import java.util.Date;

class ExpenseTest {

	@Test
	void createExpense() {
		double newAmount = 345.8;
		String newLocation = "Tokyo";
		Date today = new Date();
		String purpose = "Something";
		boolean cyclical = true;
		Expense expense = new Expense(newAmount, newLocation, today, purpose, cyclical);
		assertEquals(newAmount, expense.amount);
		assertEquals(newLocation, expense.location);
		assertEquals(today, expense.date);
		assertEquals(false, expense.paid);
		assertEquals(purpose,expense.description);
		assertEquals(cyclical,expense.cyclical);
		
	}

}
