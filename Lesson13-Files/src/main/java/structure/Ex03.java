package structure;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

import common.Extension;
import ultils.FileUltils;

public class Ex03 {
	public static void main(String[] args) throws IOException {
		// create 20 files with extension(mp3,mp4,jpg)
		File parent = new File("JAVA07");
//		FileUltils.createFiles(parent, 20, Extension.values());
		// delete file with java extension
		File[] files = parent.listFiles(file->file.getName().endsWith("."+Extension.JAVA.getValue()));
		System.out.println("length: " + files.length);
		for(File file:files) {
			file.delete();
			System.out.println(file.getName()+" has been deleted");
		}
		// filter file

	}
}
