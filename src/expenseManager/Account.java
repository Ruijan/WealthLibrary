package expenseManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
	
	public Transaction getExpensebyIndex(int index) { 
		return debits.get(index); 
	}
	
	public ArrayList <Transaction> getExpensesByDescription(String searchedTag)
	{
		ArrayList <Transaction> searchedExpense = new ArrayList<Transaction>(); 
		for (Transaction debit : debits) { 
			for (String debitString : debit.tags) 
				if (debitString.equals(searchedTag)) searchedExpense.add(debit);   
		}
		return searchedExpense;
	}

	public ArrayList<String> getCurrentExpensesTags() {
		ArrayList <String> tags = new ArrayList<String>(); 
		debits.forEach((expense) -> tags.addAll(expense.tags));  
		Set <String>uniqueTags = new HashSet<String>(tags); 
		return (new ArrayList<String>(uniqueTags));
	}
	 
	public Map<String,Long> getTagsUsageCount() {
		ArrayList <String> tags = new ArrayList<String>(); 
		Map<String,Long> usage = new HashMap<>();
		debits.forEach((expense) -> tags.addAll(expense.tags));  
		for(String tag : tags) usage.put(tag, (long) Collections.frequency(tags,tag));
		return usage;
	}
	
}
