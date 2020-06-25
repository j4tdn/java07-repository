package bt.b1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Bai4 {
	public static void main(String[] argv) {
		Random rand = new Random();
		List<Student> students = new ArrayList<>();
		students = StudentUtils.getStudent(students);
		StudentUtils.show(students);
		
		Collections.shuffle(students);
		System.out.println(students.get(rand.nextInt(students.size())));
	}
}
