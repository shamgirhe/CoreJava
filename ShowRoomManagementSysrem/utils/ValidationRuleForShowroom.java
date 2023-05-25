package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import Com.Vehicle.Color;
import Com.Vehicle.Vehicle;
import Showroom_Exception.ShowroomException;

public class ValidationRuleForShowroom {
	/*
	 * chasisNo(string) : Unique ID, color(enum) , netPrice(double) ,
	 * manufactureDate(LocalDate),company,isAvailable
	 */
	
public static Vehicle validationcheck(String Vehicleid,String fname, String color , double netprice,
		String manufacturedate, String company,Map<String, Vehicle> vehicle) throws ShowroomException
{	   		
	 checkduplicate(Vehicleid , vehicle);
	 Color validcolor = checkcolor(color);
	 double validprice = netprice+validcolor.getprice();
	 LocalDate localdate = checkdate(manufacturedate);
	 return new Vehicle(Vehicleid, fname, validcolor, validprice, localdate, company, true);
	
}

private static LocalDate checkdate(String manufacturedate) throws ShowroomException {
	
		return LocalDate.parse(manufacturedate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));	
		
	}

public static Color checkcolor(String color) {
		
		return Color.valueOf(color.toUpperCase());
	}

public static void checkduplicate(String vehicleid, Map<String, Vehicle> vehicle) throws ShowroomException {
	if (vehicle.containsKey(vehicleid))
		 throw new ShowroomException("Duplicate vehicle id.");
	
}
	
	
	
}
