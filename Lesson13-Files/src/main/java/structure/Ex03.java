package structure;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

import common.Extension;
import utils.FileUtils;

public class Ex03 {
	public static void main(String[] args) throws IOException {
		// tạo 20 file(mp3,mp4,jpg,png,bat,java)
		File parent = new File("JAVA07");
		FileUtils.createFiles(parent, 20, Extension.values());
		File[] files = parent.listFiles(file -> file.getName().endsWith(Extension.JAVA.getValue()));

		System.out.println("length: " + files.length);
		for (File file : files) {
			file.delete();
			System.out.println(file.getName() + " has been deleted");
		}
		// filter file

	}
}
