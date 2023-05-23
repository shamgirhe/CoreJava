package Com.EmpDetail;

import java.io.Serializable;
import java.time.LocalDate;

import utils.IOUtils;

public class Empolyee implements Serializable {
 //id(string), first name , last name ,
//dept(enum : RND,HR,SALES,FINANCE,PRODUCTION), joining date(LocalDate
	private String empid;
	private String Fname;
	private String Lname;
	private DeptName deptname;
	private double sal;
	LocalDate joiningdate ;
	
	//empolyee
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
	public Empolyee(String empid, String fname, String lname, DeptName deptname, double sal, LocalDate joiningdate) {
		super();
		this.empid = empid;
		Fname = fname;
		Lname = lname;
		this.deptname = deptname;
		this.sal = sal;
		this.joiningdate = joiningdate;
	}
	@Override
	public String toString() {
		return "EmpDetails [empid=" + empid + ", Fname=" + Fname + ", Lname=" + Lname + ", deptname=" + deptname
				+ ", sal=" + sal + ", joiningdate=" + joiningdate + "]";
	}
	public String getFname() {
		return Fname;
	}
	public void setFname(String fname) {
		Fname = fname;
	}
	public String getLname() {
		return Lname;
	}
	public void setLname(String lname) {
		Lname = lname;
	}
	public DeptName getDeptname() {
		return deptname;
	}
	public void setDeptname(DeptName deptname) {
		this.deptname = deptname;
	}
	public String getEmpid() {
		return empid;
	}
	public LocalDate getJoiningdate() {
		return joiningdate;
	}
	
}
