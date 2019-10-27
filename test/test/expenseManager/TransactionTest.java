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
		Transaction.TransactionData transactionInformation = new Transaction.TransactionData();
		transactionInformation.amount = newAmount;
		transactionInformation.location = newLocation;
		transactionInformation.date = today;
		transactionInformation.tags = descriptions;
		Transaction transaction = new Transaction(transactionInformation);
		assertEquals(newAmount, transaction.data.amount);
		assertEquals(newLocation, transaction.data.location);
		assertEquals(today, transaction.data.date); 
		assertEquals(descriptions,transaction.data.tags); 
	}

}
