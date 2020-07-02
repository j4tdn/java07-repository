package content;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import been.custumer;
import utils.FileUtils;

public class Ex01_Readble {
	public static void main(String[] args) throws IOException {
		List<custumer> custumers = getAll();
		String pathName = "JAVA07" + File.separator + "data" + File.separator + "custumer.txt";
		File file = FileUtils.createFiles(pathName);
		// FileUtils.writeFile(file,custumers);

		List<String> lines = custumers.stream().map(custumer::toString).collect(Collectors.toList());
		
		//write file
		Files.write(file.toPath(), lines);

		//read file
		List<String> result = Files.readAllLines(file.toPath());
		System.out.println("======ReadFile=========");
		result.forEach(System.out::println);
		
		
		
		Desktop.getDesktop().open(file);

	}

	public static List<custumer> getAll() {
		return Arrays.asList(new custumer("Le Phi", "012312312", "Sai Gon"),
				new custumer("Hoai Hung", "09876543", "Da Nang"), new custumer("Le Luyen", "01235712", "Mien Dien"));
	}
}
