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
		boolean isValue = false;

		for (int i = 1; i <= n; i++) {
			Extension ext = extensions[new Random().nextInt(extensions.length)];
			String child = i + "." + ext.getValue();
			File file = new File(parent, child);

			if (!file.exists()) {

				isValue = file.createNewFile();
				if (!isValue) {
					return false;
				}

			}
		}

		return isValue;

	}

	public static File createFile(String pathname) throws IOException {
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

	public static void writeFiles(File file, List<Customer> customers) {

		FileWriter fw = null;

		BufferedWriter bw = null;

		try {
			fw = new FileWriter(file,true);
			bw = new BufferedWriter(fw);
			for (Customer customer : customers) {
				bw.write(customer.toString());
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
}
