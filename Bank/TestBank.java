package Bank;

import java.io.InputStream;
import java.util.Scanner;

public class TestBank {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Your Bank detail(Name,gmail,BankBalance)");
		BankAccount account = new BankAccount(sc.nextLine(), sc.nextLine(), sc.nextDouble());
		System.out.println(account);
		
		System.out.println("Do you want a Locker(Yes/no) ::");
		Character d = sc.next().toUpperCase().charAt(0);
		if(d.equals('Y'))
		{
			System.out.println("Enter the duration(in Year)::");
			  account.assignLocker(sc.nextInt());
			  System.out.println("Locker is assigned.");
			  System.out.println(account);
		}
		else
			System.out.println("Locker is not assigned.");
	}


}
