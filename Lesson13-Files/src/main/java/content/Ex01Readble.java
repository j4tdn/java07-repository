package content;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import beans.Customer;
import ultils.FileUltils;

public class Ex01Readble {
	public static void main(String[] args) throws IOException {
		 List<Customer> customers =getAll();
		 String pathname ="JAVA07"+File.separator+"data"+"customer.txt";
		 File file = FileUltils.createFile(pathname);
		 //FileUltils.write(file,customers);
		 List<String> lines =customers.stream().map(t->t.toString()).collect(Collectors.toList());
		 Files.write(file.toPath(),lines);
		 
		 System.out.println("========readfile==========");
		 List<String> result = Files.readAllLines(file.toPath());
		 result.forEach(System.out::println);
		 
		 Desktop.getDesktop().open(file);
	}
	public static List<Customer> getAll(){
		return Arrays.asList(new Customer("Le Na","0123456789","gia lai"),
				new Customer("Hoang","9123456789","sai gon"),
				new Customer("khanh","7943436789","ha noi"));
	}
}
