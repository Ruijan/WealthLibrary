package expenseManager;
import java.util.ArrayList;
import java.util.Date;

public class Transaction {

	public double amount;
	public String location;
	public Date date;
	public boolean paid;
	public ArrayList<String> tags;
	public boolean cyclical;
	public long monthlyCycle; 
	public String type;
	
	public Transaction(double newAmount, String newLocation, Date newDate, ArrayList<String> newTags) {
		amount = newAmount;
		location = newLocation;
		date = newDate; 
		tags = newTags;
	}
	
}
