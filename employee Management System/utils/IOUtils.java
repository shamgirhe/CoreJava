package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

import Com.EmpDetail.Empolyee;
import custom_exception.EmphandlingException;

public interface IOUtils {
	static void  storedEmpdetails(String filename, Map<String, Empolyee> emp)
			throws EmphandlingException, FileNotFoundException, IOException {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
			out.writeObject(emp);
		}
	}

	@SuppressWarnings("unchecked")
	static Map<String, Empolyee> RestoredEmpdetails(String filename)
			throws FileNotFoundException, IOException, EmphandlingException, ClassNotFoundException {
		try ( ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename) ) /*ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))*/)
		{
			return (Map<String, Empolyee>) in.readObject();
		 
		}
		catch (Exception e) {
			System.out.println("Null Map"+e);
			return new HashMap<>();
		}
	}

}
