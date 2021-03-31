package ie.lyit.testers;

import ie.lyit.hotel.Menu;
import ie.lyit.seralize.EmployeeSerializer;

public class EmployeeSerializerTester {

	public static void main(String[] args) {
		EmployeeSerializer employeeSerializer = new EmployeeSerializer();
		
		// Read the ArrayList from the File
		employeeSerializer.deserializeEmployees();
		
		Menu menuObj=new Menu();
		menuObj.display();
		
		do {
			menuObj.readOption();
			switch(menuObj.getOption()) {
				case 1:	employeeSerializer.add(); break;
				case 2:	employeeSerializer.list(); break;
				case 3:	employeeSerializer.view(); break;
				case 4:	employeeSerializer.edit(); break;
				case 5:	employeeSerializer.delete(); break;
				case 6:	break;
				default:System.out.println("INVALID OPTION...");
			}
		}while(menuObj.getOption() != 6);
		
		// Write the ArrayList to the file 
		employeeSerializer.serializeEmployees();
		
	
	
	}
	
}
