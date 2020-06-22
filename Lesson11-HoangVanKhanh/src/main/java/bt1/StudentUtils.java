package bt1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class StudentUtils {

	Scanner sc = new Scanner(System.in);

	public static void imp(List<Student> student) {
		Scanner sc = new Scanner(System.in);
		Student std = new Student();
		do {
			System.out.println("Import id :");
			String id = sc.nextLine();
			if (check(student, id)) {
				std.setId(id);
				break;
			}
		} while (true);
		System.out.println("Import Name :");
		String name = sc.nextLine();
		std.setName(name);
		System.out.println("Import Average :");
		float average = sc.nextFloat();
		std.setAverage(average);
		student.add(std);
	}

	private static boolean check(List<Student> student, String id) {
		for (Student std : student) {
			if (id.equals(std.getId())) {
				return false;
			}
		}
		return true;
	}

	public static void out(List<Student> student) {
		student.forEach(System.out::println);
	}

	public static void sortByAverage(List<Student> student) {
		student.sort((s1, s2) -> String.valueOf(s1.getAverage()).compareTo(String.valueOf(s2.getAverage())));
	}

	public static void sortByName(List<Student> student) {
		student.sort((s1, s2) -> s1.getName().compareTo(s2.getName()));
	}

	public static void add(List<Student> student) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap so ng can them :");
		int n = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < n; i++) {
			imp(student);
		}
	}

	public static void search(List<Student> student) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap ma sv can tim kiem :");
		String id = sc.nextLine();
		int tmp = 0;
		for (Student st : student) {
			if (id.equals(st.getId())) {
				System.out.println(st);
				tmp++;
				break;
			}

		}
		if (tmp == 0) {
			System.out.println("Sinh vien khong co trong danh sach");
		}
	}

	public static void remove(List<Student> student) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap ma sv can xoa :");
		String id = sc.nextLine();
		student.removeIf(s -> id.equals(s.getId()));
	}

}
