package bt1;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import common.Extension;
import common.Garbage;

public class Bt01 {
	public static void main(String[] args) throws IOException {
		Garbage[] garbages = Garbage.values();

		File parent = new File("garbage");
		if (!parent.exists()) {
			parent.mkdirs();

		}
		//createdFoder(parent, 4, garbages);
		createdFile(parent, 20, Extension.values());
		moveImage(parent, Extension.values());
		moveMusic(parent, Extension.values());
		moveSystem(parent, Extension.values());
		copyCoding(parent, Extension.values());
		deleted(parent, Extension.values());
	}

	public static boolean createdFile(File parent, int n, Extension... extensions) throws IOException {
		boolean isValid = false;
		for (int i = 1; i <= n; i++) {
			Extension ext = extensions[new Random().nextInt(extensions.length)];
			String child = System.currentTimeMillis() + i + ext.getValue();
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

	public static boolean createdFoder(File parent, int n, Garbage[] garbages) {
		boolean isValid = false;
		for (int i = 0; i < n; i++) {
			File file = new File(parent, garbages[i].getValue());
			if (!file.exists()) {
				isValid = file.mkdirs();
				if (!isValid) {
					return false;
				}
			}

		}
		return isValid;
	}

	public static void moveImage(File parent, Extension... extensions) {
		File[] files = parent.listFiles(f -> f.getName().endsWith(Extension.JPG.getValue())
				|| f.getName().endsWith(Extension.PNG.getValue()) || f.getName().endsWith(Extension.JPEG.getValue()));
		for(File file : files) {
			String[] path = file.getAbsolutePath().split(file.getName());
			String pathString =path[0] + Garbage.IMAGE.getValue() + "\\" + file.getName();
			File fle = new File(pathString);
			file.renameTo(fle);
			
			
		}

	}
	public static void moveMusic(File parent, Extension... extensions) {
		File[] files = parent.listFiles(f -> f.getName().endsWith(Extension.MP3.getValue())
				|| f.getName().endsWith(Extension.MP4.getValue()));
		for(File file : files) {
			String[] path = file.getAbsolutePath().split(file.getName());
			String pathString =path[0] + Garbage.MUSIC.getValue() + "\\" + file.getName();
			File fle = new File(pathString);
			file.renameTo(fle);
			
			
		}

	}
	public static void moveSystem(File parent, Extension... extensions) {
		File[] files = parent.listFiles(f -> f.getName().endsWith(Extension.BAT.getValue()));
		for(File file : files) {
			String[] path = file.getAbsolutePath().split(file.getName());
			String pathString =path[0] + Garbage.SYSTEM.getValue() + "\\" + file.getName();
			File fle = new File(pathString);
			file.renameTo(fle);
			
			
		}

	}
	public static void copyCoding(File parent,Extension...extensions) throws IOException {
		File[] files = parent.listFiles(f -> f.getName().endsWith(Extension.JAVA.getValue()));
		for(File file : files) {
			String[] path = file.getAbsolutePath().split(file.getName());
			String pathString =path[0] + Garbage.CODING.getValue() + "\\" + file.getName();
			File fle = new File(pathString);
			if(!fle.exists()) {
				fle.createNewFile();
			}
		}
	}
	public static void deleted(File parent,Extension...extensions) {
		File[] files = parent.listFiles(f -> f.getName().endsWith(Extension.TXT.getValue()));
		for(File file : files) {
			file.delete();
			System.out.println(file.getName() + "has been deleted file");
		}
	}

}
