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
		String pathName = "JAVA07" + File.separator + "data" + File.separator + "customer.txt";
		File file = FileUtils.createFile(pathName);
		FileUtils.writeFile(file,customers);
		
		
		//open file
		Desktop.getDesktop().open(file);
		

	}

	private static List<Customer> getAll(){
		return Arrays.asList(
				new Customer("Le Na" , "12321421", "Da Nang"),
				new Customer("Le Teo" , "8765432", "Da Nang"),
				new Customer("Le Tao" , "124987654", "Quang Nam")
		);
	}
	

}
