package expense;
import java.util.Date;

public class Expense {

	public double amount;
	public String location;
	public Date date;
	public boolean paid;

	public Expense(double newAmount, String newLocation, Date newDate, boolean isPaid) {
		amount = newAmount;
		location = newLocation;
		date = newDate;
		paid = isPaid;
	}

}
