package sorting;

import java.util.Arrays;

public class InsertSort {
	public static void main(String[] args) {
		int[] arrays = { 11, 22, 55, 44, 33, 7, 1, 10 };
		insertionSort(arrays);
		Arrays.stream(arrays).forEach(numbers -> System.out.print(numbers + "  "));
	}

	public static void insertionSort(int arrays[]) {
		int arr =  arrays.length;
		for(int i  = 0; i < arr ;i++) {
			int count = arrays[i];
			int j = i -1;
			
			while(j >= 0 && arrays[j] > count) {
				arrays[j + 1] = arrays[j];
				j = j - 1;
			}
			arrays[j + 1] = count;
		}
	} 
}
