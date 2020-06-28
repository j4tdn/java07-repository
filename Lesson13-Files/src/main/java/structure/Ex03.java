package structure;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.security.cert.Extension;
import java.util.Random;

import common.Extention;
import utils.FileUtils;

public class Ex03 {
	public static void main(String[] args) throws IOException {
		//create 20 files with extension (mp3, mp4, jpg, png, bat, java)
		File parent = new File("JAVA07");
		FileUtils.createFiles(parent, 20, Extention.values());
		
		//filter file
		File[] files = parent.listFiles(pathname -> pathname.getName().endsWith(Extention.JAVA.getValue()));
		System.out.println("length: " + files.length);
		
		//delete file with java extension
		for (File file : files) {
			file.delete();
			System.out.println(file.getName() + " has been deleted");
		}
	}
}
