package ie.lyit.hotel;

public interface Payable{
    public final double MAX_SALARY = 150000.00;	
	
    public abstract double calculatePay(double taxPercentage);
	// Don't have to put in public abstract
	double incrementSalary(double incrementAmount);
}

// A Java interface can contain only abstract 
// methods, i.e. methods without a body and constants.