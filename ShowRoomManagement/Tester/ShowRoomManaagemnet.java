package Tester;

//import static utils.ValdationRule.valdationrulevehicle;
import static utils.ValdationRule.*;

import java.util.Scanner;
import Com.Vehicle.Color;
import Com.Vehicle.Vehicle;
import Custom_Exception.VehicleHandlingExcption;
public class ShowRoomManaagemnet {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter showroom size");
			Vehicle[] showroom = new Vehicle[sc.nextInt()];
			boolean flag = false;
			int count = 0;
			while (!flag) {
				System.out.println("1.Add Vehicle ");
				System.out.println("2.Display Vehicle ");
				System.out.println("0.Exits ");
				System.out.println("Enter Your Choice");
				try {
					switch (sc.nextInt()) {
					case 1:/*chasisNo(string) : Unique ID, color(enum) , netPrice(double) ,
						 * manufactureDate(LocalDate),company,isAvailable*/
						if(count<showroom.length)
						 {
							System.out.println("Enter the chesisno, color , netprice , maufacturedate(yyyy-MM-dd) ,Company Name ");
							Vehicle vehicle =  valdationrulevehicle(sc.next(), sc.next(), sc.nextDouble(), 
									sc.next(), sc.next(), showroom);
							showroom[count++]=vehicle;
							System.out.println("Vehicle is Added.......");
						 }
						else  throw new VehicleHandlingExcption("Showroom is full!!!!!!");
						break;
					case 2:
						  for(Vehicle v : showroom)
						  {
							  if(v!=null)
							  {
								  System.out.println(v);
							  }
						  }

						break;
					case 0:
						System.out.println("Thanks you!!!");
						flag = true;
						break;
					default:
						System.out.println("Default choice!!!");
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}



}
