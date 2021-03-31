package ie.lyit.hotel;

public class Guest extends Person {
	private String emailAddress;
	
	//Default constructor
	public Guest()
	{
		super();	//NOTE - Don't need to call super() explicitily
		emailAddress="";
	}

	//Overloaded Intialisation Constructor
	public Guest(Name name, String phoneNumber, String emailAddress)
	{
		super(name, phoneNumber);
		this.emailAddress=emailAddress;
	}
	
	public String toString()
	{
		return super.toString() + " " + emailAddress + ".";
	}
	
	//Don't need to overrdie Person's equals because
	//name and phoneNumber are sufficient mwhen comparing two Guest objects
	
	//set() and get() methods
	public void setEmailAddress(String emailAddress)
	{
		this.emailAddress=emailAddress;
	}
	
	public String getEmailAddress()
	{
		return this.emailAddress;
	}

}
