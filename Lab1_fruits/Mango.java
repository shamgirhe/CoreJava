package Com.app.fruits;

public class Mango extends Fruits {

	public Mango(String color, String name, double weight, boolean fresh) {
		super(name, color, weight, fresh);
	}

	@Override
	public String tester() {
		return "Sweet.";
	}
	public void pulp() {
		System.out.println("Name::"+super.getName()+"and Color: "+super.getColor()+"a mesg creating pulp!");
	}

	@Override
	public String toString() {
		return "toString()=" +super.toString()+"Mango [tester()=" + tester() + "]";
	}

}
