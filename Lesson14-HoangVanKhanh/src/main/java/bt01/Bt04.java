package bt01;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Random;



public class Bt04 {
	public static void main(String[] args) throws IOException {
		String pathName = "Java07" + File.separator + "student.txt";
		File file = craetedFile(pathName);
		List<String> result = Files.readAllLines(file.toPath());
		result.forEach(System.out::println);
		
		
		

	}

	public static File craetedFile(String pathName) {

		File file = new File(pathName);
		File parent = file.getParentFile();
		// create new folder
		if (!parent.exists()) {
			parent.mkdir();
		}

		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return file;
	}
	

}
