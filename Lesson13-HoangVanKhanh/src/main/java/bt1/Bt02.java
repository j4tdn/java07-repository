package bt1;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import common.Extension;
import common.Garbage;
import common.Image;

public class Bt02 {
	public static void main(String[] args) throws IOException {
		File parent = new File("garbage\\images");
		if (!parent.exists()) {
			parent.mkdirs();

		}
		createdFile(parent, 30, Image.values());
		remane(parent, Image.values());
		
	}
	public static boolean createdFile(File parent, int n, Image...images) throws IOException {
		boolean isValid = false;
		for (int i = 1; i <= n; i++) {
			Image ext = images[new Random().nextInt(images.length)];
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
	public static void remane(File parent,Image...images) {
		int countPNG =1;
		int countJPG=1;
		File[] files = parent.listFiles();
		for(File file : files) {
			if(file.getName().endsWith(Image.JPG.getValue())) {
				String[] path = file.getAbsolutePath().split(file.getName());
				String pathName = path[0] + countJPG++ + Image.JPG.getValue();
				file.renameTo(new File(pathName));
			}
			else {
				String[] path = file.getAbsolutePath().split(file.getName());
				String pathName=path[0] + countPNG++ + Image.PNG;
				file.renameTo(new File(pathName));
			}
		}

	}

}
