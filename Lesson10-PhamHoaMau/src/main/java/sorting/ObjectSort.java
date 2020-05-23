package sorting;

import java.util.Arrays;
import java.util.Comparator;

public class ObjectSort {
	public static void main(String[] args) {
		Student[] students = { new Student("123", "Nguyen Van A", 18), new Student("124", "Nguyen Van B", 17),
				new Student("125", "Nguyen Van C", 20), new Student("121", "Nguyen Van D", 11),
				new Student("122", "Nguyen Van E", 17) };
		objectSort(students, SortType.ASC);
	}

	private static void objectSort(Student[] students, SortType sort) {
		System.out.println("Given arrays: ");
		Arrays.stream(students).forEach(student -> System.out.println(student));
		Comparator<Student> comparator = Comparator.comparing(Student::getAge).thenComparing(Student::getName);
		Arrays.sort(students, comparator);
		if (sort == SortType.ASC) {
			System.out.println("Sorted Ascending Arrays: ");
			Arrays.stream(students).forEach(student -> System.out.println(student));
		} else {
			System.out.println("Sorted Descending Arrays: ");
			arraysReverse(students);
			Arrays.stream(students).forEach(student -> System.out.println(student));
		}
	}

	private static void arraysReverse(Student[] students) {
		for (int index = 0; index < students.length / 2; index++) {
			Student temp = students[index];
			students[index] = students[students.length - index - 1];
			students[students.length - index - 1] = temp;
		}
	}
}
