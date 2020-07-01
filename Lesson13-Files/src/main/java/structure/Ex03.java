package structure;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

import common.Extension;
import utils.FileUtils;

public class Ex03 {
	public static void main(String[] args) throws Exception {
		// create file 20 with extention (mp3.mp4.jpg.png.)
		File parent = new File("JAVA07");
		// FileUtils.createFiles(parent, 21, Extension.values());

		// filter file
		File[] files = parent.listFiles(file -> file.getName().endsWith("." + Extension.JAVA.getValue()));
		System.out.println("lenght: " + files.length);
		// delete file wilt java extention
		for (File file : files) {
			file.delete();
			System.out.println(file.getName() + "has been deleted");
		}
	}
}
