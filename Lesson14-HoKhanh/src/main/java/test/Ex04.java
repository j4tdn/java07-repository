package test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class Ex04 {
	public static void main(String[] args) throws IOException {
		File file = new File("student.txt");
		List<Student> students = new ArrayList<Student>();
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		List<String> result = Files.readAllLines(file.toPath());
		for(String s:result) {
			String[] strings = s.split(", ");
			Student a= new Student();
			a.setId(strings[0]);
			a.setName(strings[1]);
			a.setPoint(Float.parseFloat(strings[2]));
			students.add(a);
		}
		
	}
}
