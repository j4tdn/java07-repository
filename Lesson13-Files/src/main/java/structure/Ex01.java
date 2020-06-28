package structure;

import java.io.File;
import java.io.IOException;

public class Ex01 {
	public static void main(String[] args) {
		// create new file

		File file = new File("JAVA0X\\data\\readme.txt");
	
		// create new folder
		File parent = file.getParentFile();

		if (!parent.exists()) {
			boolean isFolderCreate = parent.mkdirs();
			System.out.println("IsFolderCreate:" + isFolderCreate);
		}
		if (!file.exists()) {
			try {
				boolean isFileCreated = file.createNewFile();
				System.out.println("IsFileCreated:" + isFileCreated);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		System.out.println("back to main thread");
		
		
	}
}
