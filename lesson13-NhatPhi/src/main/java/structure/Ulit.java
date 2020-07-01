package structure;

import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Ulit {
	public static File createFiles(String pathname) {
		File file = new File(pathname);
		File parent = file.getParentFile();
		if (!parent.exists()) {
			parent.mkdirs();
		}
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return file;
	}

	public static boolean createFile(File parent, int n, Enum... extensition) throws Exception {
		boolean isValue = false;
		for (int i = 0; i < n; i++) {
			Enum ext = extensition[new Random().nextInt(extensition.length)];
			String child = "" + i + "." + ext.getValue();
			File file = new File(parent, child);
			if (!file.exists()) {
				isValue = file.createNewFile();
				if (isValue == false) {
					return false;
				}
			}
		}
		return isValue;
	}

	public static boolean createFileImage(File parent, int n, Enum... extensition) throws Exception {
		boolean isValue = false;
		for (int i = 0; i < n; i++) {
			Enum ext = extensition[new Random().nextInt(extensition.length)];
			if (ext == Enum.JPG || ext == Enum.PNG) {
				String child = "" + i + "." + ext.getValue();
				File file = new File(parent, child);
				if (!file.exists()) {
					isValue = file.createNewFile();
					if (isValue == false) {
						return false;
					}
				}
			}
		}
		return isValue;
	}
}
