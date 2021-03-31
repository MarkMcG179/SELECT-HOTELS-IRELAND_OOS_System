package ie.lyit.hotel;

import java.io.Serializable;

public class Name implements Serializable{
private String title;
private String firstName;
private String surname;

//Constructors to intialise the Instance Variables

//Default Constructor
public Name()
{
	title=firstName=surname=null;
}

//Intialisation Constructor
public Name(String t, String fN, String sN)
{
	title=t;
	firstName=fN;
	surname=sN;
}

//toString() method
public String toString()
{
	return title + " " + firstName + " " + surname;
}

//equals() method
@Override
public boolean equals(Object obj)
{
	Name nObject;
	if(obj instanceof Name)
		nObject = (Name)obj;
	else
		return false;
	
	return this.title.equals(nObject.title)
	&& this.firstName.equals(nObject.firstName)
	&& this.surname.equals(nObject.surname);
}

//get() methods
public String getTitle()
{
	return title;
}

public String getFirstName()
{
	return firstName;
}

public String getSurname()
{
	return surname;
}

//set() methods
public void setTitle(String setTitleTo)
{
	title=setTitleTo;
}

public void setFirstName(String setFirstNameTo)
{
	firstName=setFirstNameTo;
}

public void setSurname(String setSurnameTo)
{
	surname=setSurnameTo;
}

public boolean isFemale()
{
	if(title.equalsIgnoreCase("Miss") ||
	   title.equalsIgnoreCase("Ms") ||
	   title.equalsIgnoreCase("Mrs"))
		return true;
	
	else
		return false;
}

}
