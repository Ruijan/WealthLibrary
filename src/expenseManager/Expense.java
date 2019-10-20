package expenseManager;
import java.util.Date;

public class Expense {

	public double amount;
	public String location;
	public Date date;
	public boolean paid;
	public String description;
	public boolean cyclical;
	
	public Expense(double newAmount, String newLocation, Date newDate, String newDescription, boolean isCyclical) {
		amount = newAmount;
		location = newLocation;
		date = newDate; 
		description = newDescription;
		cyclical = isCyclical;
	}
	
}
