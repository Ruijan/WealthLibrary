package test.expenseManager;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

import expenseManager.Account;
import expenseManager.Expense;

class AccountTest {

	@Test
	void createAccount() { 
		String accountName = "MyFirstAccount";
		String accountType = "Survivor";
		String accountCurrency = "EUR";
		double accountAmount = 0.0;
		Account account = new Account(accountName,accountType,accountCurrency,accountAmount);
		assertEquals(accountName, account.name);
		assertEquals(accountType, account.type);
		assertEquals(accountCurrency,account.currency);
		assertEquals(accountAmount,account.amount,0.001);
		assertEquals(accountAmount,account.initialAmount,0.001);
	
	}
	@Test
	void addExpense() {
		String newLocation = "Paris";
		Date newDate = new Date();
		boolean isPaid = false;
		double newAmount = 300;
		String accountName = "MyFirstAccount";
		String accountType = "Survivor";
		String accountCurrency = "EUR";
		double accountAmount = 0.0;
		Account account = new Account(accountName, accountType, accountCurrency, accountAmount);
		Expense expense = new Expense(newAmount, newLocation, newDate, isPaid);
		account.addExpense(expense);
		assertEquals(expense, account.expenses.get(0));
		assertEquals(accountAmount+newAmount,account.amount,0.001);
		assertEquals(accountAmount,account.initialAmount,0.001);
		
	}
}
