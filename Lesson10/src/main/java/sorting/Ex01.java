package sorting;

import java.util.Arrays;
import java.util.Comparator;

import common.Sort;

public class Ex01 {
	public static <T> void main(String[] args) {
		int[] numbers = { 3, 2, 1, 9, 8, 7, 6, 5 };
		Arrays.sort(numbers);
		String[] students = { null, "nhat", "khung", "dien", null };
		// Arrays.sort(students);

		int keyNumber = 1;
		String keyString = "nhat";

		System.out.println("int " + Arrays.binarySearch(numbers, keyNumber));
		// System.out.println("String " + Arrays.binarySearch(students, keyString));

		System.out.println("\n===============");

		Arrays.sort(students, (o1, o2) -> {
			if (o1 == null) {
				return -1;

			}
			if (o2 == null) {
				return 1;
			}
			return o1.compareTo(o2);
		});
		Arrays.stream(students).forEach(student -> System.out.print(student + " "));
		System.out.println("\n===============");

		sort(students, Sort.DESC);
		Arrays.stream(students).forEach(student -> System.out.print(student + " "));
	}

	private static void sort(String[] student, Sort sort) {
		for (int out = 0; out < student.length; out++) {
			if (student[out] == null) {
				continue;
			}
			for (int in = student.length - 1; in > out; in--) {
				if (student[in] == null) {
					String tmp = student[in];
					student[in] = student[out];
					student[out] = tmp;
					break;
				}
				int comparision = student[out].compareTo(student[in]);

				if (comparision > 0) {
					String tmp = student[in];
					student[in] = student[out];
					student[out] = tmp;
				}
			}
		}
		if (Sort.DESC.equals(sort)) {
			reverse(student);

		}
	}

	private static void reverse(String[] student) {
		for (int i = 0; i < student.length / 2; i++) {
			String tmp = student[i];
			student[i] = student[student.length - i - 1];
			student[student.length - i - 1] = tmp;
		}
	}
}
