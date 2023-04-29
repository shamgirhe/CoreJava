package Com.app.fruits;

public class Apple extends Fruits {

	public Apple(String color, String name, double weight, boolean fresh) {
		super(name,color, weight, fresh);
	}
	@Override
	public String tester() {
		return "Sweet and Sour.";
	}
	
	public void jam() {
		System.out.println("Name:"+super.getName()+" a mesg making jam!  ");
	}
	@Override
	public String toString() {
		return " toString()=" +super.toString()+"Apple [tester()=" + tester() + "]";
	}
	
	
}
