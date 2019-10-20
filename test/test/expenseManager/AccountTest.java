package test.expenseManager;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.Test;

import expenseManager.Account;
import expenseManager.Expense;

class AccountTest {
	
	public String accountNameAtTest = "MyFirstAccount";
	public String accountTypeAtTest = "Survivor";
	public String accountCurrencyAtTest = "EUR";
	public double accountBalanceAtTest = 1000;
	
	@Test
	void createAccount() {  
		Account account = new Account(accountNameAtTest,accountTypeAtTest,accountCurrencyAtTest,accountBalanceAtTest);
		assertEquals(accountNameAtTest, account.name);
		assertEquals(accountTypeAtTest, account.type);
		assertEquals(accountCurrencyAtTest,account.currency);
		assertEquals(Math.abs(accountBalanceAtTest),account.balance,0.001);
		assertEquals(Math.abs(accountBalanceAtTest),account.balance,0.001);
		
	}
	@Test
	void addExpense() {
		Account account = new Account(accountNameAtTest, accountTypeAtTest, accountCurrencyAtTest, accountBalanceAtTest);
		String newLocation = "Paris";
		Date newDate = new Date(); 
		double expenseAmount = 300; 
		String description = "Something";
		Expense expense = new Expense(expenseAmount, newLocation, newDate, description,true);
		
		account.addDebit(expense);
		assertEquals(expense, account.expenses.get(0));
		assertEquals(accountBalanceAtTest-expenseAmount,account.balance,0.001);
		assertEquals(accountBalanceAtTest,account.initialBalance,0.001); 
	}
	@Test
	void getExpenseBydescription(){
		Account account = new Account(accountNameAtTest, accountTypeAtTest, accountCurrencyAtTest, accountBalanceAtTest);
		String description ="Something"; 
		Expense expense = new Expense(100, "", new Date(), description,true); 
		account.addDebit(expense);   
		ArrayList <Expense> expensesByDescription = new ArrayList<Expense>();
		expensesByDescription.add(expense); 
		assertEquals(expensesByDescription, account.getExpensesByDescription("Something"));
	}
	@Test
	void addBalance() {
		Account account = new Account(accountNameAtTest, accountTypeAtTest, accountCurrencyAtTest, accountBalanceAtTest);
		double newBalance = 100;
		account.addCredit(newBalance);
		assertEquals(accountBalanceAtTest+newBalance,account.balance,0.001);
		assertEquals(account.balance-newBalance, account.initialBalance,0.001); 
	}
}

