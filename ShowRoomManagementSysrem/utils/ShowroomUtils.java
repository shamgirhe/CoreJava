package utils;

import java.util.HashMap;
import java.util.Map;

import Com.Vehicle.Vehicle;
import Showroom_Exception.ShowroomException;
import static utils.ValidationRuleForShowroom.validationcheck;
public class ShowroomUtils {
	public static Map<String,Vehicle> populateShowroom() throws ShowroomException {
		try {
		
			HashMap<String,Vehicle> vehicles = new HashMap<>();
			vehicles.put("abc-1234",validationcheck("abc-1234", "A", "red", 345678, "14/02/2023", "Honda", vehicles));
			vehicles.put("abc-1230",validationcheck("abc-1230", "B", "white", 445678, "12/01/2022", "Honda", vehicles));
			vehicles.put("abc-1233",validationcheck("abc-1233", "C", "white", 375678, "18/02/2023", "Honda", vehicles));
			vehicles.put("abc-1238",validationcheck("abc-1238", "D", "red", 315678, "01/03/2023", "Maruti", vehicles));
			vehicles.put("abc-1239",validationcheck("abc-1239", "E", "white", 395678, "14/02/2023", "Honda", vehicles));
			vehicles.put("abc-1231",validationcheck("abc-1231", "F", "white", 345878, "15/04/2023", "Maruti", vehicles));
			vehicles.put("abc-1232",validationcheck("abc-1232", "G", "red", 385678, "25/04/2023", "Honda", vehicles));
			vehicles.put("abc-1240",validationcheck("abc-1240", "H", "black", 305678, "14/02/2023", "Maruti", vehicles));
			return vehicles;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
}
