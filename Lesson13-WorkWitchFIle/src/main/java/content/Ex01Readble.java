package content;

import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import beans.Customer;
import utils.FileUtils;

public class Ex01Readble {
	public static void main(String[] args) throws IOException {
		List<Customer> customers = getAll();
		String pathName= "JAVA07" + File.separator + "data" +File.separator + "customer.txt";
		File file = FileUtils.craetedFile(pathName);
		//FileUtils.writeFile(file,customers);
		//write file
		List<String> line = customers.stream().map(Customer::toString).collect(Collectors.toList());
		Files.write(file.toPath(),line);
		Desktop.getDesktop().open(file);
		System.out.println("=========================READ FILE===================");
		List<String> result = Files.readAllLines(file.toPath());
		result.forEach(System.out::println);
		
		
		
		

	}

	public static List<Customer> getAll() {
		return Arrays.asList(new Customer("Hoàng Văn Khánh", "0123 466 789", "Sài Gòn"),
				new Customer("hoang teo", "0166 2256 789", "Bình Định"), new Customer("van dung", "0653 456 789", "Đà Nẵng"));
	}

}
