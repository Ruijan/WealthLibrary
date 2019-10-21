package test.expenseManager;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import expenseManager.Expense;

import java.util.ArrayList;
import java.util.Date;

class ExpenseTest {

	@Test
	void createExpense() {
		double newAmount = 345.8;
		String newLocation = "Tokyo";
		Date today = new Date();
		ArrayList <String> descriptions = new ArrayList<String>();
		descriptions.add("Something");
		descriptions.add("Food");
		Expense expense = new Expense(newAmount, newLocation, today, descriptions);
		assertEquals(newAmount, expense.amount);
		assertEquals(newLocation, expense.location);
		assertEquals(today, expense.date);
		assertEquals(false, expense.paid);
		assertEquals(descriptions,expense.tags); 
	}

}
