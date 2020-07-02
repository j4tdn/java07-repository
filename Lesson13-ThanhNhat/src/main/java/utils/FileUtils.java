package utils;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.w3c.dom.CDATASection;

import common.Extension;

public class FileUtils {
	private FileUtils() {

	}

	public static File createFiles(String pathname) {
		File file = new File(pathname);
		File parent = file.getParentFile();

		if (!parent.exists()) {
			parent.mkdirs();
		}
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return file;
	}

	public static void createFiles(File file, String pathname) {
		File parent = file.getParentFile();

		if (!parent.exists()) {
			parent.mkdirs();
		}
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static boolean createFiles(File parent, int n, Extension... extensions) throws IOException {
		boolean isValid = false;
		while (n != 0) {
			Extension ext = extensions[new Random().nextInt(extensions.length)];
			String child = "" + System.currentTimeMillis() + "." + ext.getValue();
			File file = new File(parent, child);
			if (!file.exists()) {
				isValid = file.createNewFile();
				if (isValid == false) {
					continue;
				}
				n--;
			}
		}
		return isValid;
	}

	public static void move(File currentFolder, File targetFolder, Extension... exts) throws IOException {
		for (int i = 0; i < exts.length; i++) {
			String ext = exts[i].getValue();
			File[] filtedFiles = currentFolder.listFiles(file -> file.getName().endsWith("." + ext));
			for (File file : filtedFiles) {
				file.renameTo(createFiles("" + targetFolder.getParent() + "\\" + file.getName()));
				file.delete();
			}
		}
	}

	public static void copy(File currentFolder, File targetFolder, Extension... exts) throws IOException {
		for (int i = 0; i < exts.length; i++) {
			String ext = exts[i].getValue();
			File[] filtedFiles = currentFolder.listFiles(file -> file.getName().endsWith("." + ext));
			for (File file : filtedFiles) {
				file.renameTo(createFiles("" + targetFolder.getParent() + "\\" + file.getName()));
			}
		}
	}

	public static void rename(File folder, Extension... exts) {
		for (int i = 0; i < exts.length; i++) {
			String ext = exts[i].getValue();
			File[] filtedFiles = folder.listFiles(file -> file.getName().endsWith("." + ext));
			for (int j = 1; j <= filtedFiles.length; j++) {
				filtedFiles[j - 1].renameTo(createFiles("" + folder + "\\" + j + "." + ext));
				filtedFiles[j - 1].delete();
			}
		}
	}
}
