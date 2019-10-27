package test.expenseManager;

import static org.junit.Assert.assertEquals; 

import java.util.ArrayList;
import java.util.Date; 

import org.junit.jupiter.api.Test;

import expenseManager.Account; 
import expenseManager.Transaction;

class AccountTest {
	
	public String accountNameAtTest = "MyFirstAccount";
	public String accountCurrencyAtTest = "EUR";
	public double accountBalanceAtTest = 1000;
	Account account = new Account(accountNameAtTest,accountCurrencyAtTest,accountBalanceAtTest);
	
	@Test
	void createAccount() {  
		assertEquals(accountNameAtTest, account.data.name);;
		assertEquals(accountCurrencyAtTest,account.data.currency);
		assertEquals(Math.abs(accountBalanceAtTest),account.data.balance,0.001);
		assertEquals(Math.abs(accountBalanceAtTest),account.data.balance,0.001); 
	}
	@Test
	void addExpense() { 
		double expenseAmount = 300; 
		ArrayList <String> description = new ArrayList<String>();
		description.add("Utilities");
		description.add("Food");
		Transaction.TransactionData transactionInformation = new Transaction.TransactionData();
		transactionInformation.amount = 300;
		transactionInformation.location = "";
		transactionInformation.date = new Date();
		transactionInformation.tags = description;
		Transaction expense = new Transaction(transactionInformation);
		account.addDebit(expense);
		assertEquals(expense, account.bankBook.debits.get(0));
		assertEquals(accountBalanceAtTest-expenseAmount,account.data.balance,0.001);
		assertEquals(accountBalanceAtTest,account.data.initialBalance,0.001); 
	}
	@Test 
	void resetAccount() {
		ArrayList <String> description = new ArrayList<String>();
		description.add("Utilities");
		description.add("Food");
		Transaction.TransactionData transactionInformation = new Transaction.TransactionData();
		transactionInformation.amount = 100;
		transactionInformation.location = "";
		transactionInformation.date = new Date();
		transactionInformation.tags = description;
		Transaction expense = new Transaction(transactionInformation);
		account.addDebit(expense);
		account.addDebit(expense);
		account.addDebit(expense);
		account.resetAccount();
		assertEquals(accountBalanceAtTest,account.data.balance,0.01); 
		
		
	}
	 
	
	@Test
	void addBalance() {
		ArrayList <String> descriptions = new ArrayList<String>();
		descriptions.add("Something");
		double creditedBalance = 100;
		Transaction.TransactionData transactionInformation = new Transaction.TransactionData();
		transactionInformation.amount = 100;
		transactionInformation.location = "";
		transactionInformation.date = new Date();
		transactionInformation.tags = descriptions;
		Transaction credit = new Transaction(transactionInformation);
		account.addCredit(credit);
		assertEquals(accountBalanceAtTest+creditedBalance,account.data.balance,0.001);
		assertEquals(account.data.balance-creditedBalance, account.data.initialBalance,0.001); 
	}
	
	@Test 
	void getCurrentBalance()
	{
		ArrayList <String> descriptions = new ArrayList<String>();
		descriptions.add("Something");
		descriptions.add("Food"); 
		Transaction.TransactionData transactionInformation = new Transaction.TransactionData();
		transactionInformation.amount = 100;
		transactionInformation.location = "";
		transactionInformation.date = new Date();
		transactionInformation.tags = descriptions;
		account.addDebit(new Transaction(transactionInformation)); 
		account.addDebit(new Transaction(transactionInformation)); 
		assertEquals(accountBalanceAtTest - (100 *2), account.data.balance,0.001);
	}
 


	 
	 
}

