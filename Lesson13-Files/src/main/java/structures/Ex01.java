package structures;

import java.io.File;
import java.io.IOException;

public class Ex01 {
	public static void main(String[] args) {
		File file = new File("JAVA07\\readme.txt");
		File parent = file.getParentFile(); 
		if(!parent.exists()) {
			try {
				boolean isParentCreate = parent.mkdir();
				boolean isFileCreated = file.createNewFile();
				System.out.println(isFileCreated + " " + isParentCreate);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Back to main thread!");
	}
}
