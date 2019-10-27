package expenseManager;
import java.util.ArrayList;
import java.util.Date;

public class Transaction {

	public static class TransactionData {
		public double amount;
		public String location;
		public Date date;
		public ArrayList<String> tags;
		public String type;
		public TransactionData() {
		}
	}

	public TransactionData data = new TransactionData();

	public Transaction(TransactionData userInput) {
		data.amount = userInput.amount;
		data.location =  userInput.location;
		data.date =  userInput.date; 
		data.tags =  userInput.tags;
	}

	public Transaction(Transaction newTransaction) { 
		data.amount = newTransaction.data.amount;
		data.location = newTransaction.data.location;
		data.date = newTransaction.data.date; 
		data.tags = newTransaction.data.tags;
	}
}
