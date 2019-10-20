package expenseManager;

import java.util.ArrayList;

public class Account {
	public String name;
	public String type;
	public String currency;
	public double amount;
	public ArrayList <Expense> expenses = new ArrayList<Expense>();
	public double initialAmount; 
	
	public Account(String accountName, String accountType, String accountCurrency, double accountAmount) {
		name = accountName;
		type = accountType;
		currency = accountCurrency;
		amount = accountAmount;
		initialAmount = accountAmount;
	}
	public void addExpense(Expense expense) {
		expenses.add(expense);
		amount += expense.amount;
	}

}
