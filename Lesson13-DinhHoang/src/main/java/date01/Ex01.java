package date01;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

import common.Extension;
import common.Garbage;

public class Ex01 {
	public static void main(String[] args) throws IOException {
		int numOfFile = 20;
		Garbage[] garbages = Garbage.values();
		Extension[] extensions = Extension.values();
		File parent = new File("garbage");

		if (!parent.exists()) {
			parent.mkdirs();
		}
		do {
			System.out.println(" ___________________________");
			System.out.println("|1. Tạo thư mục và tạo file.|");
			System.out.println("|2. Working with file.      |");
			System.out.println("|3. Clean the directory.    |");
			System.out.println("|0. Exit.                   |");
			System.out.println("|___________________________|");
			System.out.print(">>> Nhập lựa chọn : ");
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			int select = Integer.parseInt(sc.nextLine());
			switch (select) {
			case 1:
				createFoldersAndFiles(garbages, extensions, parent, numOfFile);
				System.out.println("File successfully created!");
				break;
			case 2:
				workingWithFile(parent);
				System.out.println("Done!");
				break;
			case 3:
				cleanFolder(parent, garbages);
				System.out.println("The folder has been cleaned!");
				break;
			case 0:
				System.exit(0);

			default:
				System.out.println("> Nhập 0, 1, 2 or 3 !");
			}
		} while (true);
	}

	private static void cleanFolder(File parent, Garbage[] garbages) {
		cleanFile(parent);
		for (int i = 0; i < 4; i++) {
			File parents = new File(parent, garbages[i].getValue());
			cleanFile(parents);
			parents.delete();
		}
	}

	private static void cleanFile(File parent) {
		File[] files = parent.listFiles();
		for (File file : files) {
			file.delete();
		}
	}

	private static void createFoldersAndFiles(Garbage[] garbages, Extension[] extensions, File parent, int numOfFile)
			throws IOException {
		for (int i = 0; i < garbages.length; i++) {
			File gar = new File(parent, "" + garbages[i].getValue());
			if (!gar.exists()) {
				gar.mkdirs();
			}
		}

		for (int i = 0; i < numOfFile; i++) {
			Extension ext = extensions[new Random().nextInt(extensions.length)];
			String path = "" + System.currentTimeMillis() + i + ext.getValue();
			File file = new File(parent, path);
			if (!file.exists()) {
				file.createNewFile();
			}
		}
	}

	private static void workingWithFile(File parent) throws IOException {
		File[] images = parent.listFiles(f -> f.getName().endsWith(Extension.PNG.getValue())
				|| f.getName().endsWith(Extension.JPG.getValue()) || f.getName().endsWith(Extension.JPEG.getValue()));
		for (File image : images) {
			String[] paths = image.getAbsolutePath().split(image.getName());
			String path = paths[0] + Garbage.IMAGE.getValue() + "\\" + image.getName();
			image.renameTo(new File(path));
		}
		File[] musics = parent.listFiles(
				f -> f.getName().endsWith(Extension.MP3.getValue()) || f.getName().endsWith(Extension.MP4.getValue()));
		for (File music : musics) {
			String[] paths = music.getAbsolutePath().split(music.getName());
			String path = paths[0] + Garbage.MUSIC.getValue() + "\\" + music.getName();
			music.renameTo(new File(path));
		}
		File[] systems = parent.listFiles(f -> f.getName().endsWith(Extension.BAT.getValue()));
		for (File system : systems) {
			String[] paths = system.getAbsolutePath().split(system.getName());
			String path = paths[0] + Garbage.SYSTEM.getValue() + "\\" + system.getName();
			system.renameTo(new File(path));
		}
		File[] codings = parent.listFiles(f -> f.getName().endsWith(Extension.JAVA.getValue()));
		for (File coding : codings) {
			String path = parent + "\\" + Garbage.CODING.getValue();
			File codingCopy = new File(path, coding.getName());
			if (!codingCopy.exists()) {
				codingCopy.createNewFile();
			}
		}
		File[] texts = parent.listFiles(f -> f.getName().endsWith(Extension.TXT.getValue()));
		for (File text : texts) {
			text.delete();
		}
	}
}