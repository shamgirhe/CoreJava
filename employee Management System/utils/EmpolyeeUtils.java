package utils;

import java.util.HashMap;
import java.util.Map;
import static utils.ValidationForEmpolyee.*;
import Com.EmpDetail.Empolyee;
import custom_exception.EmphandlingException;


public class EmpolyeeUtils {

	public static Map<String, Empolyee> populatemap() throws EmphandlingException {
		// create empty map RND,HR,SALES,FINANCE,PRODUCTION
		Map<String, Empolyee> empmap = new HashMap<>();
		// put vs putIfAbsent
		empmap.put("abc-101", validationcheck("abc-101", "sham", "Girhe", "RND", 700000, "2023-01-01", empmap));
		empmap.put("abc-102", validationcheck("abc-102", "utkarsh", "rane", "hr", 600000, "2023-03-01", empmap));
		empmap.put("abc-103", validationcheck("abc-103", "aniket", "gonjare", "finance", 800000, "2023-01-01", empmap));
		empmap.put("abc-104", validationcheck("abc-104", "darshan", "patil", "sales", 700000, "2021-08-01", empmap));
		empmap.put("abc-105", validationcheck("abc-105", "nikhil", "bhosale", "production", 500000, "2022-09-01", empmap));
		empmap.put("abc-106", validationcheck("abc-106", "Shubham", "badgujare", "hr", 700000, "2022-04-01", empmap));
		//empmap.put("abc-101", validationcheck("abc-101", "ram", "Girhe", "RND", 1000000, "2023-01-01", empmap));
		return empmap;
	}

}
