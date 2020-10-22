package sorting;

import java.util.Arrays;
import java.util.Comparator;

import common.Sort;

public class Ex01 {
	public static void main(String[] args) {
		int[] numbers = { 11, 88, 9, 5, 22 };
		Arrays.sort(numbers);

		String[] students = { null, "panda", "chick", "pig", "tiger", null };
		Arrays.sort(students);

		int keyNumber = 88;
		String keyString = "chick";

		System.out.println("int: " + Arrays.binarySearch(numbers, keyNumber));
		System.out.println("string: " + Arrays.binarySearch(students, keyString));

		System.out.println("=============================");
		Arrays.sort(students, (o1, o2) -> {
			if (o1 == null) {
				return 1;
			}
			if (o2 == null) {
				return -1;
			}
			return o1.compareTo(o2);
		});
		Arrays.stream(students).forEach(student -> System.out.print(student + "  "));

		System.out.println("\n=============================");
		sort(students, Sort.DESC);
		Arrays.stream(students).forEach(student -> System.out.print(student + "  "));

	}

	// bubble sort: null last
	private static void sort(String[] students, Sort sort) {
		for (int out = 0; out < students.length; out++) {
			if (students[out] == null) {
				continue;
			}
			for (int in = students.length-1; in > out; in--) {
				if (students[in] == null) {
					String tmp = students[in];
					students[in] = students[out];
					students[out] = tmp;
					break;
				}

				int comparision = students[out].compareTo(students[in]);
				if (comparision > 0) {
					String tmp = students[in];
					students[in] = students[out];
					students[out] = tmp;
				}
			}
		}
		
		if (Sort.DESC.equals(sort)) {
			reversed(students);
		}
		
	}
	
	private static void reversed(String[] students) {
		for (int i = 0; i < students.length/2; i++) {
			String tmp = students[i];
			students[i] = students[students.length - i - 1];
			students[students.length - i - 1] = tmp;
		}
	}
	
}
