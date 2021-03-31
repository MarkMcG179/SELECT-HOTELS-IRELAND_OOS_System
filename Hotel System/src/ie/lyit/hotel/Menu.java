package ie.lyit.hotel;

import java.util.*;

import javax.swing.JOptionPane;

public class Menu {
	private int option;
	
	public Menu() {
		option=0;
	}
	
	public void display() {
		System.out.println("EMPLOYEE MENU\n");
		System.out.println("1. Add");
		System.out.println("2. List");
		System.out.println("3. View");
		System.out.println("4. Edit");
		System.out.println("5. Delete");
		System.out.println("6. Quit");
	}
	
	public void readOption() {
	boolean goodInput = false;
	 do {	//repeat this 'Enter Option' pane 
		try {
			Scanner kbInt = new Scanner(System.in);
			System.out.println("\nEnter Option [1|2|3|4|5|6]:");
			option=kbInt.nextInt();
			goodInput = true;
			}
		catch(InputMismatchException e) {
			System.out.println("Please enter an integer between 1-6.");
		}
	 }while(!goodInput);	//while the user input is not an integer
}
	
	public int getOption() {
		return option;
	}

}

