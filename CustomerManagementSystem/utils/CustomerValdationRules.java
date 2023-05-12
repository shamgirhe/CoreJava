package utils;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import Com.App.Customer.Customer;
import Com.App.Customer.Plan;
import Custom_Exception.CustomerHandlingException;

public class CustomerValdationRules {

	public static Customer customervaldationrule(String firstname, String lastname, String email, String password,
			String dob,String rdate, String plan, List<Customer> customer) throws CustomerHandlingException, ParseException {

		checkgmail(email, customer);
		Plan p = planvaldation(plan);
		double registno = p.getPlancost();
		LocalDate d = checkage(dob);
		LocalDate rdate1 = date(rdate);
		return new Customer(firstname, lastname, email, password, registno,d,rdate1, p);
	}

	public static LocalDate date(String rdate) throws CustomerHandlingException{
		 LocalDate regsidate = LocalDate.parse(rdate);
		      return regsidate;
	}
	
	public static Customer checksignin(String gmail, String password, List<Customer> customer)
			throws CustomerHandlingException {
		 
		int index = customer.indexOf(new Customer(gmail));// customer.indexof(new Customer(sc.next()));
		if (index == -1) 
			throw new CustomerHandlingException(" Invalid Gmail....");
		
		Customer cindex = customer.get(index);
		if (!password.equals(cindex.getPassword()))
			throw new CustomerHandlingException("Invalid Password......");
		System.out.println("Successfully login!!!");
		return cindex;

	}

	private static LocalDate checkage(String dob) throws CustomerHandlingException, ParseException {
		LocalDate d = LocalDate.parse(dob);
		int age = Period.between(d, LocalDate.now()).getYears();
		if (age < 21) {
			throw new CustomerHandlingException("Age is more than 21 is required..");
		}
		return LocalDate.parse(dob);
	}

	public static Plan planvaldation(String plan) {
		return Plan.valueOf(plan.toUpperCase());
	}

	public static void checkgmail(String email, List<Customer> customer) throws CustomerHandlingException {
		Customer newgmail = new Customer(email);
		for (Customer c : customer) {

			if (c.equals(newgmail)) {
				throw new CustomerHandlingException("Gmail is repated.... Enter New Gmail");
			}


		}

	}

}
