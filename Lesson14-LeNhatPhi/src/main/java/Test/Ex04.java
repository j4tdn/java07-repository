package Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Ex04 {
	public static void main(String[] args) {
		List<Student> student = new ArrayList<Student>();
		student = createStudent(student);
		showStudent(student);
		System.out.println("===========================");
		searchStudent(student, 7.5);
		System.out.println("===========================");
		searchStudentWM(student);
		System.out.println("===========================");
		searchStudentID(student, 10109999);
		System.out.println("===========================");
		sortStudentGender(student);
		showStudent(student);
	}

	private static void searchStudent(List<Student> students, Double point) {
		for (Student student : students) {
			if (point.equals(student.getPoint())) {
				System.out.println(student);
			}
		}
	}

	private static void sortStudentGender(List<Student> student) {
		Collections.sort(student, (o1, o2) -> o1.getGender().compareTo(o2.getGender()));
	}

	private static void searchStudentID(List<Student> students, Integer id) {
		for (Student student : students) {
			if (id.equals(student.getId())) {
				System.out.println(student);
			}
		}
	}

	private static void searchStudentWM(List<Student> students) {
		for (Student student : students) {
			if ("Nu".equals(student.getGender())) {
				System.out.println(student);
			}
		}
	}

	private static void showStudent(List<Student> student) {
		for (Student students : student) {
			System.out.println(" " + students);
		}
	}

	private static List<Student> createStudent(List<Student> student) {
		Student student1 = new Student(10109999, "Le Nhat 1", 8.2, "Nu");
		Student student2 = new Student(10108888, "Le Nhat 2", 7.5, "Nam");
		Student student3 = new Student(10107777, "Le Nhat 3", 4.0, "Nam");
		Student student4 = new Student(10106666, "Le Nhat 4", 5.5, "Nu");
		student = Arrays.asList(student1, student2, student3, student4);
		return student;
	}
}
