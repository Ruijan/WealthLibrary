package expenseManager;
import java.util.ArrayList;
import java.util.Date;

public class Transaction {

	public double amount;
	public String location;
	public Date transactionDate;
	public ArrayList<String> tags; 
	public String type;
	
	
	public Transaction(double newAmount, String newLocation, Date newDate, ArrayList<String> newTags) {
		amount = newAmount;
		location = newLocation;
		transactionDate = newDate; 
		tags = newTags;
	}

	public Transaction(Transaction newTransaction) { 
		amount = newTransaction.amount;
		location = newTransaction.location;
		transactionDate = newTransaction.transactionDate; 
		tags = newTransaction.tags;
	}
}
