package structure;

import java.io.File;
import java.io.FileFilter;

import common.Extension;
import utils.FileUtils;

public class Ex03 {
	
	public static void main(String[] args) throws Exception{
		File parent = new File("JAVA07");
		//created 20 file with extension(mp3,mp4,jpg,png,bat,md)
		//FileUtils.createdFile(parent, 20, Extension.values());
		
		//filte file
		File[] files = parent.listFiles(
				file->file.getName().endsWith("." +Extension.BAT.getValue()));
		System.out.println(files.length);
		//delete file with java extension
		
		for(File file : files) {
			file.delete();
			System.out.println(file.getName() + " has been deteted file");
		}
		
		
	}

}
