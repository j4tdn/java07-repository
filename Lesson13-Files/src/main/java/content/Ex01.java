package content;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import beans.Customer;
import utils.FileUtils;

public class Ex01 {
	public static void main(String[] args) throws IOException {
		List<Customer> customers = getAll();
		String pathname = "JAVA00" + File.separator + "data" + File.separator + "customer.txt";
		File file = FileUtils.createFile(pathname);
		// FileUtils.writeFile(file, customers);
		List<String> lines = customers.stream().map(Customer::toString).collect(Collectors.toList());
		Files.write(file.toPath(), lines);
		System.out.println("READ FILE");
		List<String> result = Files.readAllLines(file.toPath());
		result.forEach(System.out::println);
	}

	public static List<Customer> getAll() {
		return Arrays.asList(new Customer("trung", "0123", "hue"), new Customer("hoang", "12333", "ha noi"),
				new Customer("noi", "12333333", "hcm"));
	}
}
