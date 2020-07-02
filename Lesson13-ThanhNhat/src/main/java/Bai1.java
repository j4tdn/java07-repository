import java.io.File;
import java.io.IOException;

import common.Extension;
import utils.FileUtils;

public class Bai1 {
	public static void main(String[] args) throws IOException {
		File garbage = new File("garbage");
		File image = FileUtils.createFiles("garbage\\image\\ ");
		File music = FileUtils.createFiles("garbage\\music\\ ");
		File system = FileUtils.createFiles("garbage\\system\\ ");
		File coding = FileUtils.createFiles("garbage\\coding\\ ");

		FileUtils.createFiles(garbage, 20, Extension.values());

		FileUtils.move(garbage, image, Extension.JPG, Extension.PNG, Extension.JPEG);

		FileUtils.move(garbage, music, Extension.MP3, Extension.MP4);

		FileUtils.move(garbage, system, Extension.BAT);

		FileUtils.copy(garbage, coding, Extension.JAVA);
	}
}
