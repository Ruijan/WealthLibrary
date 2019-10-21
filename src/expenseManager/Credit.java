package expenseManager;

import java.util.Date;

public class Credit {
	
	public double amount;
	public String description;
	public Date date;
	public String type;
	public boolean cyclical;
	public long monthlyCycle;
	
	public Credit(double newAmount, String newDescription, Date newDate, String newCreditType, 
			boolean isCyclical, long newCycle) {
		amount = newAmount;
		description = newDescription;
		date = newDate;
		type = newCreditType;
		cyclical = isCyclical;
		monthlyCycle = newCycle;
	}

}
