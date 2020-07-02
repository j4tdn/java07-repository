package content;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.util.List;

import been.custumer;
import utils.FileUtils;

public class Ex02_ByteStream {
	public static void main(String[] args) throws Exception{
		List<custumer> custumers = Ex01_Readble.getAll();
		String pathName = "JAVA07" + File.separator + "data" + File.separator + "custumer_serialize.txt";
		File file = FileUtils.createFiles(pathName);
		
		
		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream oss = new ObjectOutputStream(fos);
		oss.writeObject(custumers);
		oss.close();
		fos.close();

		Desktop.getDesktop().open(file);
		
		FileInputStream fis = new FileInputStream(file);
		ObjectInputStream osi = new ObjectInputStream(fis);
		
		@SuppressWarnings("unchecked")
		List<custumer> result = (List<custumer>)osi.readObject();
		
		result.forEach(System.out::println);
		osi.close();
		fis.close();
		
	}
	
	
}
