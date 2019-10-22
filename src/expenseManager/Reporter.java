package expenseManager;
 
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
public class Reporter{
	public Account account;
	
	public Reporter(Account reportAccount) {
		account = reportAccount;
	}

	public ArrayList<Transaction> getDebitTransactionByWeekDay(int weekDayToSearch) {
		ArrayList<Transaction> searchedTransactions = new  ArrayList<Transaction>();
		Calendar transactionDate = Calendar.getInstance();
		for(Transaction transaction : account.debits) {
			transactionDate.setTime(transaction.transactionDate);
			if(transactionDate.get(Calendar.DAY_OF_WEEK) == weekDayToSearch) searchedTransactions.add(transaction);
		}
		return searchedTransactions;
	}

	public ArrayList<Transaction> getTransactionFromDay(Calendar dateToLookFor) {
		ArrayList<Transaction> searchedTransactions = new  ArrayList<Transaction>();
		Calendar transactionDate = Calendar.getInstance();
		for(Transaction transaction : account.debits) {
			transactionDate.setTime(transaction.transactionDate);
			if(transactionDate.after(dateToLookFor)) searchedTransactions.add(transaction);
		}
		return searchedTransactions;
	}

	public ArrayList <Transaction> getExpensesByDescription(String searchedTag)
	{
		ArrayList <Transaction> searchedExpense = new ArrayList<Transaction>(); 
		for (Transaction debit : account.debits) { 
			for (String debitString : debit.tags) 
				if (debitString.equals(searchedTag)) searchedExpense.add(debit);   
		}
		return searchedExpense;
	}

	public ArrayList<String> getCurrentExpensesTags() {
		ArrayList <String> tags = new ArrayList<String>(); 
		account.debits.forEach((expense) -> tags.addAll(expense.tags));  
		Set <String>uniqueTags = new HashSet<String>(tags); 
		return (new ArrayList<String>(uniqueTags));
	}
	 
	public Map<String,Long> getTagsUsageCount() {
		ArrayList <String> tags = new ArrayList<String>(); 
		Map<String,Long> usage = new HashMap<>();
		account.debits.forEach((expense) -> tags.addAll(expense.tags));  
		for(String tag : tags) usage.put(tag, (long) Collections.frequency(tags,tag));
		return usage;
	}

	public Transaction getExpensebyIndex(int index) { 
		return account.debits.get(index); 
	}


 
}
