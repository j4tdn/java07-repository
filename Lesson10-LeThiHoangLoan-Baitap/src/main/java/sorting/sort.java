package sorting;

import java.util.Arrays;

public class sort {
	public static void main(String[] args) {
		int[] numbers = { 1, 4, 65, 3, 6, 76, 2, 42, 9, 99 };
		
		System.out.println("\n============Bubble===============");
		bubbleSort(numbers);
		Arrays.stream(numbers).forEach(num -> System.out.print(num + " "));
		System.out.println("\n============Insert===============");

		insert(numbers);
		Arrays.stream(numbers).forEach(num -> System.out.print(num + " "));
		System.out.println("\n============Merge===============");
		
		mergeSort(numbers, 0, numbers.length - 1);
		Arrays.stream(numbers).forEach(num -> System.out.print(num + " "));
		System.out.println("\n============Quick===============");
		quickSort(numbers, 0, numbers.length - 1);
		Arrays.stream(numbers).forEach(num -> System.out.print(num + " "));
		System.out.println("\n============Selection============");
		selectionSort(numbers);
		Arrays.stream(numbers).forEach(num -> System.out.print(num + " "));
		System.out.println("\n============Shell================");
		shellsort(numbers);
		Arrays.stream(numbers).forEach(num -> System.out.print(num + " "));
	}

	private static void bubbleSort(int[] numbers) {
		for (int i = 0; i < numbers.length - 1; i++)
			for (int j = 0; j < numbers.length - i - 1; j++)
				if (numbers[j] > numbers[j + 1]) {
					int temp = numbers[j];
					numbers[j] = numbers[j + 1];
					numbers[j + 1] = temp;
				}

	}

	private static int[] insert(int[] numbers) {
		for (int i = 1; i < numbers.length; i++) {
			int tmp = numbers[i];
			int j = i;
			while (j > 0 && numbers[j - 1] > tmp) {
				numbers[j] = numbers[j - 1];
				j--;
			}
			numbers[j] = tmp;
		}
		return numbers;

	}

	private static void sort(int[] numbers, int l, int m, int r) {
		int n1 = m - l + 1;
		int n2 = r - m;

		int L[] = new int[n1];
		int R[] = new int[n2];

		for (int i = 0; i < n1; ++i)
			L[i] = numbers[l + i];
		for (int j = 0; j < n2; ++j)
			R[j] = numbers[m + 1 + j];

		int i = 0, j = 0;

		int k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				numbers[k] = L[i];
				i++;
			} else {
				numbers[k] = R[j];
				j++;
			}
			k++;
		}

		while (i < n1) {
			numbers[k] = L[i];
			i++;
			k++;
		}

		while (j < n2) {
			numbers[k] = R[j];
			j++;
			k++;
		}
	}

	private static void mergeSort(int numbers[], int l, int r) {
		if (l < r) {
			int m = (l + r) / 2;

			mergeSort(numbers, l, m);
			mergeSort(numbers, m + 1, r);

			sort(numbers, l, m, r);
		}
	}

	public static void quickSort(int[] numbers, int start, int end) {

		int partition = partition(numbers, start, end);

		if (partition - 1 > start) {
			quickSort(numbers, start, partition - 1);
		}
		if (partition + 1 < end) {
			quickSort(numbers, partition + 1, end);
		}
	}

	public static int partition(int[] numbers, int start, int end) {
		int pivot = numbers[end];

		for (int i = start; i < end; i++) {
			if (numbers[i] < pivot) {
				int temp = numbers[start];
				numbers[start] = numbers[i];
				numbers[i] = temp;
				start++;
			}
		}

		int temp = numbers[start];
		numbers[start] = pivot;
		numbers[end] = temp;

		return start;
	}

	private static void selectionSort(int[] numbers) {
		for (int i = 0; i < numbers.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < numbers.length - 1; j++)

				if (numbers[j] < numbers[min])
					min = j;

			int temp = numbers[min];
			numbers[min] = numbers[i];
			numbers[i] = temp;
		}
	}

	private static void shellsort(int[] numbers) {
		for (int in = numbers.length / 2; in > 0; in /= 2) {

			for (int out = in; out < numbers.length; out++) {
				int temp = numbers[out];

				int j;
				for (j = out; j >= in && numbers[j - in] > temp; j -= in)
					numbers[j] = numbers[j - in];
				numbers[j] = temp;
			}
		}
	}
}
