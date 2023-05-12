package Com.App.Customer;

public enum Plan {
  SILVER(1000),GOLD(2000),DIAMOND(5000),PLATINUM(10000);
  
  private double plancost;

private Plan(double plancost) {
	this.plancost = plancost;
}

public double getPlancost() {
	return plancost;
}
	
}
