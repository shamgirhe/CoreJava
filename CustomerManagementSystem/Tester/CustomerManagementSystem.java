package Tester;

import static utils.CustomerValdationRules.checksignin;
import static utils.CustomerValdationRules.customervaldationrule;
import static utils.Customerutils.customer;

import java.time.LocalDate;
import java.time.Period;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import Com.App.Customer.Customer;
import Com.App.Customer.Plan;

public class CustomerManagementSystem {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter the Customer::");
			List<Customer> customer = customer();
			boolean flag = false;
			int count = 0;
			System.out.println("--------Service plans-----------");
			Plan[] p = Plan.values();
			for (Plan sp : p) {
				System.out.println(sp + "---->" + sp.getPlancost());
			}
			System.out.println("-----------------------------");
			System.out.println("1.Sign up\r\n" + "2.Sign in\r\n" + "3.Change Password\r\n" + "4.Subscribe customer\r\n"
					+ "5.Display all customers. \n 6.natural ordering(desc sort)\n 7.custom ordering \n 8.PlanExpired or not. \n 9. remove Un subscribe customer  "
					+ "\r\n 0.exits");
			while (!flag) {
				System.out.println("Enter your choice::");
				try {
					switch (sc.nextInt()) {
					case 1:
						System.out.println("-------------Sign up------------------");
						System.out.println("Enter Your Infromation::"
								+ "first name, last name,email,password,dob(yyyy-mm-dd),RegistationDate,plan" + "");
						Customer customer1 = customervaldationrule(sc.next(), sc.next(), sc.next(), sc.next(),
								sc.next(), sc.next(), sc.next(), customer);
						customer.add(customer1);

						System.out.println(".............Customer Is Add...........");

						break;
					case 2:
						System.out.println("----------Sign in--------------");
						System.out.println("Enter Your Gmail and Password::");
						Customer cust = checksignin(sc.next(), sc.next(), customer);
						break;
					case 3:
						System.out.println("Enter Your Gmail and Old Password");
						cust = checksignin(sc.next(), sc.next(), customer);
						System.out.println("Enter your new password::");
						cust.setPassword(sc.next());
						System.out.println("your New Password is::" + cust.getPassword());
						break;
					case 4:
						System.out.println("Enter Your Gmail and Password");
						cust = checksignin(sc.next(), sc.next(), customer);
						System.out.println("remove::" + customer.remove(cust));
						break;
					case 5:
						System.out.println("All Customer Account Are:: ");
						for (Customer c : customer)
							System.out.println(c);
						break;
					case 6:
						System.out.println("----Sort by gmail------");
						Collections.sort(customer);
						System.out.println("sort ingformation::");
						for (Customer c : customer)
							System.out.println(c);

						break;
					case 7:
						Collections.sort(customer, new Comparator<Customer>() {
							@Override
							public int compare(Customer c1, Customer c2) {
								// dob based

								int ret = c1.getDob().compareTo(c2.getDob());

								if (ret == 0) {
									/*
									 * if(c1.getRegistrationamount()<c2.getRegistrationamount()) { return -1; }
									 * if(c1.getRegistrationamount()==c2.getRegistrationamount()) { return 1; }
									 */

									return ((Double) c1.getRegistrationamount()).compareTo(c2.getRegistrationamount());

								}
								return ret;

							}

						});
						System.out.println("sort ingformation by::");
						for (Customer c : customer)
							System.out.println(c);
						break;
					case 8:
						System.out.println("Enter the Gmail and Password::");
						cust = checksignin(sc.next(), sc.next(), customer);
						int subid = (int) Period.between(cust.getRegistrationdate(), LocalDate.now()).toTotalMonths();
						if (subid > 3) {
							System.out.println("Your Plan is Expired.do you want to be continous:(Yes/No");
							Character c = sc.next().toUpperCase().charAt(0);
							if (c == 'Y') {
								cust.setRegistrationdate(LocalDate.now());
							} else
								customer.remove(cust);
						}

						break;
					case 9:
						Iterator<Customer> itr = customer.iterator();

						while (itr.hasNext()) {
							Customer c1 = itr.next();
							LocalDate cu = c1.getRegistrationdate();

							// System.out.println(itr.next());
							long subid1 = Period.between(cu, LocalDate.now()).toTotalMonths();
							if (subid1 > 3) {
								System.out.println("removed Account:" + c1.getFirstname() + " " + c1.getLastname());
								itr.remove();
							}

						}

						break;
					case 0:
						System.out.println("Thank You!!!!!");
						flag = true;
						break;

					default:
						System.out.println("Invalid number");
						break;
					}

				} catch (Exception e) {
					e.printStackTrace();
					sc.nextLine();
				}
			}
		}

	}
}
