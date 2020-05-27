package sorting;

import java.util.Arrays;

public class ShellSort {
	public static void main(String[] args) {
		int[] arrays = { 11, 22, 55, 44, 33, 7, 1, 10 };
		shellSort(arrays);
		Arrays.stream(arrays).forEach(numbers -> System.out.print(numbers + "  "));
	}

	public static int shellSort(int arrays[]) {
		int arr = arrays.length;
		for (int range = arr / 2; range > 0; range /= 2) {// thực hiện sắp xếp xen kẽ và chạy cho đến khi mảng đực sắp
															// xếp ok
			for (int i = range; i < arr; i += 1) {// thêm các phần tử thứ i vào trong mảng đã được sắp xếp
				int temp = arrays[i];
				int j;
				for (j = i; j >= range && arrays[j - range] > temp; j -= range) {
					arrays[j] = arrays[j - range];
				}
				arrays[j] = temp;
			}
		}
		return 0;
	}

}
