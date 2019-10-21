package test.expenseManager;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import expenseManager.Period;

class PeriodTest {

	@Test
	void getPeriodInDaysTest() {
		assertEquals(1, Period.getPeriodInDays(Period.DAILY));
		assertEquals(7, Period.getPeriodInDays(Period.WEEKLY));
		assertEquals(14, Period.getPeriodInDays(Period.BIWEEKLY));
		assertEquals(30.44, Period.getPeriodInDays(Period.MONTHLY));
		assertEquals(91.31, Period.getPeriodInDays(Period.QUARTERLY));
		assertEquals(365.24, Period.getPeriodInDays(Period.ANNUALY));
	}
}
