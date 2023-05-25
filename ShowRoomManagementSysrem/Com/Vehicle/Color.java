package Com.Vehicle;

public enum Color {
  BLUE(1000),GREEN(2000),BLACK(3000),WHITE(4000),RED(5000);
private int price;	
Color(int price) {
	this.price=price;
}
public int getprice() {
	return price;
}
  
}
