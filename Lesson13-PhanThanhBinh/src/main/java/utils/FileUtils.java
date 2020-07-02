package utils;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

import common.Extention;

public class FileUtils {
	
	private FileUtils() {
		
	}
	
	public static boolean createFiles(File parent, int number, Extention...extentions) throws IOException {
		boolean isValid = false;
		for (int i = 0; i < number; i++) {
			Extention extention = extentions[new Random().nextInt(extentions.length)];
			String child = System.currentTimeMillis() + "." + extention;
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
	
	public static boolean moveFiles(File parent, File folderMove, Extention extention) throws IOException {
		boolean isMoved = false;
		File[] files = parent.listFiles(pathname -> pathname.getName().endsWith(extention.getValue()));
	//	Arrays.stream(files).forEach(f -> System.out.println(f.getName()+":"+f.getName().endsWith(extention.getValue())));
		for (File file : files) {
			isMoved = file.renameTo(new File(folderMove.getName() + File.separator + file.getName()));
		}
		return isMoved;
	}
	
	public static boolean changeName(File parent, Extention...extentions) {
		boolean isChanged = false;
		for (Extention extention : extentions) {
			File[] files = parent.listFiles(pathname -> pathname.getName().endsWith(extention.getValue()));
			for (int i = 0; i < files.length; i++) {
				isChanged = files[i].renameTo(new File(files[i].getParent() + File.separator + (i+1) + "." + extention.getValue()));
			}
		}
		return isChanged;
	}
	
	public static File createFolder(String pathname) {
		File folder = new File(pathname);
		if (!folder.exists()) {
			folder.mkdirs();
		}
		return folder;
	}
	
	public static File createFile(String pathname) {
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
}
