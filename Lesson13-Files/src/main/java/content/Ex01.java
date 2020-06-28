package content;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import beans.Customer;
import ultils.FileUltils;

public class Ex01 {
	public static void main(String[] args) throws IOException {
		 List<Customer> customers =getAll();
		 String pathname ="JAVA07"+File.separator+"data"+"customer.txt";
		 File file = FileUltils.createFile(pathname);
		 FileUltils.write(file,customers);
		 Desktop.getDesktop().open(file);
	}
	private static List<Customer> getAll(){
		return Arrays.asList(new Customer("Le Na","0123456789","da nang"),
				new Customer("Hoang","9123456789","sai gon"),
				new Customer("khanh","7943436789","ha noi"));
	}
}
