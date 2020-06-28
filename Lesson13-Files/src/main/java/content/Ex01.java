package content;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import beans.Customer;
import utils.FileUtils;

public class Ex01 {
	public static void main(String[] args) {
		List<Customer> customers = getAll();
		String pathname = "JAVA00" + File.separator + "data" + File.separator + "customer.txt";
		File file = FileUtils.createFile(pathname);
		FileUtils.writeFile(file, customers);
		System.out.println("Back to main thread !!!");
	}

	private static List<Customer> getAll() {
		return Arrays.asList(new Customer("trung", "0123", "hue"), new Customer("hoang", "12333", "ha tinh"),
				new Customer("noi", "12333333", "nghe an"));
	}
}
