package ie.lyit.seralize;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import ie.lyit.hotel.Employee;

public class EmployeeSerializer{
private ArrayList<Employee> employees;
	
	final String FILENAME = "employees.ser";	
	
	// Default Constructor
	public EmployeeSerializer()
	{
		// Construct employees ArrayList
		employees = new ArrayList<Employee>();
	}
		
	public void add()
	{
		// Create an Employee object
		Employee employee = new Employee();
		// Read its details
		employee.read();	
		// And add it to the employees ArrayList
		employees.add(employee);
	}
	
	public void list()
	{
		// for every Employee in employees
        for(Employee tmpE:employees)
			// display it
			System.out.println(tmpE);
	}	
	
	public Employee view() {
		Scanner keyIn = new Scanner(System.in);
		try {
			System.out.println("ENTER EMPLOYEE NUMBER: ");
			int employeeToView=keyIn.nextInt();
		
			//Loop around for every Book object in the ArrayList
			for(Employee tmpE:employees) {
				//If its key field equals the key field of the Book to be viewed
				if(tmpE.getNumber() == employeeToView) {
					//Display the object on screen
					System.out.println(tmpE);
					//And return it
					return tmpE;			
				}
			}
		}
		catch(InputMismatchException e) {
			System.out.println("Please enter an appropriate employee number!");
		}
		return null;
	}
	
	public void edit() {
		//Call the view method to find, display and return the Book to be edited
		Employee tmpE = view();
		//If the Book to be edited != null
		if(tmpE != null) {
			int index=employees.indexOf(tmpE);
			//Read in new details for it by calling its read() method
			tmpE.read();
			//Reset it in the ArrayList to this new 
			employees.set(index,tmpE);
		}
	}
	
	public void delete() {
		//Call the view() method to find,display and return the Employee to be deleted 
		Employee tempE=view();
		//If the Book to be deleted != null
		if(tempE != null)
			//Delete it from the ArrayList by calling the ArrayList remove() method
			employees.remove(tempE);
	}
	
	public void serializeEmployees(){
		ObjectOutputStream os=null;
		try {
			Path p=Paths.get(FILENAME);
			
			if(Files.exists(p)) {	//file exists do...
				// Serialize the ArrayList...
				FileOutputStream fileStream = new FileOutputStream(FILENAME);
				
				os = new ObjectOutputStream(fileStream);
				
				os.writeObject(employees);
			}
			
			else {		//file doesn't exist do...
				System.out.println("File "+p.getFileName()+" doesn't exist.");
			}
				
		}
		catch(FileNotFoundException fNFE){
			System.out.println("Cannot create file " + FILENAME + ".");
		}
		catch(IOException ioE){
			System.out.println(ioE.getMessage());
		}
		finally {
			try {
				os.close();
			}
			catch(IOException ioE){
				System.out.println(ioE.getMessage());
			}
		}
	}
	
	public void deserializeEmployees(){
		ObjectInputStream is=null;
		
		try {
			Path p = Paths.get(FILENAME);
			
			if(Files.exists(p)) {	//file exists do..
				// Deserialize the ArrayList...
				FileInputStream fileStream = new FileInputStream(FILENAME);
			
				is = new ObjectInputStream(fileStream);
					
				
				employees = (ArrayList<Employee>)is.readObject();	
				
				//get the last element of the arraylist & set it to setNextNumber 
				Employee setNextNumber = employees.get(employees.size() - 1);
				
				//set the static variable nextNumber to the next number after the last element's number
				Employee.nextNumber = setNextNumber.getNumber() + 1;
			}
			
			else {		//file doesn't exist do..
				System.out.println("File "+p.getFileName()+" doesn't exist.");
			}
		
		}
		catch(FileNotFoundException fNFE){
			System.out.println("Cannot create file " + FILENAME + ".");
		}
		catch(IOException ioE){
			System.out.println(ioE.getMessage());
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		finally {
			try {
				is.close();
			}
			catch(IOException ioE){
				System.out.println(ioE.getMessage());
			}
		}
	}	
	
}
