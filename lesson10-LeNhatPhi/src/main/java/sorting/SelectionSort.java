package sorting;

import java.lang.reflect.Array;
import java.util.Arrays;
public class SelectionSort {
	public static void main(String[] args) {
		int[] arrays = { 11, 22, 55, 44, 33, 7, 1, 10 };
		selectionSort(arrays);
		Arrays.stream(arrays).forEach(numbers -> System.out.print(numbers + "  "));
	}
	public static void selectionSort(int arrays[]) {
		int arr =  arrays.length;
		for(int i = 0; i < arr - 1; i ++) {
			int min_index = i;
			for(int j = i + 1; j < arr;j++) {
				if(arrays[j] < arrays[min_index]) {
					min_index = j;
				}
			}
		int temp = arrays[min_index];
		arrays[min_index] =  arrays[i];
		arrays[i] = temp;
		}
	} 
}
