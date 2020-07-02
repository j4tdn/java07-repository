package content;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import beans.Customer;
import utils.FileUtils;

public class Ex02ByStream {
	public static void main(String[] args) throws Exception {
		List<Customer> customers = Ex01.getAll();
		String pathname = "JAVA" + File.separator + "data" + File.separator + "customer_serialize.txt";
		File file = FileUtils.createFile(pathname);

		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(customers);
		oos.close();
		fos.close();
		FileInputStream fis = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(fis);
		List<Customer> result = (List<Customer>) ois.readObject();
		result.forEach(System.out::println);
		ois.close();
		fis.close();
	}

}