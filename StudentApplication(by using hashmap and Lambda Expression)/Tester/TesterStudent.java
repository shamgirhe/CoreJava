package Tester;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Scanner;
import static utils.StudentCollectionUtils.*;

import com.app.core.Address;
import com.app.core.Student;
import com.app.core.Subject;

public class TesterStudent {

	private static final String Double = null;

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in);) {
			List<Student> studentList = populateList();
			System.out.println("students:");

			System.out.println("students:**************************");
			/*
			 * 1.Create int[] ---> IntStream & display its contents. 1.5 Create int[] --->
			 * IntStream --> sort(asc) --> & display its contents.
			 */
			System.out.println("Orignal IntStream StudentList::");
			studentList.forEach(s -> System.out.println(s));

			Map<String, Student> maplist = populateMap(studentList);

			System.out.println("students:**************************");
			/*
			 * 2. Create AL<Integer> , populate it. Convert it to seq stream & display elems
			 * 2.5 Convert it to parallel stream & display elems
			 */
			System.out.println("Orignal Parallel Stream Student List.");
			maplist.values().forEach(s -> System.out.println(s));

			System.out.println("************************************");
			/*
			 * 3. Create stream of ints between 1-100 & display all even elements. (Hint :
			 * IntStream methods --range,filter,forEach) 3.5. Create Stream<Integer> from a
			 * fixed size list (un sorted ) of integers , sort (desc) n display it.
			 */
			System.out.println("Sorted By desc Ordering::");
			maplist.values().stream().sorted((p1, p2) -> ((Double) p1.getGpa()).compareTo(p2.getGpa()))
					.forEach(z -> System.out.println(z));

			System.out.println("**************************************");

			/*
			 * 4. list : Display all product names of a particular category , exceeding
			 * specific price. I/P category name & price. eg : productList.stream()
			 * .filter(p -> p.getCategory()==cat) .filter(p -> p.getPrice() > price)
			 * .forEach(p -> sop(p.getName()));
			 */
			System.out.println("Display all product names of a particular category , exceeding\r\n"
					+ "			 * specific price.");
			System.out.println("enter subject");
			String sub = sc.next().toUpperCase();

			OptionalDouble op = maplist.values().stream().filter(p -> p.getSubject().equals(Subject.valueOf(sub)))
					.mapToDouble(p -> p.getGpa()).average();
			if (op.isPresent())
				System.out.println("avg" + op.getAsDouble());
			else
				System.out.println("no such subject is present");

			System.out.println("**************************************");
			// 5 Print name of specified subject topper
			System.out.println("enter subject to find topper");
			String subj = sc.next().toUpperCase();
			Optional<Student> os = maplist.values().stream().filter(p -> p.getSubject().equals(Subject.valueOf(subj)))
					.max((p1, p2) -> ((Double) p1.getGpa()).compareTo(p2.getGpa()));
			if (os.isPresent())
				System.out.println("topper is " + os.get().getName());
			else
				System.out.println("subject not found");
			System.out.println("**************************************");
			// 6 Print no of failures for the specified subject chosen from user.
			// (gpa < 5 : failed case)
			System.out.println("Print no of failures for the specified subject chosen from user.");
			System.out.println("failed students");
			System.out.println("enter subject");
			String subje = sc.next().toUpperCase();
//                     maplist.values()
//                    .stream()
//                    .filter(p -> p.getSubject().equals(Subject.valueOf(subje)))
//                    .filter(p-> p.getGpa()<8)
//                    .forEach(p->System.out.println(p));
			/* long of = */ maplist.values().stream().filter(p -> p.getSubject().equals(Subject.valueOf(subje)))
					.filter(p -> p.getGpa() < 8).forEach(p -> System.out.println(p));
		//	System.out.println("no of failed student::" + of);

			System.out.println("**************************************");
			// 7. Display student names of all the students , from a specified city.
			System.out.println("Display student names of all the students , from a specified city.");
			System.out.println("enter city");
			String city = sc.next().toLowerCase();

			maplist.values().stream().filter(c -> c.getAddress().getCity().equals(city))
					.forEach(c -> System.out.println(c));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}