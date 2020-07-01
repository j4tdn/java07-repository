package utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import been.custumer;
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

	public static boolean createFiles(File parent, int n, Extension... extensions) throws IOException {
		boolean isValid = false;
		for (int i = 1; i <= n; i++) {
			Extension ext = extensions[new Random().nextInt(extensions.length)];
			String child = "" + i + "." + ext.getValue();
			File file = new File(parent, child);
			if (!file.exists()) {
				isValid = file.createNewFile();
				if (isValid == false) {
					return false;
				}
			}
		}
		return isValid;
	}

	public static void writeFile(File file, List<custumer> customers) {
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter(file, true);
			bw = new BufferedWriter(fw);
			for (custumer customer : customers) {
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
				ex.printStackTrace();
			}
		}
	}
}
