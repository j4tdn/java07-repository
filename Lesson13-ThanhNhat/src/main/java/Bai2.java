import java.io.File;
import java.io.IOException;

import common.Extension;
import utils.FileUtils;

public class Bai2 {
	public static void main(String[] args) throws IOException {
		File empty = FileUtils.createFiles("image\\ ");
		File image = empty.getParentFile();

		FileUtils.createFiles(image, 20, Extension.JPG, Extension.PNG);

		FileUtils.rename(image, Extension.JPG, Extension.PNG);
	}
}
