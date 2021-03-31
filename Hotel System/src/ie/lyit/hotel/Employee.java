package ie.lyit.hotel;

import java.io.Serializable;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;

public class Employee extends Person implements Payable, Serializable{
	//private Date dob;			// Employee has a name & phoneNumber from Person 
	//private Date startDate;	// AND dob, startDate, salary, & number
	private double salary = 0.0;
	private int number;
    
	public static int nextNumber=10000;
 
	// Default Constructor
	// Called when object is created like this ==> 
	//    Employee e1 = new Employee();	
	public Employee() {
		super();	// NOTE:Don't have to put this in, it will be called anyway
		//dob=new Date();
		//startDate=new Date();													//Commented out for testing
		salary=0.0;
		// Set number to static nextNumber before incrementing nextNumber
		number=nextNumber++;
	}

   // Overloaded Initialization Constructor
	// Called when object is created like this ==>
	//	  Name name = Name("Mr","Joe","Doe");
	//    Employee e2 = new Employee(name,"087 1234567",
   //								         new Date(25,12,1970),new Date(10,11,2009),55000);
	public Employee(Name name, String phoneNumber, Date dob, Date startDate, double salary) {
	    // Call super class constructor, passing fields required by Person
		super(name, phoneNumber);
		//this.dob=dob;
		//this.startDate=startDate;					//Commented out for testing
		this.salary=salary;
		this.number=nextNumber++;		
	}
	
	// OVERRIDING the Person toString() method
	// to make it more specific to Employee
	//   10001 Mr Joe Doe		087 1234567		€36000.00
	@Override
	public String toString() {
		return number + " " + super.toString() + "\t€" + salary;
	}
	
	// equals() method
	// ==> Called when comparing one Employee with another
	//     if(e1.equals(e2))
	// Because Employee has a unique number then it is sufficient to compare the number field
	@Override
	public boolean equals(Object obj) {
		Employee eObj;
		if(obj instanceof Employee)
			eObj = (Employee)obj;
		else 
		   return false;
		
		return (this.number==eObj.number);
	}
	
	// set() and get() methods
	//public void setDOB(Date dob){
		//this.dob=dob;
	//}
	//public Date getDOB(){
		//return dob;
	//}
	//public void setStartDate(Date startDate){		//Commented out for testing
		//this.startDate=startDate;
	//}
	//public Date getStartDate(){
		//return startDate;
	//}	
	public void setSalary(double salary){
		this.salary=salary;
	}
	public double getSalary(){
		return salary;
	}
	// You shouldn't be able to setNumber() as it is unique, 
	// so don't provide a setNumber() method
	public int getNumber(){
		return number;
	}			
	
	@Override
	public double calculatePay(double taxPercentage) {
		// return the monthly pay as salary/12 less taxPercentage
		double pay=salary/12;
		pay -= (pay * (taxPercentage/100));
		return pay;
	}

	@Override
	public double incrementSalary(double incrementAmount) {
		// add incrementAmount to, and return the new salary
		// salary should not go over a maximum salary of €150,000
		salary += incrementAmount;
			
		if(salary > MAX_SALARY)
			salary = MAX_SALARY;
			
		return salary;
	}
	
	// read() - To read an employee from the user	
	   public void read(){
	   boolean goodInput = false;
		  JTextField txtEmployeeNo = new JTextField();
		  txtEmployeeNo.setEditable(false); //makes the textfield inaccessible to the user to edit.
	      txtEmployeeNo.setText("" + this.getNumber());
	      JTextField txtTitle = new JTextField();
	      JTextField txtFName = new JTextField();
	      JTextField txtSName = new JTextField();
	      txtFName.requestFocus();		//txtFName gets the input focus
	      JTextField txtPNumber = new JTextField();
	      JTextField txtSalary = new JTextField();
	    
	      do {
	      Object[] message = {
	          "Employee Number:", txtEmployeeNo,
	          "Employee Title:", txtTitle,
	          "Employee First Name:", txtFName,
	          "Employee Surname:", txtSName,
	          "Phone Number:", txtPNumber,
	          "Salary:", txtSalary,
	      };
	      
	      int option = JOptionPane.showConfirmDialog(null, message, "Enter employee details", JOptionPane.OK_CANCEL_OPTION);

	      if (option == JOptionPane.OK_OPTION){
	    	  try {
	    		  if(txtTitle.getText().trim().isEmpty() || txtFName.getText().trim().isEmpty() || txtSName.getText().trim().isEmpty() || 
	 	    		     txtPNumber.getText().trim().isEmpty() || txtSalary.getText().trim().isEmpty()) {
	 	    			  throw new NullPointerException();		//if any textfield is left blank by the user, an 'IllegalArgumentException will be thrown
	 	    		  }
	 	    		  
	 	    		  else if(stringContainsNumber(txtTitle.getText()) == true || //if there is a number in 'Title'
	 	    				  stringContainsLetter(txtTitle.getText()) == false || //if there isn't a letter in 'Title'
	 	    				  stringContainsNumber(txtFName.getText()) == true || //if there is a number in 'First Name'
	 	    				  stringContainsLetter(txtFName.getText()) == false || //if there isn't a letter in 'First Name'
	 	    				  stringContainsNumber(txtSName.getText()) == true || //if there is a number in 'Surname'
	 	    				  stringContainsLetter(txtSName.getText()) == false || //if there isn't a letter in 'Surname'
	 	    		          stringContainsNumber(txtPNumber.getText()) == false || //if there isn't a number in 'Phone Number'
	 	    		          stringContainsLetter(txtPNumber.getText()) == true){  //if there is a letter in 'Title'
	 	    			  throw new IllegalArgumentException();
	 	    		  }
	    		  
	 	    		  else {
	 	    			  this.number = Integer.parseInt(txtEmployeeNo.getText()); //converts the string to int 
	 	    			  this.name = new Name(txtTitle.getText(), txtFName.getText(), txtSName.getText()); //uses the Strings as parameters, to construct a Name object
	 	    			  this.phoneNumber = txtPNumber.getText();
	 	    			  this.salary = Double.parseDouble(txtSalary.getText());   //converts the string to int
	 	    			  goodInput = true;
	 	    		  }
	    	  }
	    		  
	    	  catch(NumberFormatException e) { //throws the exception if an integer is not entered into field 'Salary'.
	    		  JOptionPane.showMessageDialog(null, "An integer is required for input field Salary!");
	    	  }
	    	  
	    	  catch(NullPointerException e) { //throws the exception if a field is not filled out.
	    		  JOptionPane.showMessageDialog(null, "You did not fill out a field. Please try again!");
	    	  }
	    	  
	    	  catch(IllegalArgumentException e) { //throws the exception if a field has the incorrect data in it.
	    		  JOptionPane.showMessageDialog(null, "Please enter each field with the correct set of data!");
	    	  }
	    	  
	      }
		}while(!goodInput);
	 }
	   
	  public boolean stringContainsNumber(String s) {		//aggregates through the string to check if there are any numbers within it
		  
		  for(int i=0; i<=s.length()-1; i++) {
			  if(s.charAt(i) >= '0' && s.charAt(i) <= '9') {	//if the character is greater than or equal to 0 or less than or equal to 9, return true
				  return true;
			  }
		  }
		  return false;
	  }
	  
	  public boolean stringContainsLetter(String s) {	//aggregates through the string to check if there are any number within it 
		  for(int i=0; i<=s.length()-1; i++) {
			  if(Character.isLetter(s.charAt(i))){		//if the character is a letter, return true
				  return true;
			  }
		  }
		  return false;
	  }
}

	  	  
	  

