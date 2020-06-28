package utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.swing.text.StyledEditorKit.BoldAction;

import beans.Customer;
import common.Extension;

public class FileUtils {

	private FileUtils() {

	}

	public static boolean createFile(File parent, int n, Extension... extensions) throws IOException {
		boolean isValid = false;
		for (int i = 1; i <= n; i++) {
			Extension ext = extensions[new Random().nextInt(extensions.length)];
			String child = "" + i + "." + ext.getValue();
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

	public static File createFile(String path) {
		boolean isCreated = false;
		File file = new File(path);
		File parent = file.getParentFile();
		if (!parent.exists()) {
			parent.mkdirs();
		}
		if (!(file.exists())) {
			try {
				isCreated = file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return file;
	}

	public static void writeFile(File file, List<Customer> customers) {
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter(file, true);
			bw = new BufferedWriter(bw);
			for (Customer customer : customers) {
				System.out.println(customer.toString());
				bw.write(customer.toString());
				bw.newLine();
			}
		} catch (Exception e) {
			
		} finally {
			try {
				if(bw != null) bw.close();
				if(fw != null) fw.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
