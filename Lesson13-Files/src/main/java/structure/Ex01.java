package structure;

import java.io.File;
import java.io.IOException;

public class Ex01 {
	public static void main(String[] args) {
		// create new file
		File file = new File("JAVA\\Folder\\Readme.txt");
		File perant = file.getParentFile();

		// create new folder
		if (!perant.exists()) {
			boolean isParentCreated = perant.mkdirs();
			System.out.println("isParentCreated: " + isParentCreated);
		}
		if (!file.exists()) {
			try {
				boolean isFileCreated = file.createNewFile();
				System.out.println("isFileCreated: " + isFileCreated);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Back to main thread !");
	}
}