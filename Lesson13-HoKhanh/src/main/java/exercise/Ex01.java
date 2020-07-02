package exercise;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Ex01 {
	public static void main(String[] args) throws IOException {
		File parent = new File("garbage");
		if (!parent.exists()) {
			parent.mkdirs();
		}
		createFolder();
		createFiles(parent, 20, Extension.values());
		fileManipulation(parent);

	}

	private static void fileManipulation(File parent) {
		File[] images = parent.listFiles(f -> f.getName().endsWith("." + Extension.JPEG.getValue())
				|| f.getName().endsWith("." + Extension.JPG.getValue())
				|| f.getName().endsWith("." + Extension.PNG.getValue()));
		for (File file : images) {
			String pathname = "garbage" + File.separator + "image"+ File.separator+file.getName();
			file.renameTo(new File(pathname));

		}
		
		File[] musics = parent.listFiles(f -> f.getName().endsWith("." + Extension.MP3.getValue())
				|| f.getName().endsWith("." + Extension.MP4.getValue()));
		for (File file : musics) {
			String pathname = "garbage" + File.separator + "music"+ File.separator+file.getName();
			file.renameTo(new File(pathname));

		}
		
		File[] systems = parent.listFiles(f -> f.getName().endsWith("." + Extension.BAT.getValue()));
		for (File file : systems) {
			String pathname = "garbage" + File.separator + "system"+ File.separator+file.getName();
			file.renameTo(new File(pathname));

		}
		
		File[] files = parent.listFiles(f -> f.getName().endsWith("." + Extension.TXT.getValue()));
		for (File file : files) {
			file.delete();

		}
		
		File[] codings = parent.listFiles(f -> f.getName().endsWith("." + Extension.JAVA.getValue()));
		for (File file : codings) {
			FileWriter fw =null;
			
			try {
				FileReader fr= new FileReader(file);
				String pathname = "garbage" + File.separator + "coding";
				File copyFile = new File(pathname,file.getName());
				if(!copyFile.exists()) {
					copyFile.createNewFile();
				}
				fw = new FileWriter(copyFile,true);
				int i=0;
				while(( i=fr.read())!=-1) {
					fw.write(i);
				}
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
		
		
	}

	private static boolean createFiles(File parent, int n, Extension... extensions) throws IOException {
		boolean isValid = false;

		for (int i = 1; i <= n; i++) {
			String child = "" + i + "." + extensions[new Random().nextInt(extensions.length)].getValue();
			File file = new File(parent, child);
			file.createNewFile();
			if (!file.exists()) {
				isValid = file.createNewFile();
				if (!isValid) {
					return false;
				}
			}
		}

		return isValid;
	}

	private static void createFolder() {
		File music = new File("garbage\\music");
		if (!music.exists()) {
			music.mkdirs();
		}
		File system = new File("garbage\\system");
		if (!system.exists()) {
			system.mkdirs();
		}
		File coding = new File("garbage\\coding");
		if (!coding.exists()) {
			coding.mkdirs();
		}
		File image = new File("garbage\\image");
		if (!image.exists()) {
			image.mkdirs();
		}
	}
}
