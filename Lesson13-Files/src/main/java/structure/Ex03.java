package structure;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

import common.Extension;
import utils.FileUtils;

public class Ex03 {
	public static void main(String[] args) throws IOException {

		// create 20 file with extension(mp3,java,mp4,docs,txt,...)

		File parent = new File("JAVA07");
	//	FileUtils.createFiles(parent, 20, Extension.values());

		// filter file
		File[] files = parent.listFiles(file -> file.getName().endsWith("." + Extension.JAVA.getValue()));

		System.out.println("lenght: " + files.length);
		for(File file:files) {
			file.delete();
			System.out.println(file.getName()+" has been deleted");
		}
		// delete file with java extension

	}
}
