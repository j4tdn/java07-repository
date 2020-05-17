package sorting;

import java.util.Arrays;
import java.util.Comparator;

import common.Sort;

public class Ex01 {
	public static void main(String[] args) {
		int[] numbers = { 11, 9, 5, 47, 62, 69 };
		String[] students = { null, "E", "B", "F", "D", "A", null };

		int keyNumber = 5;
		String keyString = "F";

//		Arrays.sort(numbers);
//		Arrays.sort(students);
//		System.out.println(Arrays.binarySearch(numbers, keyNumber));
//		System.out.println(Arrays.binarySearch(students, keyString));
//
//		System.out.println("=====================");
//		Arrays.sort(students, new Comparator<String>() {
//			@Override
//			public int compare(String o1, String o2) {
//				return o1.compareTo(o2);
//			}
//		});
//		Arrays.stream(students).forEach(student -> System.out.print(student + " "));
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
		System.out.println("\n=====================");
		sort(students, Sort.DESC);
		Arrays.stream(students).forEach(student -> System.out.print(student + " "));
	}

	// bubble sort: null last
	private static void sort(String[] students, Sort sort) {
		for (int out = 0; out < students.length - 1; out++) {
			if (students[out] == null) {
				continue;
			}
			for (int in = students.length - 1; in >= out; in--) {
				if (students[in] == null) {
					String temp = students[in];
					students[in] = students[out];
					students[out] = temp;
					break;
				}
				int comparision = students[out].compareTo(students[in]);
				if (comparision > 0) {
					String temp = students[in];
					students[in] = students[out];
					students[out] = temp;
				}
			}
		}
		
		if (Sort.DESC.equals(sort)) {
			reversed(students);
		}
	}
	
	private static void reversed(String[] students) {
		for (int i = 0; i < students.length / 2; i++) {
			String temp = students[i];
			students[i] = students[students.length - i - 1];
			students[students.length - i - 1] = temp;
		}
	}
}
