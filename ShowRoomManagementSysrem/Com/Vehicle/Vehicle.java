package Com.Vehicle;

import java.time.LocalDate;



public class Vehicle {
	/*
	 * chasisNo(string) : Unique ID, color(enum) , netPrice(double) ,
	 * manufactureDate(LocalDate),company,isAvailable
	 */
	private String Vehicleid;
	private String fname;
	private Color color;
	private double netprice;
	LocalDate manufacturedate ;
	private String Companyname;
	private boolean isAvailable = false;
	public Vehicle(String vehicleid, String fname, Color color, double netprice, LocalDate manufacturedate, String companyname,
			boolean isAvailable) {
		super();
		Vehicleid = vehicleid;
		this.fname = fname;
		this.color = color;
		this.netprice = netprice;
		this.manufacturedate = manufacturedate;
		Companyname = companyname;
		this.isAvailable = isAvailable;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public double getNetprice() {
		return netprice;
	}
	public void setNetprice(double netprice) {
		this.netprice = netprice;
	}
	public String getCompanyname() {
		return Companyname;
	}
	public void setCompanyname(String companyname) {
		Companyname = companyname;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public String getVehicleid() {
		return Vehicleid;
	}
	public Color getColor() {
		return color;
	}
	public LocalDate getManufacturedate() {
		return manufacturedate;
	}
	@Override
	public String toString() {
		return "Vehicle [Vehicleid=" + Vehicleid + ", fname=" + fname + ", color=" + color + ", netprice=" + netprice
				+ ", manufacturedate=" + manufacturedate + ", Companyname=" + Companyname + ", isAvailable="
				+ isAvailable + "]";
	}
	@Override
	public boolean equals(Object o) {
		System.out.println("in vehicle equals");
		if (o instanceof Vehicle)
			return this.Vehicleid.equals(((Vehicle) o).Vehicleid);
		return false;
	}
	
	public int compareTo(Vehicle anotherVehicle) {
		System.out.println("in vehicle : compare to");
		//sorting criteria : chasis no : String --Comparable<String>
		//i.e has implemented compareTo : <0 , =0 , > 0 : as er uni code values!
		return this.Vehicleid.compareTo(anotherVehicle.Vehicleid);
		
	}
	
}
