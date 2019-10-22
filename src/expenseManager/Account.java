package expenseManager;

import java.util.ArrayList; 

public class Account {
	public String name;
	public String type;
	public String currency;
	public double balance;
	public double initialBalance; 
	public ArrayList <Transaction> debits = new ArrayList<Transaction>();  
	public ArrayList <Transaction> credits = new ArrayList<Transaction>(); 
	 
	public Account(String accountName, String accountCurrency, double accountBalance) {
		name = accountName;
		currency = accountCurrency;
		balance =  accountBalance;
		initialBalance =  accountBalance; 
	}
	
	public void addDebit(Transaction expense) {
		debits.add(expense); 
		updateAccountBalance(-expense.amount);
	}
	
	public void addCredit(Transaction credit) {
		credits.add(credit);
		updateAccountBalance(credit.amount); 
	}
	
	private void updateAccountBalance(double amount) {
		balance +=amount;
	}
	
	public void resetAccount() {
		debits = new ArrayList<Transaction>();
		credits = new ArrayList<Transaction>();
		balance = initialBalance;
	}  
	
	
	
}
