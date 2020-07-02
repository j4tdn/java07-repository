package content;

import java.util.List;
import java.util.stream.Collectors;
import java.awt.Desktop;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collections;

import beans.Customer;
import utils.FileUtils;

public class Ex01Readble {
	public static void main(String[] args) throws IOException {
		List<Customer> customers = getAll();
		String pathname = "JAVA07" +File.separator + "data" + File.separator + "customer.txt";
		File file = FileUtils.createFile(pathname);
	//	FileUtils.writeFile(file, customers);
		List<String> lines = customers.stream().map(Customer::toString).collect(Collectors.toList());
		Files.write(file.toPath(), lines);
		
		//readfile
		System.out.println("Readfile:");
		List<String> result = Files.readAllLines(file.toPath());
		result.forEach(System.out::println);
		
		//open file
		Desktop.getDesktop().open(file);
	}
	
	public static List<Customer> getAll() {
		return Arrays.asList(
				new Customer("Le Na", "0333233518", "Sai gon"),
				new Customer("Hoang Teo", "0934730381", "Quang Nam"),
				new Customer("Thanh Binh", "0362551688", "Hue"));
	}
}
