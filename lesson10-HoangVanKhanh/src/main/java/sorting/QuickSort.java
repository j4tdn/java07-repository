package sorting;

public class QuickSort {
	public static void quickSort(int[] arr, int left, int right) {
		if (arr == null || arr.length == 0)
			return;

		if (left >= right)
			return;

		int key = left + (right - left) / 2;
		int pivot = arr[key];
		int i = left, j = right;

		while (i <= j) {
			while (arr[i] < pivot) {
				i++;
			}

			while (arr[j] > pivot) {
				j--;
			}

			if (i <= j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}

		if (left < j)
			quickSort(arr, left, j);

		if (right > i)
			quickSort(arr, i, right);
	}

}
