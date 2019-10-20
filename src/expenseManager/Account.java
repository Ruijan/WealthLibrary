package expenseManager;

import java.util.ArrayList;

public class Account {
	public String name;
	public String type;
	public String currency;
	public double balance;
	public ArrayList <Expense> expenses = new ArrayList<Expense>();
	public double initialBalance; 
	public Account(String accountName, String accountType, String accountCurrency, double accountBalance) {
		name = accountName;
		type = accountType;
		currency = accountCurrency;
		balance = Math.abs(accountBalance);
		initialBalance = Math.abs(accountBalance);
		
	}
	public void addExpense(Expense expense) {
		expenses.add(expense);
		balance -= expense.amount;
	}
	
	public Expense getExpensebyIndex(int index) { 
		return expenses.get(index); 
	}
	
	public ArrayList <Expense> getExpensesByDescription(String description)
	{
		ArrayList <Expense> searchExpenses = new ArrayList<Expense>();
		for (int index = 0; index < expenses.size();index++) {
			if (expenses.get(index).description == description )  {
				searchExpenses.add(expenses.get(index)); 
			}
		}
		return searchExpenses;
	}
	public void addBalance(double balanceToAdd) {
		balance +=balanceToAdd;
		
	}
}
