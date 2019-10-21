package test.expenseManager;

import static org.junit.jupiter.api.Assertions.*;
 
import java.util.Date;

import org.junit.jupiter.api.Test;

import expenseManager.Credit; 

class CreditTest {

	@Test
	void test() {
		double newAmount = 1000; 
		Date today = new Date(); 
		String creditType = "Salary";
		String newDescription = "Work1";
		long cycle=1;
		Credit credit = new Credit(newAmount,newDescription, today, creditType,true,cycle);
		assertEquals(newAmount, credit.amount); 
		assertEquals(today, credit.date); 
		assertEquals(newDescription,credit.description);
		assertEquals(creditType,credit.type);
		assertEquals(cycle,credit.monthlyCycle);
		
	}

}
