package ie.lyit.testers;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import ie.lyit.hotel.*;
public class ExceptionHandlerDemo {

	public static void main(String[] args) {
		ArrayList<Person> hotelGuests = new ArrayList<Person>();
		
		Name n1 = new Name("Mr","Mark", "Harkin");
		Guest g1 = new Guest(n1, "087 1234567", "mark.harkin@pramerica.com");
		
		Name n2 = new Name("Mr","Shawn", "Dobbyn");
		Guest g2 = new Guest(n2, "086 1234567", "shawn.dobbyn@pramerica.com");
		
		Name n3 = new Name("Mrs","Amy", "Magee");
		Guest g3 = new Guest(n3, "084 1234567", "amy.magee@pramerica.com");
		
		hotelGuests.add(g1);
		hotelGuests.add(g2);
		hotelGuests.add(g3);
		
		String guestNumberToViewAsString="";
		boolean goodInput=false;
		do {
			try {
				guestNumberToViewAsString=JOptionPane.showInputDialog(null, 
						"Enter Guest to View("+1+" to " +hotelGuests.size()+")");
		
				int guestNumberToView=Integer.parseInt(guestNumberToViewAsString);
				JOptionPane.showMessageDialog(null, hotelGuests.get(guestNumberToView-1));
				goodInput=true;
			}
			catch(NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, guestNumberToViewAsString + " is not a valid number, please re-enter.");
			}
			catch(IndexOutOfBoundsException iobe) {
				JOptionPane.showMessageDialog(null, "You must choose a guest from (" + 1 + " to " + hotelGuests.size() + ")" + ", please re-enter.");
			}
	    
		}while(!goodInput);
		
		int day=55,month=13,year=200;
		Date d1=new Date();
		
	do {
		try {
			d1.setDay(day);
			d1.setMonth(month);
			d1.setYear(year);
			JOptionPane.showMessageDialog(null, d1);
		}
		catch(IllegalArgumentException iae) {
			JOptionPane.showMessageDialog(null, "Invalid Date, re-enter.");
			
			String dayAsString=JOptionPane.showInputDialog(null, "Day (1 - 31):");
			day = Integer.parseInt(dayAsString);
			String monthAsString=JOptionPane.showInputDialog(null, "Month (1 - 12):");
			month = Integer.parseInt(monthAsString);
			String yearAsString=JOptionPane.showInputDialog(null, "Year (Not less than 1900):");
			year = Integer.parseInt(yearAsString);
		}
	}while(!goodInput);
	
	day=62;month=15;year=10;
	
	do {
		try {
			Date d2=new Date(day,month,year);
			JOptionPane.showMessageDialog(null, d2);
		}
		catch(IllegalArgumentException iae) {
			JOptionPane.showMessageDialog(null, "Invalid Date, re-enter.");
			
			String dayAsString=JOptionPane.showInputDialog(null, "Day (1 - 31):");
			day = Integer.parseInt(dayAsString);
			String monthAsString=JOptionPane.showInputDialog(null, "Month (1 - 12):");
			month = Integer.parseInt(monthAsString);
			String yearAsString=JOptionPane.showInputDialog(null, "Year (Not less than 1900):");
		}
	}while(!goodInput);
	}
}
