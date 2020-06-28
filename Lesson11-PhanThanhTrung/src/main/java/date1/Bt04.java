package date1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import student.Students;

public class Bt04 {
	public static void main(String[] args) {
		List<Students> students = new ArrayList<>();
		creatListStudent(students);
		System.out.println("Sau khi trộn: ");
		shuffle(students);
		randomStudent(students);

	}

	private static void creatListStudent(List<Students> students) {
		students.add(new Students("Trung"));
		students.add(new Students("Hoàng"));
		students.add(new Students("Khánh"));
		students.add(new Students("Trực"));
		students.add(new Students("Đạt"));
		students.forEach(s -> System.out.println(s.getFullName()));

	}

	private static void shuffle(List<Students> students) {
		Collections.shuffle(students);
		students.forEach(s -> System.out.println(s.getFullName()));
	}

	private static void randomStudent(List<Students> students) {
		Random rd = new Random();
		int count = students.size();
		while (true) {
			System.out.println("sv ngẫu nhiên là: ");
			int index = rd.nextInt(count);
			students.get(index);
			System.out.println(students.get(index).getFullName());
			students.remove(index);
			break;
		}

	}
}
