package expenseManager;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Account {
	public String name;
	public String type;
	public String currency;
	public double balance;
	public ArrayList <Expense> debits = new ArrayList<Expense>();
	public double initialBalance; 
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
	
	public void addCredit(double credit) {
		updateAccountBalance(credit); 
	}
	
	private void updateAccountBalance(double amount) {
		balance +=amount;
	}
	public Expense getExpensebyIndex(int index) { 
		return debits.get(index); 
	}
	
	public ArrayList <Expense> getExpensesByDescription(String searchedTerm)
	{
		ArrayList <Expense> searchExpenses = new ArrayList<Expense>();
		Expense expense = null;
		for (int index = 0; index < debits.size();index++) {
			expense = debits.get(index);
			for (int indexTags = 0;indexTags < expense.tags.size();indexTags++) 
			{
				if (searchedTerm == expense.tags.get(indexTags))
				searchExpenses.add(expense); 
			} 
		}
		return searchExpenses;
	}

	public Set<String> getCurrentExpensesTags() {
		ArrayList <String> tags = new ArrayList<String>(); 
		debits.forEach((expense) -> tags.addAll(expense.tags));  
		return (new HashSet<String>(tags));
	}
	
}
