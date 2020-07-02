package content;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import beans.Customer;
import utils.FileUtils;

public class Ex02ByteStream {
	public static void main(String[] args) throws Exception {
		List<Customer> customers = Ex01Readable.getAll();
		String pathname = "JAVA07" + File.separator + "data" + File.separator + "customer_serialize.txt";
		File file = FileUtils.createFile(pathname);
		
		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(customers);
		
		oos.close();
		fos.close();
		
		
		FileInputStream fis = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		@SuppressWarnings("unchecked")
		List<Customer> results = (List<Customer>)ois.readObject();
		results.forEach(System.out::println);
		
		ois.close();
		fis.close();
		
		//Desktop.getDesktop().open(file);
	}
}
