package structure;

import java.io.File;
import java.io.IOException;

public class Ex02 {
	public static void main(String[] args) throws IOException{
		
		File file = new File("JAVA0X");
		info(file);
		
		// delete file(s)
		boolean isDeleted = file.delete();
		System.out.println("isDeleted: " + isDeleted);
	}
	
	private static void info(File file) throws IOException{
		System.out.println("path: " + file.getPath());
		System.out.println("abs path: " + file.getAbsolutePath());
		System.out.println("cano path: " + file.getCanonicalPath());
	}
	
}
