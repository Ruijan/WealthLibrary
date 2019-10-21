package expenseManager;
import java.util.ArrayList;
import java.util.Date;

public class Expense {

	public double amount;
	public String location;
	public Date date;
	public boolean paid;
	public ArrayList<String> tags;
	public boolean cyclical;
	public long monthlyCycle; 
	
	public Expense(double newAmount, String newLocation, Date newDate, ArrayList<String> newTags) {
		amount = newAmount;
		location = newLocation;
		date = newDate; 
		tags = newTags;
	}
	
	public Expense(Expense newExpense) {
		amount = newExpense.amount;
		location = newExpense.location;
		date = newExpense.date; 
		tags = newExpense.tags;
	}
	
}
