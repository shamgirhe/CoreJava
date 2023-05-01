package Com.Vehicle;

import java.time.LocalDate;



public class Vehicle {
/*chasisNo(string) : Unique ID, color(enum) , netPrice(double) ,
	 * manufactureDate(LocalDate),company,isAvailable*/
 private String chasisno;
 private Color color;
 private double netprice;
 private LocalDate localdate;
 private String company;
 private boolean isavil;
public Vehicle(String chasisno, Color color, double netprice, LocalDate localdate, String company) {
	super();
	this.chasisno = chasisno;
	this.color = color;
	this.netprice = netprice;
	this.localdate = localdate;
	this.company = company;
	this.isavil = true;
}
public Vehicle(String chasisno) {
	this.chasisno=chasisno;
}
@Override
public String toString() {
	return "Vehicle [chasisno=" + chasisno + ", color=" + color + ", netprice=" + netprice + ", localdate=" + localdate
			+ ", company=" + company + ", isavil=" + isavil + "]";
	

	}
@Override
public boolean equals(Object o) {
	System.out.println("in vehicle equals");
		if (o instanceof Vehicle)
			return this.chasisno.equals(((Vehicle) o).chasisno);
		return false;
	
}
 


 
	
}
