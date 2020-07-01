package structure;

import java.io.File;

public class Ex02 {
	public static void main(String[] args) throws Exception {
		File parent = new File("garbare\\image");
		Ulit.createFileImage(parent, 30, Enum.JPG.PNG);
		System.out.println("Complice");
	}
}
