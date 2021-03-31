package ie.lyit.hotel;

public class Booking{
private Date checkInDate;
private Guest guestDetails;
private Room roomAllocated;
private int noNights;
private int noAdults;
private int noKids;
private double totalPrice;
private int bookingNo;
private static int nextUniqueBookingNumber=120000;
	
	public Booking(Date checkInDate, int noNights, int noAdults, int noKids, Guest guestDetails)
	{
		if(noAdults < 1 || noAdults > 2 || noKids < 0 || noKids > 3)	
			throw new IllegalArgumentException("Invalid Booking.");
		this.checkInDate = checkInDate;
		this.noNights = noNights;
		this.noAdults = noAdults;
		this.noKids = noKids;
		this.guestDetails = guestDetails;
		this.bookingNo = nextUniqueBookingNumber++;
	}
	
	@Override
	public String toString()
	{
		return  "BOOKING " +bookingNo+ "==>" +guestDetails+ " from " +checkInDate+ " for " +noNights+ " nights.";  
	}
	
	public boolean equals(Object obj)
	{
		Booking bObject;
		if(obj instanceof Booking)
			bObject = (Booking)obj;
		else
			return false;
		
		return this.bookingNo == bObject.bookingNo;
	}

}
