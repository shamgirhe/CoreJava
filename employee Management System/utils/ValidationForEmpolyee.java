package utils;

import java.time.LocalDate;
import java.time.Period;
import java.util.Map;

import Com.EmpDetail.DeptName;
import Com.EmpDetail.Empolyee;
import Tester.EmpDetails;
import custom_exception.EmphandlingException;




public class ValidationForEmpolyee {

public static Empolyee validationcheck(String empid, String fname, String lname, String deptname, 
		double sal, String joiningdate , Map<String, Empolyee> empolyee) throws EmphandlingException
{
	 checkfordup(empid,empolyee);
	DeptName dept = validationdeptment(deptname);
	LocalDate joindate = validationforjoining(joiningdate);
	return new Empolyee(empid, fname, lname, dept, sal, joindate) ;
	
}

  public static String checkfordup(String empid, Map<String, Empolyee> empolyee) throws EmphandlingException {
	if(empolyee.containsKey(empid))
		throw new EmphandlingException("Duolicate Empolyee id!!!!");
	return empid;
	
}

public static LocalDate validationforjoining(String joiningdate) throws EmphandlingException {
	LocalDate joindate = LocalDate.parse(joiningdate);
	int differenceinyears = Period.between(joindate, LocalDate.now()).getYears();
	if(differenceinyears > 3)
		throw new EmphandlingException("Invalid Joining Date!!!1");
	return joindate;
}

public static DeptName validationdeptment(String deptname) {
	
	return DeptName.valueOf(deptname.toUpperCase());
}

}
