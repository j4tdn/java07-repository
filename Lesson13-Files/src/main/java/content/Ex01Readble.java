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

public class Ex01Readble {
	public static void main(String[] args) throws IOException {
		List<Customer> customers = getAll();
		String pathName = "JAVA" + File.separator + "customer.txt";
		File file = FileUtils.createFile(pathName);
//		FileUtils.writeFile(file, customers);
		List<String> lines = customers.stream().map(Customer::toString).collect(Collectors.toList());
		Files.write(file.toPath(), lines);
		System.out.println("Back to main thread!");
//		read file
		List<String> result = Files.readAllLines(file.toPath());
		result.forEach(System.out::println);
//		open file
		Desktop.getDesktop().open(file);
	}

	public static List<Customer> getAll() {
		return Arrays.asList(new Customer("Văn Tèo", "098990000", "ĐN"), new Customer("Lê Tèo", "0989888888", "HN"),
				new Customer("Trần Tèo", "0989774444", "HCM"));
	}
}