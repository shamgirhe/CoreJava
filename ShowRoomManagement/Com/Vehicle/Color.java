package Com.Vehicle;

public enum Color {
   RED(10000),BLACK(20000),BLUE(30000),GRAY(40000);

private int cost;

  private Color(int cost) {
      this.cost=cost;
}

 public double getCost() {
	return cost;
}


}
