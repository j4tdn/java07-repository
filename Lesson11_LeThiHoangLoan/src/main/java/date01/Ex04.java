package date01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Ex04 {
	private static Random rd = new Random();

	public static void main(String[] args) {
		List<String> students = creat();
		System.out.println("Danh sach SV : ");
		show(students);
		System.out.println("================");
		System.out.println("Xao SV :");
		shuffer(students);
		show(students);
		System.out.println("================");
		System.out.println("Random :");
		System.out.println(random(students));

	}

	public static void show(List<String> students) {
		students.forEach(System.out::println);
	}

	public static List<String> creat() {
		List<String> students = new ArrayList<String>();
		students.add("Linh");
		students.add("Minh");
		students.add("Ninh");
		students.add("Binh");
		students.add("Vinh");

		return students;
	}

	public static List<String> shuffer(List<String> students) {
		Collections.shuffle(students);
		return students;

	}

	public static String random(List<String> students) {
		int rand = rd.nextInt(students.size()) + 0;
		return students.get(rand);

	}
}
