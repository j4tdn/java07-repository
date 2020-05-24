package arrays;

import java.util.Arrays;
import java.util.Comparator;

import javax.rmi.CORBA.Stub;

import common.Sort;

public class Ex01 {
	public static void main(String[] args) {
		int[] numbers = { 11, 9, 33, 6, 4, 7 };
		Arrays.sort(numbers);
		String[] students = { null, "panda", "Chick", "pig", "tiger", null };

		int keyNumber = 4;
		String keyString = "Chick";

		System.out.println(Arrays.binarySearch(numbers, keyNumber));
		System.out.println(Arrays.binarySearch(students, keyString));

		System.out.println("=======================================");
		Arrays.sort(students, (o1, o2) -> {
			if (o1 == null) {
				return 1;
			}
			if (o2 == null) {
				return -1;
			}
			return o2.compareTo(o1);
		});
		Arrays.stream(students).forEach(student -> {
			System.out.print(student + " ");
		});
		System.out.println("");
		sort(students, Sort.DESC);
		Arrays.stream(students).forEach(student -> {
			System.out.print(student + " ");
		});
	}

	private static void sort(String[] students, Sort sort) {
		for (int out = 0; out < students.length; out++) {
			if (students[out] == null) {
				continue;
			}
			for (int in = students.length - 1; in > out; in--) {
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
		if (sort.DESC.equals(sort)) {
			reversed(students);
		}
	}
	private static void reversed(String[] students) {
		for (int i = 0; i < students.length / 2; i++) {
			String tmp = students[i];
			students[i] = students[students.length - i - 1];
			students[students.length - i - 1] = tmp;
		}

	}

}
