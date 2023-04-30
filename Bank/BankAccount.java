package Bank;

public class BankAccount {
	private static int account;
	private int accid;
	private String name;
	private String gmail;
	private double balance;
	private Locker locker;
	static {
		 account=1000;
	}
     	
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGmail() {
		return gmail;
	}
	public void setGmail(String gmail) {
		this.gmail = gmail;
	}
	public int getAccid() {
		return accid;
	}
	public double getBalance() {
		return balance;
	}
public BankAccount(String name, String gmail, double balance) {
		
		this.accid = ++account;
		this.name = name;
		this.gmail = gmail;
		this.balance=balance;
}

public void assignLocker(int duration) {
	locker = new Locker(duration);
	System.out.println("Locker Charges Per Years::"+locker.getCharges()+"$");
	 locker.calculatecharges();
}


@Override
public String toString() {
	if(locker == null)
	{
		System.out.println("No Locker Assigned Yet:");
		return "BankAccount [actid=" + accid + ", name=" + name + ", balance=" + balance + "]";
	}
	else {
	return "BankAccount [accid=" + accid + ", name=" + name + ", gmail=" + gmail + ", balance=" + balance + ", locker="
			+ locker + "]";
	}
	
	}


private static class Locker{
	private static int lockcount;
	private int lockerid;
	private int duration;
	private double charges;
	
	static {
		lockcount=100;
	}

	public Locker(int duration) {
		this.lockerid = ++lockcount;
		this.duration = duration;
		this.charges = 50;
	}
	
	public void calculatecharges()
	{
		System.out.println("Charges for Locker is::"+duration*charges+"$");
	}

	public double getCharges() {
		return charges;
	}

	@Override
	public String toString() {
		return "Locker [lockerid=" + lockerid + ", duration=" + duration + ", charges=" + charges + "]";
	}
	
	
	
}
	
}
