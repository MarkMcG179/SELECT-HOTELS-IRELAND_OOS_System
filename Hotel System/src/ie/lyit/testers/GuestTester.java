package ie.lyit.testers;

import ie.lyit.hotel.Guest;
import ie.lyit.hotel.Name;

public class GuestTester {

	public static void main(String[] args)
	{
		// Create a Guest object called g1
		Guest g1 = new Guest();
		
		// display g1's details on screen
		System.out.println(g1);
		
		g1.setName(new Name("Mrs", "Marge", "Simpson"));
		g1.setPhoneNumber("087 1234567");
		g1.setEmailAddress("marge.simpson@lyit.ie");
		
		// display g1's details on screen
		System.out.println(g1);
		
		// Create a Guest object called g2 with initial values
		Name nameA = new Name("Mr", "Homer", "Simpson");
		Guest g2 = new Guest(nameA, "086 1234567", "homer.simpson@lyit.ie");
		
		System.out.println(g2);
		
		// check if g1 is Male or Female
		if(g1.getName().isFemale())
			System.out.println(g1.getName() + " is Female");
		else
			System.out.println(g1.getName() + " is Male");
		
	}
}
