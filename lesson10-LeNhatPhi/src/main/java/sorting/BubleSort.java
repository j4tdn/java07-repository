package sorting;

import java.lang.reflect.Array;
import java.util.Arrays;

public class BubleSort {
	public static void main(String[] args) {
		int[] arrays = { 11, 22, 55, 44, 33, 7,1 };
		bubleSort(arrays);
		Arrays.stream(arrays).forEach(numbers -> System.out.print(numbers + "  "));
	}

	public static void bubleSort(int arrays[]) {
		int array = arrays.length;
		for (int i = 0; i < array - 1; i++) {// compare number 1 > number 2 if permutation
			for (int j = 0; j < array - i - 1; j++) {
				if (arrays[j] > arrays[j + 1]) {
					
					int temp = arrays[j];
					arrays[j] = arrays[j + 1];
					arrays[j + 1] = temp;
				}
			}
		}
	} 
}
