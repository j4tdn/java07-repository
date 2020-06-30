package date01;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

import common.Extension;

public class Ex02 {
	public static void main(String[] args) throws IOException {
		int numOfFiles = 30;
		Extension[] extensions = Extension.values();
		File parent = new File("images");

		if (!parent.exists()) {
			parent.mkdirs();
		}

		do {
			System.out.println(" _______________________");
			System.out.println("|1. Tạo file.           |");
			System.out.println("|2. Working with file.  |");
			System.out.println("|3. Clean the directory.|");
			System.out.println("|0. Exit.               |");
			System.out.println("|_______________________|");
			System.out.print(">>> Nhập lựa chọn : ");
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			int select = Integer.parseInt(sc.nextLine());
			switch (select) {
			case 1:
				createdFiles(parent, extensions, numOfFiles);
				System.out.println("File successfully created!");
				break;
			case 2:
				workingWithFile(parent);
				System.out.println("Done!");
				break;
			case 3:
				cleanFolder(parent);
				System.out.println("The folder has been cleaned!");
				break;
			case 0:
				System.exit(0);

			default:
				System.out.println("> Nhập 0, 1, 2 or 3 !");
			}
		} while (true);
	}

	private static void cleanFolder(File parent) {
		File[] files = parent.listFiles();
		for (File file : files) {
			file.delete();
		}
	}

	private static void workingWithFile(File parent) {
		File[] files = parent.listFiles();
		int countJPG = 1;
		int countPNG = 1;
		for (File file : files) {
			if (file.getName().endsWith(Extension.JPG.getValue())) {
				String[] paths = file.getAbsolutePath().split(file.getName());
				String path = paths[0] + countJPG++ + Extension.JPG.getValue();
				File newName = new File(path);
				file.renameTo(newName);
			} else {
				String[] paths = file.getAbsolutePath().split(file.getName());
				String path = paths[0] + countPNG++ + Extension.PNG.getValue();
				File newName = new File(path);
				file.renameTo(newName);
			}
		}
	}

	private static void createdFiles(File parent, Extension[] extensions, int numOfFiles) throws IOException {
		for (int i = 0; i < numOfFiles; i++) {
			Extension ext = extensions[new Random().nextInt(2)];
			String path = "" + System.currentTimeMillis() + i + ext.getValue();
			File file = new File(parent, path);

			if (!file.exists()) {
				file.createNewFile();
			}
		}
	}
}