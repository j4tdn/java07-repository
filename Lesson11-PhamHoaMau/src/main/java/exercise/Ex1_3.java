package exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import bean.Student;

public class Ex1_3 {
	public static void main(String[] args) {
		List<Student> students = new ArrayList<>();
		students = createStudents();
		showStudents(students);
		sortByPoint(students);
		showStudents(students);
		sortByName(students);
		showStudents(students);
		students = addStudents(students);
		showStudents(students);
		searchStudents(students, 5);
		students = deleteStudent(students);
		showStudents(students);
	}

	private static void sortByName(List<Student> students) {
		System.out.println("========Sort By Name==========");
		Collections.sort(students, (o1, o2) -> o1.getFullname().compareTo(o2.getFullname()));
	}

	private static void sortByPoint(List<Student> students) {
		System.out.println("========Sort By Point==========");
		Collections.sort(students, (o1, o2) -> o1.getPoint().compareTo(o2.getPoint()));
	}

	private static List<Student> deleteStudent(List<Student> students) {
		System.out.println("========Delete Student==========");
		for (int i = 0; i < students.size(); i++) {
			if (students.get(i).getPoint() < 2.0) {
				students.remove(i);
			}
		}
		return students;
	}

	private static void searchStudents(List<Student> students, Integer id) {
		System.out.println("========Search Student==========");
		for (Student student : students) {
			if (id.equals(student.getId())) {
				System.out.println(student);
			}
		}

	}

	private static List<Student> addStudents(List<Student> students) {
		System.out.println("========Add Students==========");
		List<Student> tmpStudents = new ArrayList<>();
		Student student1 = new Student(6, "Nguyen A", 9.5);
		Student student2 = new Student(7, "Nguyen B", 9.1);
		Student student3 = new Student(8, "Nguyen C", 1.9);
		tmpStudents = Arrays.asList(student1, student2, student3);
		students = Stream.of(students, tmpStudents).flatMap(x -> x.stream()).collect(Collectors.toList());
		return students;
	}

	private static void showStudents(List<Student> students) {
		for (Student student : students) {
			System.out.println(student + " ");
		}
	}

	private static List<Student> createStudents() {
		System.out.println("=========Create Student=========");
		List<Student> students = new ArrayList<Student>();
		Student student1 = new Student(1, "Nguyen A", 8.5);
		Student student2 = new Student(2, "Nguyen B", 8.1);
		Student student3 = new Student(3, "Nguyen C", 8.9);
		Student student4 = new Student(4, "Nguyen D", 8.0);
		Student student5 = new Student(5, "Nguyen E", 1.7);
		students = Arrays.asList(student1, student2, student3, student4, student5);
		return students;
	}
}
