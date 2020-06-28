package structure;

import java.io.File;
import java.io.IOException;

public class Ex02 {
	public static void main(String[] args) throws IOException{
		
		File file = new File("JAVA07\\data\\readme.txt");
		info(file);
		//delete file(s)
		boolean isDelete =file.delete();
		System.out.println("delete : "+isDelete);
		
		
	}
	private static void info(File file) throws IOException {
		System.out.println("path :" + file.getPath());
		System.out.println("absolute :" + file.getAbsolutePath());
		System.out.println("canonical :" + file.getCanonicalPath());
	}

}
