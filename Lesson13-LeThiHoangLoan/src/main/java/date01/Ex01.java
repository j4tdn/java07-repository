
package date01;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import common.Extension;

public class Ex01 {
	public static void main(String[] args) throws IOException {
		File parent = new File("garbage");
		createFile(parent, 20, Extension.values());

		System.out.println("========Move========");
		move(parent, "image", ".png");
		move(parent, "image", ".jpg");
		move(parent, "image", ".jpeg");
		move(parent, "music", ".mp3");
		move(parent, "music", ".mp4");
		move(parent, "system", ".bat");
		System.out.println("========Copy========");
		copy(parent, "coding", ".java");
		System.out.println("========Delete======");
		delete(parent, ".txt");
	}

	public static void createFile(File parent, int n, Extension... extensions) throws IOException {
		List<String> subFolder = Arrays.asList("image", "music", "system", "coding");

		for (String sub : subFolder) {
			String subFol = parent + "\\" + sub;
			File folder = new File(subFol);
			if (!folder.exists()) {
				folder.mkdirs();
			}
		}

		int i = 1;
		while (i <= n) {
			Extension ext = extensions[new Random().nextInt(extensions.length)];
			String child = System.currentTimeMillis() + ext.getValue();
			File files = new File(parent, child);

			if (!files.exists()) {

				files.createNewFile();
				System.out.println(i);
				i++;
			}

		}

	}

	public static void move(File parent, String child, String ext) throws IOException {

		File[] files = parent.listFiles(file -> file.getName().endsWith(ext));

		File subFolder = new File(parent + "\\" + child);

		for (File f : files) {
			File file = new File(subFolder, f.getName());

			if (!file.exists()) {
				file.createNewFile();
			}

			f.delete();
			System.out.println(f.getName() + " has been moved");
		}
	}

	public static void copy(File parent, String child, String ext) throws IOException {

		File[] files = parent.listFiles(file -> file.getName().endsWith(ext));

		File folder = new File(parent + "\\" + child);

		for (File f : files) {
			File file = new File(folder, f.getName());

			if (!file.exists()) {

				file.createNewFile();
				System.out.println(f.getName() + " has been copied");
			}
		}
	}

	public static void delete(File parent, String ext) throws IOException {

		File[] files = parent.listFiles(file -> file.getName().endsWith(ext));

		for (File file : files) {
			file.delete();
			System.out.println(file.getName() + " has been deleted");
		}
	}
}