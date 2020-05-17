package sorting;

import java.util.Arrays;
import java.util.Comparator;

import common.SortType;

public class Ex01 {
	public static void main(String[] args) {
		int[] number = { 5, 4, 6, 9, 7, 2 };
		Arrays.sort(number);

		String[] students = { null, "red", "yellow", "black", null };
		//Arrays.sort(students);

		System.out.println("==========================");
		System.out.println("ASC + null first:");

		Comparator<String> comparator = (String o1, String o2) -> {
				if (o1 == null) {
					return -1;
				}
				if(o2 == null) {
					return 1;
				}
				return o1.compareTo(o2);
			};	

		Arrays.sort(students, comparator);
		Arrays.stream(students).forEach(student -> System.out.print(student + " "));

		System.out.println("\n==========================");
		System.out.println("DECS + null last:");

		Sort(students, SortType.DECS);
		Arrays.stream(students).forEach(student -> System.out.print(student + " "));
	}

	// ASC + null first
	private static void Sort(String[] students, SortType sort) {
		for (int out = 0; out <= students.length - 1; out++) {
			String s2 = students[out];
			if (s2 == null) {
				continue;
			}
			for (int in = students.length - 1; in > out; in--) {
				String s1 = students[in];
				if (s1 == null) {
					String temp = students[in];
					students[in] = students[out];
					students[out] = temp;
					break;
				}

				int comparision = students[in].compareTo(students[out]);
		
				if (comparision < 0) {
					String temp = students[in];
					students[in] = students[out];
					students[out] = temp;
				}
			}
		}
		if(SortType.DECS.equals(sort)) {
			for (int i = 0; i < students.length/2; i++) {
				String tmp = students[i];
				students[i] = students[students.length - 1 - i];
				students[students.length - 1 - i] = tmp;
			}
		}
	}
}
