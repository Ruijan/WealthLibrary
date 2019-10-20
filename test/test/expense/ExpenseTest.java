package test.expense;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import expense.Expense;
import java.util.Date;

class ExpenseTest {

	@Test
	void createExpense() {
		double newAmount = 345.8;
		String newLocation = "Tokyo";
		Date today = new Date();
		Expense expense = new Expense(newAmount, newLocation, today, false);
		assertEquals(newAmount, expense.amount);
		assertEquals(newLocation, expense.location);
		assertEquals(today, expense.date);
		assertEquals(false, expense.paid);
	}

}
