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
		String newDescription = "Work1";
		Credit credit = new Credit(newAmount,newDescription, today);
		assertEquals(newAmount, credit.amount); 
		assertEquals(today, credit.date); 
		assertEquals(newDescription,credit.description);
		
	}

}
