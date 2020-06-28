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
		String pathName = "JAVA" + File.separator + "customer.txt";
		File file = FileUtils.createFile(pathName);
		FileUtils.writeFile(file, customers);
		System.out.println("Back to main thread!");
//		open file
		Desktop.getDesktop().open(file);
	}

	private static List<Customer> getAll() {
		return Arrays.asList(new Customer("Văn Tèo", "098999999", "ĐN"), new Customer("Lê Tèo", "0989888888", "HN"),
				new Customer("Trần Tèo", "0989777777", "HCM"));
	}
}