package Com.app.tester;

import java.util.Scanner;

import Com.app.fruits.*;

public class FruitsTester {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Basket Size::");
		Fruits[] basket = new Fruits[sc.nextInt()];

		System.out.println("1.Add Mango.");
		System.out.println("2.Add Orange.");
		System.out.println("3.Add Apple.");
		System.out.println("4.Display names of all fruits in the baskets.");
		System.out.println("5.Display all information of Fruits baskets.");
		System.out.println("6.Mark a Fruits in a basket , as stale(not fresh) by giveing index.");
		System.out.println("7.Mark all sour fruits stale.");
		System.out.println("8.Invoke fruit specific functionality (pulp / juice / jam)\r\n" + "i/p : index");
		System.out.println("9.Exits");
		int choice = 0;
		int count = 0;
		do {
			System.out.println("Enter the Option:");
			choice = sc.nextInt();
			switch (choice) {
			case 1: {
				if (count < basket.length) {
					System.out.println("Enter detail of Mango:(name,color,weight)");
					basket[count++] = new Mango(sc.next(), sc.next(), sc.nextDouble(), true);
				} else
					System.out.println("Basket is full...");
			}
				break;
			case 2: {
				if (count < basket.length) {
					System.out.println("Enter detail of Orange:(name,color,weight)");
					basket[count++] = new Orange(sc.next(), sc.next(), sc.nextDouble(), true);
				} else
					System.out.println("Basket is full...");
			}
				break;
			case 3: {
				if (count < basket.length) {
					System.out.println("Enter detail of Orange:(name,color,weight)");
					basket[count++] = new Apple(sc.next(), sc.next(), sc.nextDouble(), true);
				} else
					System.out.println("Basket is full...");
			}
				break;
			case 4: {
				System.out.println("Name of the all fruits::");
				for (Fruits f : basket) {
					if (f != null)
						System.out.println(f.getName());
				}

			}
				break;
			case 5: {
				System.out.println("Details of the all fruits::");
				for (Fruits f : basket) {
					if (f != null)
						System.out.println(f);
				}

			}
				break;
			case 6: {
				System.out.println("update fruit stale::");
				System.out.println("Enter the index::");
				int id = sc.nextInt();

				{
					if (id >= 0 && id < count) {
						if (basket[id].isFresh() != false) {
							basket[id].setFresh(false);
							System.out.println(basket[id]);
						} else
							System.out.println("Already Stale");
					} else
						System.out.println("NOt found .");

				}

			}
				break;
			case 7: {
				int p = 0;
				for (Fruits f : basket) {
					if (f != null) {
						if (f.tester().equals("sour")) {
							p++;
							f.setFresh(false);
						}
					}
					
				}
				if (p == 0)
					System.out.println(" not present sour.. ");
				else
					System.out.println("done..");
			}
				break;

			case 8: {
				System.out.println("Enter the Index::");
				int index = sc.nextInt();
				if (index >= 0 && index < count) {
					{
						if (basket[index] instanceof Mango)
							((Mango) basket[index]).pulp();

						if (basket[index] instanceof Orange)
							((Orange) basket[index]).juice();

						if (basket[index] instanceof Apple)
							((Apple) basket[index]).jam();

					}

				} else {
					System.out.println("no fruit is present at the index!!");
				}

			}
				break;
			case 9:
				System.out.println("Exits thanks You.....");
				break;
			default:
				System.out.println("ENter the Valid Number....");
				break;
			}
		} while (choice != 9);

	}

}
