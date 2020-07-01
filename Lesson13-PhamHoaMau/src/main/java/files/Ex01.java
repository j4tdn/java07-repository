package files;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import common.Garbage;
import common.fileType;

public class Ex01 {
	public static void main(String[] args) throws IOException {
		int numberOfFiles = 20;
		Garbage[] garbages = Garbage.values();
		fileType[] filetypes = fileType.values();

		File parent = new File("garbage");
		if (!parent.exists()) {
			parent.mkdirs();
		}

		createFolderAndFiles(parent, numberOfFiles, garbages, filetypes);
		moveImage(parent);
		moveBat(parent);
		moveVideo(parent);
		copyJava(parent);
		deleteTxt(parent);
	}

	private static void deleteTxt(File parent) {
		File[] texts = parent.listFiles(f -> f.getName().endsWith(fileType.TXT.getValue()));
		for (File text : texts) {
			text.delete();
		}
	}

	private static void copyJava(File parent) throws IOException {
		File[] codings = parent.listFiles(f -> f.getName().endsWith(fileType.JAVA.getValue()));
		for (File coding : codings) {
			String path = parent + "\\" + Garbage.CODING.getValue();
			File codingCopy = new File(path, coding.getName());
			if (!codingCopy.exists()) {
				codingCopy.createNewFile();
			}
		}
	}

	private static void moveVideo(File parent) {
		File[] musics = parent.listFiles(
				f -> f.getName().endsWith(fileType.MP3.getValue()) || f.getName().endsWith(fileType.MP4.getValue()));
		for (File music : musics) {
			String[] paths = music.getAbsolutePath().split(music.getName());
			String path = paths[0] + Garbage.MUSIC.getValue() + "\\" + music.getName();
			music.renameTo(new File(path));
		}
	}

	private static void moveBat(File parent) {
		File[] systems = parent.listFiles(f -> f.getName().endsWith(fileType.BAT.getValue()));
		for (File system : systems) {
			String[] paths = system.getAbsolutePath().split(system.getName());
			String path = paths[0] + Garbage.SYSTEM.getValue() + "\\" + system.getName();
			system.renameTo(new File(path));
		}
	}

	private static void moveImage(File parent) {
		File[] images = parent.listFiles(f -> f.getName().endsWith(fileType.PNG.getValue())
				|| f.getName().endsWith(fileType.JPG.getValue()) || f.getName().endsWith(fileType.JPEG.getValue()));
		for (File image : images) {
			String[] paths = image.getAbsolutePath().split(image.getName());
			String path = paths[0] + Garbage.IMAGE.getValue() + "\\" + image.getName();
			image.renameTo(new File(path));
		}
	}

	private static void createFolderAndFiles(File parent, int numberOfFiles, Garbage[] garbages, fileType[] filetypes)
			throws IOException {
		for (int i = 0; i < garbages.length; i++) {
			File gar = new File(parent, "" + garbages[i].getValue());
			if (!gar.exists()) {
				gar.mkdirs();
			}
		}

		for (int i = 0; i < numberOfFiles; i++) {
			fileType ext = filetypes[new Random().nextInt(filetypes.length)];
			String path = "" + System.currentTimeMillis() + i + "." + ext.getValue();
			File file = new File(parent, path);
			if (!file.exists()) {
				file.createNewFile();
			}
		}
	}
}
