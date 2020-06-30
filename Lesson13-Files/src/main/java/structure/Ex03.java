package structure;

import java.io.File;
import java.io.FileFilter;

import common.Extension;
import utils.FileUtils;

public class Ex03 {
	public static void main(String[] args) throws Exception {
		// create 20 files with extension (mp3, mp4, jpg, png, java, bat)
		File parent = new File("JAVA07");
		// FileUtils.createFiles(parent, 20, Extension.values());

		// filter file
		File[] files = parent.listFiles(file -> file.getName().endsWith("." + Extension.JAVA.getValue()));
		System.out.println("length: " + files.length);

		// delete file with java extension
		for (File file : files) {
			file.delete();// xoa file hoac folder, chi xoa dc file con hoac folder rong
			System.out.println(file.getName() + " has been deleted. ");
		}
	}
}
