package sorting;

import java.util.Arrays;
import java.util.Comparator;

import javax.naming.ldap.SortControl;

import common.Sort;

public class ex01 {
	public static void main(String[] args) {
		int[] numbers = { 88, 11, 9, 5, 22 };
		String[] students = { null, "panda", "chick", "pig", "tiger", null };

		int keynumber = 88;
		String keyString = "chick";

		Arrays.sort(numbers);
		Arrays.sort(students);
		Arrays.sort(students, (o1,o2)->{
			if (o1==null) {
				return -1;
			}
			if (o2==null) {
				return 1;
			}
			return o1.compareTo(o2);
		});
		
		sort(students, Sort.AEC);
		System.out.println("int: " + Arrays.binarySearch(numbers, keynumber));
		System.out.println("String: " + Arrays.binarySearch(students, keyString));
		Arrays.binarySearch(numbers, keynumber);
		Arrays.binarySearch(students, keyString);

		System.out.println("=============================");
		Arrays.parallelSort(students, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);// o1-o2= ? return >0 hoan vj neu <0 thi khong hoan vi
			}
		});
		Arrays.stream(students).forEach(student -> System.out.printf(student + " "));

	}

	// buble sort: null last
	private static void sort(String[] students, Sort sort) {
		for (int out = 0; out < students.length; out++) {
			if (students[out] == null) {
				continue;
			}
			for (int in = students.length; in >= out; in--) {
				if (students[in] == null) {
					String temp = students[in];
					students[in] = students[out];
					students[out] = temp;
					break;
				}

				int coparision = students[out].compareTo(students[in]);
				if (Sort.DESC.equals(sort)) {
					coparision *= -1;
				}
				if (coparision > 0) {
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
			String tmp = students[i];
			students[i] = students[students.length - i - 1];
			students[students.length - i - 1] = tmp;
		}
	}

}
