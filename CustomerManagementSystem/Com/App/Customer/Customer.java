package Com.App.Customer;

import java.time.LocalDate;




public class Customer implements Comparable<Customer> {
 private static int cutcount;
 static
 {
	 cutcount=1000;
 }
 public Customer(String gmail, String password) {
	super();
	this.gmail = gmail;
	Password = password;
}

public String getGmail() {
	return gmail;
}

public void setGmail(String gmail) {
	this.gmail = gmail;
}

public String getPassword() {
	return Password;
}

public void setPassword(String password) {
	Password = password;
}

private int customerid;
 private String firstname;
 private String lastname;
 private String gmail;
 private String Password;
 private double registrationamount;
 private LocalDate dob;
 private LocalDate registrationdate;
 private Plan plan;
 
 
public Customer( String firstname, String lastname,String gmail, String password, double registrationamount,
		LocalDate dob,LocalDate registrationdate, Plan plan) {
	super();
	this.customerid = ++cutcount;
	this.firstname = firstname;
	this.lastname = lastname;
	this.gmail=gmail;
	Password = password;
	this.registrationamount = registrationamount;
	this.dob = dob;
	this.registrationdate=registrationdate;
	this.plan = plan;
}

public LocalDate getRegistrationdate() {
	return registrationdate;
}

public void setRegistrationdate(LocalDate registrationdate) {
	this.registrationdate = registrationdate;
}

public String getFirstname() {
	return firstname;
}

public void setFirstname(String firstname) {
	this.firstname = firstname;
}

public String getLastname() {
	return lastname;
}

public void setLastname(String lastname) {
	this.lastname = lastname;
}

public Customer(String gmail)
{
	this.gmail=gmail;
}

@Override
public String toString() {
	return "CustomerInfo [customerid=" + customerid + ", firstname=" + firstname + ", lastname=" + lastname + ", gmail="
			+ gmail + ", registrationamount=" + registrationamount + ", dob=" + dob
			+ ", registrationdate=" + registrationdate + ", plan=" + plan + "]";
}
 
@Override
public boolean equals(Object o)
{
	if(o instanceof Customer)
		return this.gmail.equals(((Customer) o).gmail);
	return false;
}

@Override 
public int compareTo(Customer anothercustomer) {
	return anothercustomer.gmail.compareTo(this.gmail);
}

public double getRegistrationamount() {
	return registrationamount;
}

public void setRegistrationamount(double registrationamount) {
	this.registrationamount = registrationamount;
}

public LocalDate getDob() {
	return dob;
}

public void setDob(LocalDate dob) {
	this.dob = dob;
}
	
}
