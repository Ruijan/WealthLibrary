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
	public ArrayList <Expense> debits = new ArrayList<Expense>();  
	public ArrayList <Credit> credits = new ArrayList<Credit>(); 
	public ArrayList <Debt>  debts = new ArrayList<Debt>();
	public ArrayList <Asset> assets = new ArrayList<Asset>();
	
	public Account(String accountName, String accountType, String accountCurrency, double accountBalance) {
		name = accountName;
		type = accountType;
		currency = accountCurrency;
		balance = Math.abs(accountBalance);
		initialBalance = Math.abs(accountBalance); 
	}
	
	public void addDebit(Expense expense) {
		debits.add(expense); 
		updateAccountBalance(-expense.amount);
	}
	
	public void addCredit(Credit credit) {
		credits.add(credit);
		updateAccountBalance(credit.amount); 
	}
	
	private void updateAccountBalance(double amount) {
		balance +=amount;
	}
	public Expense getExpensebyIndex(int index) { 
		return debits.get(index); 
	}
	
	public ArrayList <Expense> getExpensesByDescription(String searchedTag)
	{
		ArrayList <Expense> searchedExpense = new ArrayList<Expense>(); 
		for (Expense debit : debits) { 
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

	public Long getTagUsageCount(String tag) {
		ArrayList <String> tags = new ArrayList<String>();  
		debits.forEach((expense) -> tags.addAll(expense.tags));
		return (long) Collections.frequency(tags,tag);
	}

	public ArrayList<String> getAvailableCreditTypes() {
		ArrayList <String> creditType = new ArrayList<String>(); 
		credits.forEach((credit) -> creditType.add(credit.type));  
		Set <String>creditTypes = new HashSet<String>(creditType); 
		return (new ArrayList<String>(creditTypes)); 
	}
	
	
}
