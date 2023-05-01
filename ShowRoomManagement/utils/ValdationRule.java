package utils;

import java.time.LocalDate;
import Com.Vehicle.Color;
import Com.Vehicle.Vehicle;
import Custom_Exception.VehicleHandlingExcption;


public class ValdationRule {

 
  
	public static Vehicle valdationrulevehicle(String chasisno, String color, double netprice, 
		String localdate, String company, Vehicle[] vehicle) throws VehicleHandlingExcption {
	
	    checkForDuplicate(chasisno , vehicle);
	    Color validcolor = valdationrule(color);
	    double validnet= netprice + validcolor.getCost();
	    LocalDate date = parsevaldation(localdate);
	
		return new Vehicle(chasisno, validcolor, validnet, date, company);
	
}

public static LocalDate parsevaldation(String localdate) throws VehicleHandlingExcption {
	LocalDate d1 = LocalDate.parse(localdate);
	LocalDate beginYear = LocalDate.of(LocalDate.now().getYear(), 1, 1);
	if (d1.isAfter(beginYear))
		return d1;
	throw new VehicleHandlingExcption("Vehicle manufacture date must be after 1st Jan of the curnt year");
}

public static Color valdationrule(String color) {
	 
	return Color.valueOf(color.toUpperCase());
}

public static void checkForDuplicate(String newchasisno, Vehicle[] vehicles) throws VehicleHandlingExcption {
	Vehicle newvehicles=new Vehicle(newchasisno);
	for(Vehicle v : vehicles)
	{
		if(v!=null)
			if(v.equals(newvehicles))
			{
				throw new VehicleHandlingExcption("Vehicles Cheasis no is not Unique...");
			}
		else
			System.out.println("Vehicles Cheasis no is Unique...");
	}
}
	
}
