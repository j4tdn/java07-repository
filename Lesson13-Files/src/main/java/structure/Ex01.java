package structure;

import java.io.File;
import java.io.IOException;

public class Ex01 {
	public static void main(String[] args) {
		// create new file
		File file = new File("JAVA0X\\data\\readme.txt");
		// create new folder
		File parent = file.getParentFile();
		
		if(!parent.exists()) {
			boolean isParentCreated = parent.mkdirs();
			System.out.println("isParentCreated: "+isParentCreated);
		}
		
		if (!file.exists()) {
			try {
				boolean isFileCreated = file.createNewFile();
				System.out.println("isFileCreated: " + isFileCreated);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("back to main thread");
		
	}
}
