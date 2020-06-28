package content;

import java.util.List;
import java.awt.Desktop;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Arrays;

import beans.Customer;
import utils.FileUtils;

public class Ex01 {
	public static void main(String[] args) throws IOException {
		List<Customer> customers = getAll();
		String pathname = "JAVA07" +File.separator + "data" + File.separator + "customer.txt";
		File file = FileUtils.createFile(pathname);
		FileUtils.writeFile(file, customers);
		
		//open file
		Desktop.getDesktop().open(file);
	}
	
	private static List<Customer> getAll() {
		return Arrays.asList(
				new Customer("Le Na", "0333233518", "Da Nang"),
				new Customer("Hoang Teo", "0934730381", "Quang Nam"),
				new Customer("Thanh Binh", "0362551688", "Hue"));
	}
}
