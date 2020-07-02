package content;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import beans.Customer;
import utils.FileUtils;

public class Ex01 {

	public static void main(String[] args) throws IOException {
		List<Customer> customers = getAll();
		for (Customer customer : customers) {
			System.out.println(customer);
		}
		String pathname = "JAVA07" + File.separator + "data" + File.separator + "customer.txt";
		File file = FileUtils.createFile(pathname);
		FileUtils.writeFile(file, customers);
		Desktop.getDesktop().open(file);
	}
	private static List<Customer> getAll(){
		return Arrays.asList(
				new Customer("Nguyen A", "0398636611", "HCM"),
				new Customer("Nguyen B", "0398636612", "Hue"),
				new Customer("Nguyen C", "0398636613", "DN"));
	}
}
