package test.expenseManager;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import expenseManager.Transaction;

import java.util.ArrayList;
import java.util.Date;

class TransactionTest {
	@Test
	void createExpense() {
		double newAmount = 345.8;
		String newLocation = "Tokyo";
		Date today = new Date();
		ArrayList <String> descriptions = new ArrayList<String>();
		descriptions.add("Something");
		descriptions.add("Food");
		Transaction transaction = new Transaction(newAmount, newLocation, today, descriptions);
		assertEquals(newAmount, transaction.amount);
		assertEquals(newLocation, transaction.location);
		assertEquals(today, transaction.date);
		assertEquals(false, transaction.paid);
		assertEquals(descriptions,transaction.tags); 
	}

}
