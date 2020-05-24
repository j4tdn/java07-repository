package sorting;

import java.util.Arrays;
import java.util.Comparator;

import date01.Sort;
import sorting.Student;

import static java.util.Comparator.comparing;

public class objectSort {
	public static void main(String[] args) {

		Student students1 = new Student("123", "Lê Minh", 33);
		Student students2 = new Student("456", "Đặng Hùng", 35);
		Student students3 = new Student("789", "Trung Anh", 27);
		Student[] students = { students1, students2, students3 };

		sortName(students, Sort.ASC);
		Arrays.stream(students).forEach(student -> System.out.println(student));
		System.out.println("========================");
		sortAge(students, Sort.DESC);
		Arrays.stream(students).forEach(student -> System.out.println(student));

	}

	private static void sortName(Student[] students, Sort sort) {
		Comparator<Student> comparator = comparing(Student::getName).thenComparing(Student::getName);
		Arrays.sort(students, comparator);

		if (Sort.DESC.equals(sort)) {
			reversed(students);
		}
	}

	private static void sortAge(Student[] students, Sort sort) {
		Comparator<Student> comparator = comparing(Student::getAge).thenComparing(Student::getAge);
		Arrays.sort(students, comparator);

		if (Sort.DESC.equals(sort)) {
			reversed(students);
		}
	}

	private static void reversed(Student[] students) {
		for (int i = 0; i < students.length / 2; i++) {
			Student tmp = students[i];
			students[i] = students[students.length - i - 1];
			students[students.length - i - 1] = tmp;
		}
	}
}
