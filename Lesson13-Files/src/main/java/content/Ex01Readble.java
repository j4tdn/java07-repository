package content;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.text.ChangedCharSetException;

import beans.Customer;
import utils.FileUtils;

public class Ex01Readble {
	/**
	 * Le Na, 0164 728 9291, Nam Cao 
	 * Hoang Teo, 0164 592 9102, Da Nang 
	 * Van Duc, 0165 123 9134, Hoa Khanh
	 * @throws IOException 
	 */

	public static void main(String[] args) throws Exception {
		List<Customer> customers = getAll();
		String pathname = "JAVA07" + File.separator 
				+ "data" + File.separator + "customer.txt";
		File file = FileUtils.createFile(pathname);
		// FileUtils.writeFile(file, customers);
		
		List<String> lines = customers.stream()
				.map(Customer::toString)
				.collect(Collectors.toList());
		Files.write(file.toPath(), lines);
		// lesson14-hoten
		System.out.println("================READ FILE=============");
		List<String> result = Files.readAllLines(file.toPath());
		result.forEach(System.out::println);
		
		// open file
		Desktop.getDesktop().open(file);
	}

	public static List<Customer> getAll() {
		return Arrays.asList(
				new Customer("Le Na", "0164 728 9291", "Sai Gon"),
				new Customer("Hoang Teo", "0164 592 9102", "Binh Dinh"),
				new Customer("Van Duc", "0165 123 9134", "Khanh Hoa"));
	}
}