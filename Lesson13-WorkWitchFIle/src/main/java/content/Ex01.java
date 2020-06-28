package content;

import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import beans.Customer;
import utils.FileUtils;

public class Ex01 {
	public static void main(String[] args) throws IOException {
		List<Customer> customers = getAll();
		String pathName= "JAVA07" + File.separator + "data" +File.separator + "customer.txt";
		File file = FileUtils.craetedFile(pathName);
		FileUtils.writeFile(file,customers);
		
		Desktop.getDesktop().open(file);
		
		
		

	}

	private static List<Customer> getAll() {
		return Arrays.asList(new Customer("le na", "0123 456 789", "cao ky"),
				new Customer("hoang teo", "0166 2256 789", "alo"), new Customer("van dung", "0653 456 789", "da nang"));
	}

}
