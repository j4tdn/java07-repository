package utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import beans.Customer;
import common.Extension;

public class FileUtils {

	private FileUtils() {

	}

	public static boolean createFiles(File parent, int n, Extension... extensions) throws IOException {
		boolean isValid = false;

		for (int i = 1; i <= n; i++) {
			String child = i + "." + extensions[new Random().nextInt(extensions.length)].getValue();
			File file = new File(parent, child);
			if (!file.exists()) {
				isValid = file.createNewFile();
				if (!isValid) {
					return false;
				}
			}
		}

		return isValid;
	}

	public static void writeFile(File file, List<Customer> customers) {

		FileWriter fw = null;
		BufferedWriter bw = null;

		try {
			fw = new FileWriter(file, true);
			bw = new BufferedWriter(fw);
			for (Customer cus : customers) {
				bw.write(cus.toString());
				bw.newLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null) bw.close();
				if (fw != null) fw.close();

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public static File createFile(String pathName) {
		File file = new File(pathName);
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
}
