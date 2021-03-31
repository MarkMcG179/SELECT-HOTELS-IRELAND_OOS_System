package ie.lyit.testers;

import java.util.*;
import javax.swing.*;

import ie.lyit.hotel.Booking;
import ie.lyit.hotel.Guest;
import ie.lyit.hotel.Name;
import ie.lyit.hotel.Room;

public class BookingTester {

	public static void main(String[] args) {
		int noNights=2;
		
		ArrayList<Booking> bookings = new ArrayList<Booking>();
		Date checkInDate = new Date(5,10,2020);
		
		Guest guestDetails = new Guest(new Name("Mr", "Joe", "Cole"),"087 1234567", "joe@lyit.ie");
		//bookings.add(checkInDate, noNights, noAdults, noKids, guestDetails);
		boolean goodInput = false;
		do{
			try{
				String adultsAsString=JOptionPane.showInputDialog("How many Adults? ",null);
						 int noAdults=Integer.parseInt(adultsAsString);
				String kidsAsString=JOptionPane.showInputDialog("How many Kids? ",null);
						 int noKids=Integer.parseInt(kidsAsString);
			    goodInput = true;
			}
			catch(IllegalArgumentException e){
				JOptionPane.showMessageDialog(null,"Incorrect number of Adults and Kids, re-enter:");
			}
		 
		 }while(!goodInput);
		
		//bookings.add(checkInDate, noNights, noAdults, noKids, guestDetails);
		
		for(Booking tempBooking:bookings)
			System.out.println(tempBooking);

	}

}
