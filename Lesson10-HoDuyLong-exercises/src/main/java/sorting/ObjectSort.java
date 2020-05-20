package sorting;

import java.util.Comparator;
import java.util.Arrays;
import static java.util.Comparator.comparing;

import beans.Student;

public class ObjectSort {
	public static void main(String[] args) {
		Student[] students = mock();

		Comparator<Student> comparator = comparing(Student::getName).thenComparing(comparing(Student::getAge));

		System.out.println("=========ASCENDING===========");
		Arrays.sort(students, comparator);
		Arrays.stream(students).forEach(student -> System.out.println(student));

		System.out.println("=========DESCENDING===========");
		Arrays.sort(students, comparator);
		reverse(students);
		Arrays.stream(students).forEach(student -> System.out.println(student));
	}

	private static Student[] mock() {
		return new Student[] { new Student("sv01", "A", 16), new Student("sv05", "F", 35), new Student("sv17", "B", 69),
				new Student("sv02", "G", 17), new Student("sv09", "E", 75) };
	}

	private static void reverse(Student[] students) {
		for (int i = 0; i < students.length / 2; i++) {
			Student temp = students[i];
			students[i] = students[students.length - i - 1];
			students[students.length - i - 1] = temp;
		}
	}
}
