package ie.lyit.testers;

import ie.lyit.hotel.Date;


public class DateTester {

	public static void main(String[] args) {
		Date d1 = new Date();
		System.out.println(d1);
		
		//set d1 date
		d1.setDay(18);
		d1.setMonth(3);
		d1.setYear(2001);
		
		//display d1 details
		System.out.println(d1);
		
		//Create a Date object called d2
		Date d2 = new Date(18, 3, 2001);
		
	    if(d1.equals(d2))
	    {
	    	System.out.println(d1 + " is the same as " + d2);
	    }
	    
	    else
	    {
	    	System.out.println(d1 + " is not the same as " + d2);
	    }
				
	}

}
