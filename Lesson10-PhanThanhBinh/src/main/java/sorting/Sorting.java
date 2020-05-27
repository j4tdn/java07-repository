package sorting;

import java.util.Arrays;
import java.util.Comparator;
import static java.util.Comparator.comparing;
import common.Sort;

public class Sorting {
	public static void main(String[] args) {
		Student student1 = new Student("sv01", "Binh", 21);
		Student student2 = new Student("sv08", "Hoang", 20);
		Student student3 = new Student("sv07", "Binh", 23);
		Student student4 = new Student("sv04", "Nam", 21);
		Student student5 = new Student("sv02", "Phuong", 18);
		Student student6 = new Student("sv09", "An", 24);
		Student[] students = { student1, student2, student3, student4, student5, student6 };

		int[] numbers = { 20, 45, 18, 8, 9, 60, 75, 80, 95, 91 };
		objectSort(students, Sort.DESC);
		Arrays.stream(students).forEach(student -> System.out.println(student + " "));
		
		bubleSort(numbers, Sort.ASC);
		selectionSort(numbers, Sort.ASC);
		insertionSort(numbers, Sort.ASC);
		shellSort(numbers, Sort.ASC);
		showArr(numbers);
	}

	private static void showArr(int[] numbers) {
		Arrays.stream(numbers).forEach(number -> System.out.println(number + " "));
	}

	private static void bubleSort(int[] numbers, Sort sort) {
		for (int out = 0; out < numbers.length; out++) {
			for (int in = 0; in < numbers.length - 1; in++) {
				if (numbers[in] > numbers[in + 1]) {
					int temp = numbers[in];
					numbers[in] = numbers[in + 1];
					numbers[in + 1] = temp;
				}
			}
		}

		if (Sort.DESC.equals(sort)) {
			revese(numbers);
		}
	}

	private static void selectionSort(int[] numbers, Sort sort) {
		for (int out = 0; out < numbers.length - 1; out++) {
			for (int in = out + 1; in < numbers.length; in++) {
				if (numbers[out] > numbers[in]) {
					int temp = numbers[in];
					numbers[in] = numbers[out];
					numbers[out] = temp;
				}
			}
		}

		if (Sort.DESC.equals(sort)) {
			revese(numbers);
		}
	}

	private static void insertionSort(int[] numbers, Sort sort) {
		for (int out = 1; out < numbers.length - 1; out++) {
			int key = numbers[out];
			int in = out - 1;
			while (in >= 0 && numbers[in] > key) {
				numbers[in + 1] = numbers[in];
				in = in - 1;
			}
			numbers[in + 1] = key;
		}

		if (Sort.DESC.equals(sort)) {
			revese(numbers);
		}
	}

	private static void revese(int[] numbers) {
		for (int i = 0; i < numbers.length / 2; i++) {
			int temp = numbers[i];
			numbers[i] = numbers[numbers.length - i - 1];
			numbers[numbers.length - i - 1] = temp;
		}
	}

	private static void objectSort(Student[] students, Sort sort) {
		Comparator<Student> comparator = comparing(Student::getName).thenComparing(comparing(Student::getAge));

		Arrays.sort(students, comparator);
		if (Sort.DESC.equals(sort)) {
			for (int i = 0; i < students.length / 2; i++) {
				Student temp = students[i];
				students[i] = students[students.length - i - 1];
				students[students.length - i - 1] = temp;
			}
		}
	}

	private static void shellSort(int[] numbers, Sort sort) {
		for (int interval = numbers.length / 2; interval > 0; interval /= 2) {
			for (int i = interval; i < numbers.length; i++) {
				int temp = numbers[i];
				int j = 0;
				for (j = i; j >= interval && numbers[j - interval] > temp; j -= interval) {
					numbers[j] = numbers[j - interval];
				}
				numbers[j] = temp;
			}
		}

		if (Sort.DESC.equals(sort)) {
			revese(numbers);
		}
	}
	
//	private static void mergeSort(int[] numbers, Sort sort) {
//		int start = 0, end =  numbers.length - 1, middle = end / 2;
//		int length1 = middle - start + 1;
//		int length2 = end - middle;
//		int[] numbers1 = new int[length1];
//		int[] numbers2 = new int[length2];
//		
//		for (int i = 0; i < length1; i++) {
//			numbers1[i] = numbers[start + i];
//		}
//		
//		for (int i = 0; i < length2; i++) {
//			numbers2[i] = numbers[middle + 1 + i];
//		}
//		
//		int i = 0, j = 0, k = 1;
//		
//		while (i < length1 && j < length2) {
//			if (numbers1[i] <= numbers2[j]) {
//				numbers[k] = numbers1[i];
//				i++;
//			} else {
//				numbers[k] = numbers1[j];
//				j++;
//			}
//			k++;
//		}
//		
//		if (Sort.DESC.equals(sort)) {
//			revese(numbers);
//		}
//	}
	
//	private static void quickSort(int[] numbers) {
//		int low = 0, hight = numbers.length - 1;
//		int pivot = numbers[hight];
//		int left = low, right = hight - 1;
//		
//		while (true) {
//			while (left <= right && numbers[left] < pivot) {
//				left++;
//			}
//			
//			while (right >= left && numbers[right] > pivot) {
//				right--;
//			}
//			
//			if (left > right) {
//				break;
//			}
//			
//			int temp = numbers[left];
//			numbers[left] = numbers[right];
//			numbers[right] = temp;
//		}
//		
//		int temp = numbers[left];
//		numbers[left] = numbers[hight];
//		numbers[hight] = temp;
//	}
}
