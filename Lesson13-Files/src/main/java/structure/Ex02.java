package structure;

import java.io.File;
import java.io.IOException;

import javax.swing.text.StyledEditorKit.BoldAction;

public class Ex02 {
	public static void main(String[] args) throws IOException {
		// deleted files
		File file = new File("JAVA0X");
		infor(file);
		
		Boolean isDeleted=file.delete();
		System.out.println("Is Deleted: "+isDeleted);
	}

	private static void infor(File file) throws IOException {
		System.out.println("getPath: " + file.getPath());
		System.out.println("getAbsolutePath: " + file.getAbsolutePath());
		System.out.println("getCanonicalPath: " + file.getCanonicalPath());

	}
}
