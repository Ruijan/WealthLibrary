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
	
	public Expense(double newAmount, String newLocation, Date newDate, ArrayList<String> tag, boolean isCyclical) {
		amount = newAmount;
		location = newLocation;
		date = newDate; 
		tags = tag;
		cyclical = isCyclical;
	}
	
}
