package Tester;

import static utils.ShowroomUtils.populateShowroom;
import static utils.ValidationRuleForShowroom.validationcheck;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import Com.Vehicle.Color;
import Com.Vehicle.Vehicle;
import Showroom_Exception.ShowroomException;

public class ShowRoomTester {

	public static void main(String[] args) throws ShowroomException {
		try (Scanner sc = new Scanner(System.in)) {
			Map<String, Vehicle> vehicle = populateShowroom();
			Collection<Vehicle> v = vehicle.values();
			boolean exit = true;
			while (exit) {
				System.out.println("--------Colors-----------");
				Color[] c = Color.values();
				Arrays.stream(c).forEach(p->System.out.println(p));
				for (Color sp : c) {
					System.out.println(sp + "---->" + sp.getprice());
				}
				
				System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
				System.out.println("Options 0. Exit \n 1. Add a Vehicle\n 2. Display all\n "
						+ "3. Get specific vehicle details\n 4. Apply discount\n "
						+ "5. Delete vehicle details  by ch no\n 6. Delete vehicles by color\n "
						+ "7. Sort the vehicles as per ch no\n " + "8. Sort the vehicles as per price\n "
						+ "9. Sort the vehicles as per date n price " + "\n10. Sort the vehicles as per date\n ");
				System.out.println("Choose an option");

				try {
					switch (sc.nextInt()) {
					case 1:
						System.out.println("Enter the Information : "
								+ "Vehicleid, vehiclename, color , netprice , manufacturedate(dd/mm/yyyy) , company");
						Vehicle v1 = validationcheck(sc.next(), sc.next(), sc.next(), sc.nextDouble(), sc.next(),
								sc.next(), vehicle);
						vehicle.put(v1.getVehicleid(), v1);
						System.out.println("Vehicle is Added.");
						break;

					case 2:
						// productList.forEach(p -> System.out.println(p));
						// v.forEach(s -> System.out.println(s));
						// by collrctions
						vehicle.values().forEach(s -> System.out.println(s));
						break;
					case 3:
						System.out.println("Enter The Vehicleid::");
						Vehicle vid = vehicle.get(sc.next());
						if (vid == null)
							throw new ShowroomException("Invalid Vehicleid.");
						else
							System.out.println(vid);
						break;
					case 4:
						System.out.println("Discount Appied.");
						v.forEach(s -> s.setNetprice(s.getNetprice() - (0.1 * s.getNetprice())));
						v.forEach(s -> System.out.println(s));
						System.out.println();
						break;
					case 5:
						System.out.println("Enter the Vehicleid:");
						vid = vehicle.get(sc.next());
						if (vid == null)
							throw new ShowroomException("Invalid Vehicleid");
						else {
							System.out.println("Removed Vehicle:" + vid);
							// v.remove(vid); by collection
							vehicle.remove(vid);
						}
						break;
					case 6:
						System.out.println("Enter the fname:");
						String vname = sc.next();

						vehicle.entrySet().removeIf(entry -> (vname.equals(entry.getValue())));

						// Print the modified HashMap
						vehicle.values().forEach(s -> System.out.println(s));
						break;
					case 7:
						System.out.println("Enter The Color");
						Color col = Color.valueOf(sc.next());
						Iterator<Vehicle> itr = v.iterator();
						while (itr.hasNext()) {
							if (itr.next().getColor() == col)
								itr.remove();
						}
						break;
					case 8:
						vehicle.values().stream()
						.sorted((v3, v2) -> v3.getVehicleid().compareTo(v2.getVehicleid()))
						.forEach(p -> System.out.println(p));
					
						//	vehicle.values().forEach(p -> System.out.println(p));
					case 0:
						System.out.println("*-*-*-Thank you-*-*-*-*");
						exit = false;
					default:
						break;
					}

				} catch (Exception e) {
					e.printStackTrace();
					sc.nextLine();
				}
			}

		}
	}

}
