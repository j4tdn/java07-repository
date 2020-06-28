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
		List<Customer> customer = getAll();

		String pathname = "JAVA07" + File.separator + "data" + File.separator + "customer.txt";

		File file = FileUtils.createFile(pathname);
		FileUtils.writeFiles(file, customer);
		System.out.println("Back to main thread !!!");
		// openfile
		Desktop.getDesktop().open(file);
	}

	private static List<Customer> getAll() {

		return Arrays.asList(new Customer("Le Anh", "031264548", "DaNang"),
				new Customer("Le Minh", "021564545", "HaNoi"), new Customer("Tran Thanh", "0545454555", "HCM"));

	}

}
