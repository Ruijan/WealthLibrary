package test.expenseManager;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap; 
import java.util.Map; 

import org.junit.jupiter.api.Test;

import expenseManager.Account;
import expenseManager.Credit;
import expenseManager.Debt;
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
		Expense expense = new Expense(expenseAmount, newLocation, newDate, description,true,true,1);
		account.addDebit(expense);
		assertEquals(expense, account.debits.get(0));
		assertEquals(accountBalanceAtTest-expenseAmount,account.balance,0.001);
		assertEquals(accountBalanceAtTest,account.initialBalance,0.001); 
	}
	@Test
	void addDebt() {
		double amount = 1000;
		double interest =0.01;
		long period = 35;
		Date startDate = new Date();
		String type = "Mortage";
		Debt debt = new Debt(amount, type, interest, period, startDate);
		assertEquals(amount, debt.amount,0.01);
		assertEquals(interest,debt.interest,0.01);
		assertEquals(period,debt.period);
		assertEquals(startDate,debt.startDate);
		assertEquals(type,debt.type);
	}
	
	@Test
	void addAsset() {}
	
	@Test
	void getExpenseBydescription(){
		ArrayList <String> descriptions = new ArrayList<String>();
		descriptions.add("Something");
		descriptions.add("Food");
		Expense expense = new Expense(100, "", new Date(), descriptions,true,true,1); 
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
		Expense expense = new Expense(100, "", new Date(), descriptions,true,true,1); 
		account.addDebit(expense);
		account.addDebit(expense); 
		assertEquals(descriptions,account.getCurrentExpensesTags()); 
	}
	
	
	@Test
	void addBalance() {
		double creditedBalance = 100;
		Credit credit = new Credit(100,"Work", new Date(),"Salary",true,1);
		account.addCredit(credit);
		assertEquals(accountBalanceAtTest+creditedBalance,account.balance,0.001);
		assertEquals(account.balance-creditedBalance, account.initialBalance,0.001); 
	}
	
	@Test 
	void getCurrentBalance()
	{
		ArrayList <String> descriptions = new ArrayList<String>();
		descriptions.add("Something");
		descriptions.add("Food"); 
		account.addDebit(new Expense(100, "", new Date(), descriptions,true,true,1)); 
		account.addDebit(new Expense(100, "", new Date(), descriptions,true,true,1)); 
		assertEquals(accountBalanceAtTest - (100 *2), account.balance,0.001);
	}

	@Test 
	void getTagsUsage() {
		ArrayList <String> descriptions1 = new ArrayList<String>();
		descriptions1.add("Something");
		descriptions1.add("Food"); 
		ArrayList <String> descriptions2 = new ArrayList<String>();
		descriptions2.add("Something");
		descriptions2.add("Food"); 
		ArrayList <String> descriptions3 = new ArrayList<String>();
		descriptions3.add("Something");
		descriptions3.add("Food"); 
		Map<String,Long> occurrencies = new HashMap<>();
		occurrencies.put("Something", (long) 3);
		occurrencies.put("Food", (long) 3); 
		account.addDebit(new Expense(100, "", new Date(), descriptions1,true,true,1)); 
		account.addDebit(new Expense(100, "", new Date(), descriptions2,true,true,1));  
		account.addDebit(new Expense(100, "", new Date(), descriptions3,true,true,1));
		assertEquals(occurrencies,account.getTagsUsageCount());  
	}
	@Test 
	void getTagUsage() {
		ArrayList <String> descriptions1 = new ArrayList<String>();
		descriptions1.add("Something");  
		account.addDebit(new Expense(100, "", new Date(), descriptions1,true,true,1)); 
		account.addDebit(new Expense(100, "", new Date(), descriptions1,true,true,1));  
		account.addDebit(new Expense(100, "", new Date(), descriptions1,true,true,1));
		assertEquals(3,account.getTagUsageCount("Something"));  
	}
	
	@Test 
	void getCreditAvailableTypes() { 
		account.addCredit(new Credit(100,"Slavery", new Date(),"Salary",true,1));
		account.addCredit(new Credit(100,"SomeStock", new Date(),"Dividend",true,2));
		ArrayList <String> creditTypes = new ArrayList<String>();
		creditTypes.add("Salary");
		creditTypes.add("Dividend");
		assertEquals(creditTypes,account.getAvailableCreditTypes());  
	}
	
}

