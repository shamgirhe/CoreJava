package utils;

import java.util.ArrayList;
import java.util.List;
import static utils.CustomerValdationRules.*;
import Com.App.Customer.Customer;

public class Customerutils {
	
    public static List<Customer> customer(){	
	//SILVER(1000),GOLD(2000),DIAMOND(5000),PLATINUM(10000);
    	try {
		ArrayList<Customer> customer = new ArrayList<>();
  
     customer.add(customervaldationrule("sham","Girhe","Sham@","sham", "2001-01-01","2023-01-01","gold",customer));
     customer.add(customervaldationrule("ram","Girhe","ram@","ram", "2001-02-17","2023-02-13","platinum",customer));
     customer.add(customervaldationrule("utkarsh","rane","utk@","utk", "2001-02-03","2023-01-01","diamond",customer));
     customer.add(customervaldationrule("aniket","gonajare","aniket@","aniket", "2000-12-12","2023-04-15","silver",customer));
     customer.add(customervaldationrule("darshan","patil","darshan@","darshan", "2001-02-12","2023-03-11","platinum",customer));
     customer.add(customervaldationrule("nikhil","bhosale","nikhil@","nikhil", "2000-12-12","2023-02-18","gold",customer));
     customer.add(customervaldationrule("balaji","gaphat","balaji@","balaji", "2000-05-14","2023-01-17","gold",customer));
     return customer;
	}catch (Exception e) {
		e.printStackTrace();
	
	}
    	return null;
}


}
