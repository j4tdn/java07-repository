
package date01;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import common.Extension;

public class Ex02 {
	public static void main(String[] args) throws IOException {
		File parent = new File("images");
		createFile(parent, 30);

		rename(parent);

	}

	public static void createFile(File parent, int n, Extension... extension) {
		if (!parent.exists()) {
			parent.mkdirs();
		}

		int i = 1;
		while (i <= n) {
			List<String> exten = Arrays.asList(Extension.JPG.getValue(), Extension.PNG.getValue());
			String ext = exten.get(new Random().nextInt(exten.size()));
			String child = System.currentTimeMillis() + ext;
			File files = new File(parent, child);

			if (!files.exists()) {
				try {
					files.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
				System.out.println(i);
				i++;
			}

		}

	}

	public static void rename(File parent) {
		File[] filePng = parent.listFiles(file -> file.getName().endsWith(".png"));
		File[] fileJpg = parent.listFiles(file -> file.getName().endsWith(".jpg"));

		for (int i = 0; i < fileJpg.length; i++) {
			File newfile = new File(parent + "\\" + i + ".jpg");
			fileJpg[i].renameTo(newfile);
		}
		for (int i = 0; i < filePng.length; i++) {
			File newfile = new File(parent + "\\" + i + ".png");
			filePng[i].renameTo(newfile);
		}

	}
}