package Com.app.fruits;

public class Orange extends Fruits {

	public Orange(String color, String name, double weight, boolean fresh) {
		super(name, color, weight, fresh);
	}
	
public void juice() {
	System.out.println("Name::"+super.getName()+" and Weight::"+super.getWeight()+" a mesg extracting juice!!");
}
@Override
	public String toString() {
		return " toString()=" + super.toString() +"Orange [tester()=" + tester()+ "]";
	}
@Override
public String tester() {
	return "Sour..";
}
}
