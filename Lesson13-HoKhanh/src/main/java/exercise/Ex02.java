package exercise;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class Ex02 {
	public static void main(String[] args) throws IOException {
		File parent = new File("images");
		if (!parent.exists()) {
			parent.mkdirs();
		}
		createFiles(parent, 30, Extension.JPG, Extension.PNG);
		renameAndSort(parent);

	}

	private static void renameAndSort(File parent) {
		int countPng = 1;
		int countJpg = 1;
		File[] images = parent.listFiles();
		for (File file : images) {
			if (file.getName().endsWith("." + Extension.PNG.getValue())) {
				String pathname = "images" + File.separator + countPng++ + "." + Extension.PNG.getValue();
				file.renameTo(new File(pathname));
			} else {
				String pathname = "images" + File.separator + countJpg++ + "." + Extension.JPG.getValue();
				file.renameTo(new File(pathname));
			}
		}
	}

	private static boolean createFiles(File parent, int n, Extension... extensions) throws IOException {
		boolean isValid = false;

		for (int i = 1; i <= n; i++) {
			String child = "" + System.currentTimeMillis() + "." + extensions[new Random().nextInt(extensions.length)].getValue();
			File file = new File(parent, child);
			file.createNewFile();
			if (!file.exists()) {
				isValid = file.createNewFile();
				if (!isValid) {
					return false;
				}
			}
		}

		return isValid;
	}
}
