package ie.lyit.hotel;

import java.io.Serializable;

public abstract class Person implements Serializable {
	protected Name name;
	protected String phoneNumber;
	
	// Default Constructor
	public Person()
	{
		name=new Name();
		phoneNumber="";
	}
	
	// Overloaded Intialisation
	public Person(Name name, String phoneNumberIn) 
	{
		this.name=name;
		phoneNumber=phoneNumberIn;
	}

	@Override
	public String toString()
	{
		return name + " " + phoneNumber;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		Person pObj;
		if (obj instanceof Person)
			pObj=(Person)obj;
		else
			return false;
		
		return(this.name.equals(pObj) &&
			   this.phoneNumber.contentEquals(pObj.phoneNumber));
	}
	
	public void setName(Name nameIn)
	{
		name = nameIn;
	}
	
	public Name getName()
	{
		return name;
	}
	
	public void setPhoneNumber(String phoneNumberIn)
	{
		phoneNumber = phoneNumberIn;
	}
	
	public String getPhoneNumber()
	{
		return phoneNumber;
	}
}

