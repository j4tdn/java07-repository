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

	public static File createFile(String pathname) {
		File file = new File(pathname);
		File parent = file.getParentFile();
		if (!parent.exists()) {
			boolean isParentCreated = parent.mkdirs();
			System.out.println(" isParentCreated: " + isParentCreated);
		}
		if (!file.exists()) {

			try {
				boolean isFileCreated = file.createNewFile();
				System.out.println("isFileCreated:" + isFileCreated);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return file;
	}

	public static void writeFile(File file, List<Customer> customers) {
		// TODO Auto-generated method stubb
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			for (Customer customer : customers) {
				bw.write(customer.toString());
				bw.newLine();
			}
		} catch (Exception ex) {

			ex.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
				if (fw != null)
					fw.close();
			} catch (Exception ex) {
				// TODO: handle exception
				ex.printStackTrace();
			}

		}

	}
}
