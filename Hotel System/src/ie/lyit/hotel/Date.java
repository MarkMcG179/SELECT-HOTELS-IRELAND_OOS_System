package ie.lyit.hotel;

import java.io.Serializable;

public class Date implements Serializable {
private int day;
private int month;
private int year;

public Date()
{
	day=1;
	month=1;
	year=1900;
}

public Date(int d, int m, int y) throws IllegalArgumentException{
	if(day < 1 || day > 31 || month < 1 || month > 12 || year < 1900)
		throw new IllegalArgumentException("Invalid Date.");
	day=d;
	month=m;
	year=y;
}

public String toString()
{
	return day + " /" + month + " /" + year;
}

public boolean equals(Object obj)
{
	Date dObject;
	if(obj instanceof Date)
		dObject = (Date)obj;
	else
		return false;
	
	return this.day == dObject.day
	&& this.month == dObject.month
	&& this.year == dObject.year;
}

//get() methods
public int getDay()
{
	return day;
}

public int getMonth()
{
	return month;
}

public int getYear()
{
	return year;
}

//set() methods
public void setDay(int setDayTo) throws IllegalArgumentException{
	if(setDayTo < 1 || setDayTo > 31)
		//ERROR
		throw new IllegalArgumentException("Invalid Day.");
	
	day = setDayTo;
}

public void setMonth(int setMonthTo) throws IllegalArgumentException{
	if(setMonthTo < 1 || setMonthTo > 12)
		//ERROR
		throw new IllegalArgumentException("Invalid Month.");
	month = setMonthTo;
}

public void setYear(int setYearTo) throws IllegalArgumentException{
	if(setYearTo < 1900)
		//ERROR
		throw new IllegalArgumentException("Invalid Year.");
	year = setYearTo;
}

}
