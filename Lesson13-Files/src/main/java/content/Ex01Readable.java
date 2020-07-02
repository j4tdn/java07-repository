package content;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import beans.Customer;
import utils.FileUtils;

public class Ex01Readable {

	public static void main(String[] args) throws IOException {
		List<Customer> customers = getAll();
		String pathname = "JAVA07" + File.separator + "data" + File.separator + "customer.txt";
		File file = FileUtils.createFile(pathname);
		//FileUtils.writeFile(file, customers);
		List<String> lines = customers.stream()
				.map(Customer::toString).collect(Collectors.toList());
		Files.write(file.toPath(), lines);
		
		//read files
		System.out.println("====Read file=====");
		List<String> results = Files.readAllLines(file.toPath());
		
		results.forEach(System.out::println);
		Desktop.getDesktop().open(file);
	}

	public static List<Customer> getAll() {
		return Arrays.asList(new Customer("Nguyen A", "0398636611", "HCM"),
				new Customer("Nguyen B", "0398636612", "Hue"), new Customer("Nguyen C", "0398636613", "DN"));
	}
}
