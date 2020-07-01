package content;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import been.custumer;
import utils.FileUtils;

public class Ex01 {
	public static void main(String[] args) throws IOException {
		List<custumer> custumers = getAll();
		String pathName = "JAVA07" + File.separator 
				+ "data" + File.separator
				+ "custumer.txt";
		File file = FileUtils.createFiles(pathName);
		FileUtils.writeFile(file,custumers);
		Desktop.getDesktop().open(file);
	}
	
	private static List<custumer> getAll(){
		return Arrays.asList(new custumer("Le Phi", "012312312", "DA NANG"),
				new custumer("Hoai Hung", "09876543", "Quang Tri"),
				new custumer("Le Luyen", "01235712", "Lao"));
	}
}
