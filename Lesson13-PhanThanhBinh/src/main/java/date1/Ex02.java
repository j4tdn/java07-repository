package date1;

import java.io.File;
import java.io.IOException;

import common.Extention;
import utils.FileUtils;

public class Ex02 {
	
	public static void main(String[] args) throws IOException {
		File parent = FileUtils.createFolder("images");
		Extention[] extentionImg = {Extention.JPG, Extention.PNG};
		FileUtils.createFiles(parent, 30, extentionImg);
		System.out.println(FileUtils.changeName(parent, extentionImg));
	}
}
