package structures;

import java.io.File;
import java.io.IOException;

public class Ex02 {
	public static void main(String[] args) throws IOException {
		File file = new File("JAVA07\\data\\readme.txt");
		info(file);
		
		//delete file(s)
		boolean isDeleted = file.delete();
		System.out.println("isDeleted: " + isDeleted);
	}

	private static void info(File file) throws IOException {
		System.out.println("path: " + file.getPath());
		System.out.println("Absolute path: " + file.getAbsolutePath());
		System.out.println("Canonical path: " + file.getCanonicalPath());
	}
	
}
