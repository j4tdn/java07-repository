package files;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import common.fileType;

public class Ex02 {
	public static void main(String[] args) throws IOException {
		int numberOfFiles = 30;
		fileType[] fileTypes = fileType.values();
		File parent = createFolder();
		createFiles(parent, fileTypes, numberOfFiles);
		renameFiles(parent);
	}

	private static void renameFiles(File parent) {
		File[] files = parent.listFiles();
		int JPGindex = 1;
		int PNGindex = 1;
		for (File file : files) {
			if (file.getName().endsWith(fileType.JPG.getValue())) {
				String[] paths = file.getAbsolutePath().split(file.getName());
				String path = paths[0] + JPGindex++ + "." + fileType.JPG.getValue();
				File newName = new File(path);
				file.renameTo(newName);
			} else {
				String[] paths = file.getAbsolutePath().split(file.getName());
				String path = paths[0] + PNGindex++ + "." + fileType.PNG.getValue();
				File newName = new File(path);
				file.renameTo(newName);
			}
		}
	}

	private static void createFiles(File parent, fileType[] fileTypes, int numberOfFiles) throws IOException {
		for (int i = 0; i < numberOfFiles; i++) {
			fileType ext = fileTypes[new Random().nextInt(2)];
			String path = "" + System.currentTimeMillis() + i + "." + ext.getValue();
			File file = new File(parent, path);

			if (!file.exists()) {
				file.createNewFile();
			}
		}
	}

	private static File createFolder() {
		File parent = new File("images");

		if (!parent.exists()) {
			parent.mkdirs();
		}
		return parent;
	}
}
