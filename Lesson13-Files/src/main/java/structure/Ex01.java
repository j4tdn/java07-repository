package structure;

import java.io.File;
import java.io.IOException;

public class Ex01 {
	public static void main(String[] args) {
		//create new file
		File file = new File("JAVA0X\\abc\\readme.txt");
		
		//create new folder
		File parent = file.getParentFile();
		
		if (!parent.exists()) {
			boolean isParentCreate = parent.mkdirs();
			System.out.println("isParentCreate: " + isParentCreate);
		}
		
		if (!file.exists()) {
			try {
				boolean isFileCreated = file.createNewFile();
				System.out.println("isFileCreate: " + isFileCreated);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Back to main thread!!!");
	}
}
