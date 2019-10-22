package test.expenseManager;

import static org.junit.Assert.assertEquals; 

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap; 
import java.util.Map; 

import org.junit.jupiter.api.Test;

import expenseManager.Account;
import expenseManager.Asset;
import expenseManager.Debt;
import expenseManager.Transaction;

class AccountTest {
	
	public String accountNameAtTest = "MyFirstAccount";
	public String accountCurrencyAtTest = "EUR";
	public double accountBalanceAtTest = 1000;
	Account account = new Account(accountNameAtTest,accountCurrencyAtTest,accountBalanceAtTest);
	
	@Test
	void createAccount() {  
		assertEquals(accountNameAtTest, account.name);;
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
		Transaction expense = new Transaction(expenseAmount, newLocation, newDate, description);
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
		Debt debt = new Debt(amount, interest, period, startDate);
		assertEquals(amount, debt.amount,0.01);
		assertEquals(interest,debt.interest,0.01);
		assertEquals(period,debt.period);
		assertEquals(startDate,debt.startDate);
	}
	
	@Test
	void addAsset() {
		String newAssetName = "Stock";
		double newYearReturn = 0.1;
		double newAssetCurrentValue = 100;
		Asset asset = new Asset(newAssetName,newYearReturn,newAssetCurrentValue);
		assertEquals(newAssetName, asset.name);
		assertEquals(newYearReturn, asset.yearReturn,0.001);
		assertEquals(newAssetCurrentValue,asset.initiaValue,0.001);
	}
	
	@Test
	void getExpenseBydescription(){
		ArrayList <String> descriptions = new ArrayList<String>();
		descriptions.add("Something");
		descriptions.add("Food");
		Transaction expense = new Transaction(100, "", new Date(), descriptions); 
		account.addDebit(expense);   
		ArrayList <Transaction> expensesByDescription = new ArrayList<Transaction>();
		expensesByDescription.add(expense); 
		assertEquals(expensesByDescription, account.getExpensesByDescription("Something"));
	}
	@Test
	void getCurrentRecordedTags() {
		ArrayList <String> descriptions = new ArrayList<String>();
		descriptions.add("Something");
		descriptions.add("Food");
		Transaction expense = new Transaction(100, "", new Date(), descriptions); 
		account.addDebit(expense);
		account.addDebit(expense); 
		assertEquals(descriptions,account.getCurrentExpensesTags()); 
	}
	
	
	@Test
	void addBalance() {
		ArrayList <String> descriptions = new ArrayList<String>();
		descriptions.add("Something");
		double creditedBalance = 100;
		Transaction credit = new Transaction(100,"Place", new Date(),descriptions);
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
		account.addDebit(new Transaction(100, "", new Date(), descriptions)); 
		account.addDebit(new Transaction(100, "", new Date(), descriptions)); 
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
		account.addDebit(new Transaction(100, "", new Date(), descriptions1)); 
		account.addDebit(new Transaction(100, "", new Date(), descriptions2));  
		account.addDebit(new Transaction(100, "", new Date(), descriptions3));
		assertEquals(occurrencies,account.getTagsUsageCount());  
	}


	 
	 
}

