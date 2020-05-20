package sorting;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		int[] Arrs = { 200,3, 2, 5, 2, 80, 4, 6, 1, 7, 9 };
		//BubleSort.BubleSort(Arrs);
		//SelectionSort.SelectionSort(Arrs);
		//InsertionSort.insertionSort(Arrs);
		//ShellSort.shellSort(Arrs);
		//MergeSort.mergeSort(Arrs, 0, Arrs.length-1);
		QuickSort.quickSort(Arrs, 0, Arrs.length-1);

		Arrays.stream(Arrs).forEach(Arr -> System.out.print(Arr + " "));

	}

}
