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
		String pathname = "JAVA07" + File.separator + "data" + File.separator + "customer.txt";
		File file = FileUtils.createFiles(pathname);
		FileUtils.writeFile(file, customers);

		// open file
		Desktop.getDesktop().open(file);
	}

	private static List<Customer> getAll() {
		return Arrays.asList(new Customer("Le Na", "0164 728 9291", "Nam Cao"),
				new Customer("Hoang Teo", "0164 592 9102", "Da Nang"),
				new Customer("Van Duc", "0165 123 9134", "Hoa Khanh"));
	}
}
