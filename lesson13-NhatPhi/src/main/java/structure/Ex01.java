package structure;

import java.io.File;
import java.lang.management.GarbageCollectorMXBean;

public class Ex01 {
	public static void main(String[] args) throws Exception {
		// Create 4 Folder
		/*
		 * File file = new File("garbare\\system\\remid.txt"); File parent =
		 * file.getParentFile(); if(!parent.exists()) { boolean isParentCreate =
		 * parent.mkdirs(); System.out.println("dont"); } if(!parent.exists()) { try {
		 * boolean isFileCreated = file.createNewFile();
		 * 
		 * } catch (Exception ex) { ex.printStackTrace(); } }
		 * System.out.println("complice");
		 */

		/*
		 * create 20 file 
		 * File parent = new File("garbare"); Ulit.createFile(parent,20,Enum.values());
		 */

		// filter & move file .bat
		File parent = new File("garbare");
		File[] bat = parent.listFiles(file -> file.getName().endsWith("." + Enum.BAT.getValue()));

		for (File bats : bat) {
			String[] paths = bats.getAbsolutePath().split(bats.getName());
			String path = paths[0] + Garbage.SYSTEM.getValue() + "\\" + bats.getName();
			bats.renameTo(new File(path));
			System.out.println(" full");
		}
		
		// filter & move file .java
		File[] java = parent.listFiles(file -> file.getName().endsWith("." + Enum.JAVA.getValue()));

		for (File javas : java) {
			String[] paths = javas.getAbsolutePath().split(javas.getName());
			String path = paths[0] + Garbage.CODING.getValue() + "\\" + javas.getName();
			javas.renameTo(new File(path));
		}

		// filter & move file .java
		File[] java1 = parent.listFiles(file -> file.getName().endsWith("." + Enum.JAVA.getValue()));

		for (File javas : java1) {
			String[] paths = javas.getAbsolutePath().split(javas.getName());
			String path = paths[0] + Garbage.CODING.getValue() + "\\" + javas.getName();
			javas.renameTo(new File(path));
		}

		// filter & move file .mp3 mp4
		File[] mp3 = parent.listFiles(file -> file.getName().endsWith("." + Enum.MP3.getValue()));
		File[] mp4 = parent.listFiles(file -> file.getName().endsWith("." + Enum.MP4.getValue()));

		for (File mp3s : mp3) {
			String[] paths = mp3s.getAbsolutePath().split(mp3s.getName());
			String path = paths[0] + Garbage.MUSIC.getValue() + "\\" + mp3s.getName();
			mp3s.renameTo(new File(path));
		}
		for (File mp4s : mp4) {
			String[] paths = mp4s.getAbsolutePath().split(mp4s.getName());
			String path = paths[0] + Garbage.MUSIC.getValue() + "\\" + mp4s.getName();
			mp4s.renameTo(new File(path));
		}

		// filter & move file .png, .jpg, jpeg
		File[] png = parent.listFiles(file -> file.getName().endsWith("." + Enum.PNG.getValue()));
		File[] jpg = parent.listFiles(file -> file.getName().endsWith("." + Enum.JPG.getValue()));
		File[] jpeg = parent.listFiles(file -> file.getName().endsWith("." + Enum.JPEG.getValue()));

		for (File pngs : png) {
			String[] paths = pngs.getAbsolutePath().split(pngs.getName());
			String path = paths[0] + Garbage.IMAGE.getValue() + "\\" + pngs.getName();
			pngs.renameTo(new File(path));
		}
		for (File jpgs : jpg) {
			String[] paths = jpgs.getAbsolutePath().split(jpgs.getName());
			String path = paths[0] + Garbage.IMAGE.getValue() + "\\" + jpgs.getName();
			jpgs.renameTo(new File(path));
		}
		for (File jpegs : jpeg) {
			String[] paths = jpegs.getAbsolutePath().split(jpegs.getName());
			String path = paths[0] + Garbage.IMAGE.getValue() + "\\" + jpegs.getName();
			jpegs.renameTo(new File(path));
		}

		// filter & delete file.txt
		File[] txt = parent.listFiles(file -> file.getName().endsWith("." + Enum.TXT.getValue()));
		System.out.println(txt.length);

		for (File txts : txt) {
			txts.delete();
		}

	}

}
