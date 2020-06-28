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

	public static boolean createFiles(File parent, int n, Extension... extension) throws IOException {
		boolean isValid = false;
		for (int i = 1; i <= n; i++) {
			Extension ext = extension[new Random().nextInt(extension.length)];
			String child = "" + System.currentTimeMillis() + i + "." + ext.getValue();
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
				if (bw != null)
					bw.close();
				if (fw != null)
					fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static File createFile(String pathName) {
		File file = new File(pathName);
		File perant = file.getParentFile();
		if (!perant.exists()) {
			boolean isParentCreated = perant.mkdirs();
			System.out.println("isParentCreated: " + isParentCreated);
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