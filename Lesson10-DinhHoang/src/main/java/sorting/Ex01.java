package sorting;

import java.util.Arrays;
//import java.util.Comparator;

import common.Sort;

public class Ex01 {
	public static void main(String[] args) {
		int[] numbers = { 1, 1, 0, 3, 1, 9, 9, 8 };
		Arrays.sort(numbers);

		String[] students = { null, "Tư Tưởng HCM", "Xác suất TK", "Anh văn 2.2", "TH OOP", null };
		// Arrays.sort(students);

//		int keyNumber = 0;
//		String keyString = "TH OOP";

//		Arrays.stream(numbers).forEach(number -> System.out.print(number + " "));
//		System.out.println("\nInt: " + Arrays.binarySearch(numbers, keyNumber));
//		System.out.println("===============================================");
//		Arrays.stream(students).forEach(student -> System.out.print(student + ", "));
//		System.out.println("\nString: " + Arrays.binarySearch(students, keyString));
//		System.out.println("===============================================");
		System.out.print("Sort: ");
		sort(students, Sort.DEC);
		Arrays.stream(students).forEach(student -> System.out.print(student + ", "));
	}

//	private static void sort(String[] students) {
//		Arrays.sort(students, new Comparator<String>() {
//			@Override
//			public int compare(String o1, String o2) {
//				return o2.compareTo(o1);
//			}
//		});
//		Arrays.stream(students).forEach(student -> System.out.print(student + ", "));
//		;

//		Arrays.sort(students, (o1, o2) -> o2.compareTo(o1));

//		Arrays.sort(students, (o1, o2) -> {
//			if (o1 == null) {
//				return -1;
//			}
//			if (o2 == null) {
//				return 1;
//			}
//			return o2.compareTo(o1);
//		});
//	}

	private static void sort(String[] students, Sort sort) {
		for (int out = students.length - 1; out >= 0; out--) {
			if (students[out] == null) {
				continue;
			}
			for (int in = 0; in < out; in++) {
				if (students[in] == null) {
					String tmp = students[in];
					students[in] = students[out];
					students[out] = tmp;
					break;
				}

				int comparision = students[in].compareTo(students[out]);
//				if (Sort.DEC.equals(sort)) {
//					comparision *= -1;
//				}
				if (comparision > 0) {
					String tmp = students[in];
					students[in] = students[out];
					students[out] = tmp;
				}
			}
		}

		if (Sort.DEC.equals(sort)) {
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