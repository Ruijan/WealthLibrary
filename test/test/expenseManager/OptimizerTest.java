package test.expenseManager;
 
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Test;

import expenseManager.Account;
import expenseManager.Optimizer;
import expenseManager.Reporter;
import expenseManager.Transaction;

class OptimizerTest {
	public String accountNameAtTest = "MyFirstAccount";
	public String accountCurrencyAtTest = "EUR";
	public double accountBalanceAtTest = 1000;
	Account account = new Account(accountNameAtTest,accountCurrencyAtTest,accountBalanceAtTest);
	ArrayList <Transaction> createDummyTransactions(int numberOfEntries){
		ArrayList <String> description = new ArrayList<String>();
		ArrayList <Transaction> transactions = new ArrayList<Transaction>();
		Calendar calendar = Calendar.getInstance();
		
		for(int i = 0 ; i < numberOfEntries+1; i ++) {
			 description = new ArrayList<String>();
			 description.add("Utilities"); 
			 description.add("Toys"); 
			 description.add("Beverages"); 
			 description.add("Restaurants");
			 calendar.set(2018,1,1+i,1,1,1);
			 Transaction.TransactionData transactionInformation = new Transaction.TransactionData();
			 transactionInformation.amount = 10;
			 transactionInformation.location = "Paris";
			 transactionInformation.date = calendar.getTime();
			 transactionInformation.tags = description;
			 transactions.add(new Transaction(transactionInformation));
		}
		return transactions;
		
	} 
	
	@Test
	void test() {
		 Reporter report = new Reporter(account);
		 Optimizer optimizer = new Optimizer(report);
		 
	}

}
