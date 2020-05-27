package sorting;

import java.util.Arrays;

public class Sort {
	public static void main(String[] args) {
		int[] numbers = { 2, 4, 1, 28, 99, 120, 234, 123, 4, 234 };
		Student[] students = { new Student("BK01", "Dinh Quang Duy", 23), new Student("BK11", "Hoang Van Cuong", 12),
				new Student("BK21", "Nguyen Van Manh", 21), new Student("BK02", "Tran Thanh Trung", 24),
				new Student("BK99", "Nguyen Van Lam", 29), new Student("BK09", "Tran Thi Thanh", 20),
				new Student("BK03", "Bui Tien Dung", 24), new Student("BK07", "Do Hung Dung", 28),
				new Student("BK02", "Nguyen Quang Hai", 17), new Student("BK18", "Mai Tien Thanh", 31),

		};

		print(numbers, students);
	}

	private static void print(int[] numbers, Student[] students) {
		System.out.println("==========buble sort==========");
		bubleSort(numbers, MethodSort.ASC);
		Arrays.stream(numbers).forEach(number -> System.out.print(number + " "));
		System.out.println("\n\n==========selection sort==========");
		selectionSort(numbers, MethodSort.ASC);
		Arrays.stream(numbers).forEach(number -> System.out.print(number + " "));
		System.out.println("\n\n==========insertion sort==========");
		insertionSort(numbers, MethodSort.ASC);
		Arrays.stream(numbers).forEach(number -> System.out.print(number + " "));
		System.out.println("\n\n==========shell sort==========");
		shellSort(numbers, MethodSort.ASC);
		Arrays.stream(numbers).forEach(number -> System.out.print(number + " "));
		System.out.println("\n\n==========quick sort==========");
		quickSort(numbers, 0, numbers.length - 1);
		Arrays.stream(numbers).forEach(number -> System.out.print(number + " "));
		System.out.println("\n\n==========object sort==========");
		objectSort(students, MethodSort.ASC, SortBy.AGE);
		Arrays.stream(students).forEach(st -> System.out.println(st));

	}

	private static void bubleSort(int[] numbers, MethodSort sort) {
		for (int out = 0; out < numbers.length; out++) {
			for (int in = numbers.length - 1; in > out; in--) {
				if (numbers[out] > numbers[in]) {
					swapNumber(numbers, out, in);
				}
			}
		}
		if (MethodSort.DESC.equals(sort)) {
			reversedNumber(numbers);
		}
	}

	private static void selectionSort(int[] numbers, MethodSort sort) {
		for (int out = 0; out < numbers.length; out++) {
			int min = numbers[out];
			int index = out;
			for (int in = out + 1; in < numbers.length; in++) {
				if (numbers[in] < min) {
					min = numbers[in];
					index = in;
				}
			}
			swapNumber(numbers, out, index);
		}
		if (MethodSort.DESC.equals(sort)) {
			reversedNumber(numbers);
		}
	}

	private static void insertionSort(int[] numbers, MethodSort sort) {
		for (int out = 0; out < numbers.length; out++) {
			for (int in = out + 1; in < numbers.length; in++) {
				if (numbers[in] < numbers[out]) {
					swapNumber(numbers, out, in);
				}
			}
		}
		if (MethodSort.DESC.equals(sort)) {
			reversedNumber(numbers);
		}
	}

	private static void shellSort(int[] numbers, MethodSort sort) {
		for (int out = numbers.length / 2; out > 0; out /= 2) {
			for (int in = 0; in < numbers.length - out; in++) {
				int index = in;
				do {
					if (numbers[index] > numbers[index + out]) {
						swapNumber(numbers, index, index + out);
					}
					index = index - out;
				} while (index >= 0 && numbers[index] > numbers[index + out]);
			}
		}

		if (MethodSort.DESC.equals(sort)) {
			reversedNumber(numbers);
		}
	}

	private static void quickSort(int[] numbers, int left, int right) {
		if (left < right) {
			int mid = getMid(numbers, left, right);
			quickSort(numbers, left, mid - 1);
			quickSort(numbers, mid + 1, right);
		}
	}

	private static int getMid(int[] numbers, int left, int right) {
		int tmp = numbers[left];
		while (left < right) {
			while (left < right && numbers[right] >= tmp) {
				right--;
			}
			numbers[left] = numbers[right];
			while (left < right && numbers[left] <= tmp) {
				left++;
			}
			numbers[right] = numbers[left];
		}
		numbers[left] = tmp;
		return left;
	}

	private static void objectSort(Student[] students, MethodSort sort, SortBy sortBy) {
		for (int out = 0; out < students.length; out++) {
			for (int in = out + 1; in < students.length; in++) {
				if (SortBy.AGE.equals(sortBy)) {
					if (students[in].getAge() < students[out].getAge()) {
						swapStudent(students, out, in);
					}
				} else {
					if (students[in].getName().compareTo(students[out].getName()) > 0) {
						swapStudent(students, out, in);
					}
				}
			}
		}

		if (MethodSort.DESC.equals(sort)) {
			reversedStudent(students);
		}
	}

	private static void swapStudent(Student[] students, int out, int in) {
		Student tmp = students[in];
		students[in] = students[out];
		students[out] = tmp;

	}

	private static void swapNumber(int[] numbers, int out, int in) {
		int tmp = numbers[in];
		numbers[in] = numbers[out];
		numbers[out] = tmp;

	}

	private static void reversedNumber(int[] numbers) {
		for (int i = 0; i < numbers.length / 2; i++) {
			int tmp = numbers[i];
			numbers[i] = numbers[numbers.length - i - 1];
			numbers[numbers.length - i - 1] = tmp;
		}

	}

	private static void reversedStudent(Student[] students) {
		for (int i = 0; i < students.length / 2; i++) {
			Student tmp = students[i];
			students[i] = students[students.length - i - 1];
			students[students.length - i - 1] = tmp;
		}

	}
}

enum MethodSort {
	DESC, ASC
}

enum SortBy {
	NAME, AGE
}
