package date01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import beans.Student;

public class Ex04 {
	public static void main(String[] args) {
		List<Student> students = listStudents();
		System.out.println("1. DANH SÁCH SV:");
		students.forEach(System.out::println);
		System.out.println("==============================");
		System.out.println("2. XÁO DANH SÁCH SV:");
		Collections.shuffle(students);
		students.forEach(System.out::println);
		System.out.println("==============================");
		System.out.println("3. RANDOM 1 SV TRONG DSSV VA IN RA:");
		int count = 10;
		while (students.size() > 0) {
			System.out.println("-> SV thứ " + (11 - count) + " :");
			random(students, count);
			count--;
		}
	}

	private static List<Student> listStudents() {
		List<Student> students = new ArrayList<>();
		students.add(new Student("sv01", "Hoàng", 7.5f));
		students.add(new Student("sv02", "Trung", 7.0f));
		students.add(new Student("sv03", "Khánh", 7.1f));
		students.add(new Student("sv04", "Khanh", 7.0f));
		students.add(new Student("sv05", "Hiệp", 7.4f));
		students.add(new Student("sv06", "Bình", 7.3f));
		students.add(new Student("sv07", "Tèo", 7.8f));
		students.add(new Student("sv08", "Thúy", 8.0f));
		students.add(new Student("sv09", "Trang", 7.6f));
		students.add(new Student("sv10", "Linh", 7.5f));
		return students;
	}

	private static void random(List<Student> students, int count) {
		Random rd = new Random();
		int rdStd = rd.nextInt(count);
		Student std = students.get(rdStd);
		System.out.println("- " + std);
		students.removeIf(s -> std.equals(s));
	}
}
