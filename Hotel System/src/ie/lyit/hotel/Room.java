package ie.lyit.hotel;

public class Room {
private int maxAdults;
private int maxKids;
private double pricePerNight;
private boolean allocated;
private int number;

public Room(int maxAdults, int maxKids, double pricePerNight, int number)
{
	if(maxAdults < 1 || maxAdults > 2 || maxKids < 0 || maxKids > 3)	
		throw new IllegalArgumentException("Invalid Room.");
	this.maxAdults = maxAdults;
	this.maxKids = maxKids;
	this.pricePerNight = pricePerNight;
	this.allocated = false;
	this.number = number;
}

@Override
public String toString()
{
	return  "ROOM " +number+ "[" +maxAdults+ " adult(s), " +maxKids+ " kid(s), @" + "€" +pricePerNight+ " p/n, " +allocated+" allocated]";  
}

public boolean equals(Object obj)
{
	Room rObject;
	if(obj instanceof Room)
		rObject = (Room)obj;
	else
		return false;
	
	return this.maxAdults == rObject.maxAdults
	&& this.maxKids == rObject.maxKids
	&& this.pricePerNight == rObject.pricePerNight
	&& this.number == rObject.number;
}

//set() methods
public void setMaxAdults(int maxAdultsIn)
{
	this.maxAdults=maxAdultsIn;
}
	
public void setMaxKids(int maxKidsIn)
{
	this.maxKids=maxKidsIn;
}
	
public void setMaxaAdults(int maxAdultsIn)
{
	this.maxAdults=maxAdultsIn;
}

public void setPricePerNight(double pricePerNightIn)
{
	this.pricePerNight=pricePerNightIn;
}

public void setAllocated(boolean allocatedIn)
{
	this.allocated=allocatedIn;
}

}
