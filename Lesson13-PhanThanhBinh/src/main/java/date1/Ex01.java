package date1;

import java.io.File;
import java.io.IOException;

import common.Extention;
import utils.FileUtils;

public class Ex01 {
	public static void main(String[] args) throws IOException {
		File parent = FileUtils.createFolder("garbage");
		File folderMove = FileUtils.createFolder("system");
		FileUtils.createFiles(parent, 20, Extention.values());
		FileUtils.moveFiles(parent, folderMove, Extention.BAT);
	}
}
