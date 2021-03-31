package ie.lyit.testers;

import java.util.ArrayList;

import ie.lyit.hotel.Name;

public class NameTester {

	public static void main(String[] args) {
		Name n1 = new Name();
		System.out.println(n1);
		
		//set n1 name
		n1.setTitle("Mr");
		n1.setFirstName("Homer");
		n1.setSurname("Simpson");
		
		//display n1 details on screen
		System.out.println(n1);
		
		//Create a Name object called personB
		Name personB = new Name("Mrs", "Marge", "Simpson");
		
		//display personB details on screen
		System.out.println(personB);
		
		if(n1.equals(personB))
			System.out.println(n1 + " is the same as " + personB);
		else
			System.out.println(n1 + " is not the same as " + personB);
		
		ArrayList<Name> names = new ArrayList<Name>();
		names.add(new Name("Mr", "Bart", "Simpson"));
		names.add(n1);
		names.add(personB);
		names.trimToSize();
		
		for(Name tempName:names)
			System.out.println(tempName);
		
		if(nameSearch(n1, names))
			System.out.println("FOUND!");
		else 
			System.out.println("NOT FOUND!");
	}

    public static boolean nameSearch(Name nameSearch, ArrayList<Name> listOfNames)
    {
    	return listOfNames.contains(nameSearch);
    }
}
