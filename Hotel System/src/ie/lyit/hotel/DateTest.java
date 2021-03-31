package ie.lyit.hotel;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DateTest {
	private Date d1;

	@Before
	public void setUp() throws Exception {
		d1 = new Date();
	}

	@Test
	public void testDate() {
		// Check d1’s day is 1
		assertEquals(1, d1.getDay());
		// Check d1’s month is 1, if it is not display appropriate message
		 assertEquals("Month should be 1", 1, d1.getMonth());
		// Check d1’s year is 1900, if it is not display appropriate message
		assertEquals("Year should be 1900", 1900, d1.getYear());
	}
	@Test
	public void testToString() {
		assertEquals("Date should be 1/1/1900","1/1/1900",d1.toString());
	}

	@Test
	public void testDateIntIntInt() {
		d1=new Date(5,6,2020);
		// Check d1’s day is 1
		assertEquals(5, d1.getDay());
		// Check d1’s month is 1, if it is not display appropriate message
		assertEquals("Month should be 6", 6, d1.getMonth());
		// Check d1’s year is 1900, if it is not display appropriate message
		assertEquals("Year should be 2020", 2020, d1.getYear());
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testDateIntIntIntForException() {
		d1=new Date(33,12,2020);
	}
	
	@Test
	public void testSetDay() {
		d1.setDay(15);
		assertEquals("Expected 15",15,d1.getDay());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSetDayForException() {
		d1.setDay(35);
	}

	@Test
	public void testSetMonth() {
		d1.setMonth(12);
		assertTrue("Month should be 12",12==d1.getMonth());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSetMonthForException() {
		d1.setMonth(22);
	}

	@Test
	public void testSetYear() {
		d1.setYear(2020);
		assertTrue("Year should be 2020", 2020==d1.getYear());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSetYearForException() {
		d1.setYear(1800);
	}

}
