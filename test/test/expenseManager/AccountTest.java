package test.expenseManager;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import expenseManager.Account;
import expenseManager.Expense;

class AccountTest {
	
	public String accountNameAtTest = "MyFirstAccount";
	public String accountTypeAtTest = "Survivor";
	public String accountCurrencyAtTest = "EUR";
	public double accountBalanceAtTest = 1000;
	Account account = new Account(accountNameAtTest,accountTypeAtTest,accountCurrencyAtTest,accountBalanceAtTest);
	
	@Test
	void createAccount() {  
		assertEquals(accountNameAtTest, account.name);
		assertEquals(accountTypeAtTest, account.type);
		assertEquals(accountCurrencyAtTest,account.currency);
		assertEquals(Math.abs(accountBalanceAtTest),account.balance,0.001);
		assertEquals(Math.abs(accountBalanceAtTest),account.balance,0.001);
		
	}
	@Test
	void addExpense() {
		String newLocation = "Paris";
		Date newDate = new Date(); 
		double expenseAmount = 300; 
		ArrayList <String> description = new ArrayList<String>();
		description.add("Utilities");
		description.add("Food");
		Expense expense = new Expense(expenseAmount, newLocation, newDate, description,true);
		
		account.addDebit(expense);
		assertEquals(expense, account.debits.get(0));
		assertEquals(accountBalanceAtTest-expenseAmount,account.balance,0.001);
		assertEquals(accountBalanceAtTest,account.initialBalance,0.001); 
	}
	@Test
	void getExpenseBydescription(){
		ArrayList <String> descriptions = new ArrayList<String>();
		descriptions.add("Something");
		descriptions.add("Food");
		Expense expense = new Expense(100, "", new Date(), descriptions,true); 
		account.addDebit(expense);   
		ArrayList <Expense> expensesByDescription = new ArrayList<Expense>();
		expensesByDescription.add(expense); 
		assertEquals(expensesByDescription, account.getExpensesByDescription("Something"));
	}
	@Test
	void getCurrentRecordedTags() {
		ArrayList <String> descriptions = new ArrayList<String>();
		descriptions.add("Something");
		descriptions.add("Food");
		Expense expense = new Expense(100, "", new Date(), descriptions,true); 
		account.addDebit(expense);
		account.addDebit(expense);
		Set<String> uniqueDescriptions = new HashSet<String>(descriptions);
		assertEquals(uniqueDescriptions,account.getCurrentExpensesTags());
		
		
	}
	
	
	@Test
	void addBalance() {
		double creditedBalance = 100;
		account.addCredit(creditedBalance);
		assertEquals(accountBalanceAtTest+creditedBalance,account.balance,0.001);
		assertEquals(account.balance-creditedBalance, account.initialBalance,0.001); 
	}
	@Test 
	void getCurrentBalance()
	{
		
	}

}

