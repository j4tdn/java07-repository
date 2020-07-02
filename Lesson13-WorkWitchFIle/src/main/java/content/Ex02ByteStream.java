package content;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import beans.Customer;
import utils.FileUtils;

public class Ex02ByteStream {
	

	public static void main(String[] args) throws IOException, ClassNotFoundException{
		List<Customer> customers = Ex01Readble.getAll();
		String pathName= "JAVA07" + File.separator + "data" +File.separator + "customer_serialine.txt";
		File file = FileUtils.craetedFile(pathName);
		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		
		oos.writeObject(customers);
		oos.close();
		fos.close();
		Desktop.getDesktop().open(file);
		
		
		
		FileInputStream fis= new FileInputStream(file);
		ObjectInputStream ois= new ObjectInputStream(fis);
		@SuppressWarnings("unchecked")
		List<Customer> result =(List<Customer>) ois.readObject();
		result.forEach(System.out::println);
		ois.close();
		fis.close();
		
		
			
		
	}
	
	
	
}
