package sorting;

import java.util.Arrays;

public class MergesSort {
	// thuật toán của merger short : chia nhỏ mảng thành 2 phần, chia đôi mảng của
	// phần thứ nhất thành 2 phần nhỏ và tương tự rồi sắp xếp từng mảng và nối lại
	// khi nối lại cũng phải xắp xếp để có mảng tăng
	private static void merge(int arr[], int l, int m, int r) { // tìm kích thước của 2 mảng nhỏ
		int n1 = m - l + 1;
		int n2 = r - m;
		int L[] = new int[n1];
		int R[] = new int[n2];
		// sao chép dữ liệu đực chia nhỏ vào mảng tạm lời là L vs R
		for (int i = 0; i < n1; ++i)
			L[i] = arr[l + i];
		for (int j = 0; j < n2; ++j)
			R[j] = arr[m + 1 + j];
		int i = 0, j = 0;
		// tìm các dữ liệu so sánh và lưu vào biến tạm
		int k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}
		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}
		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}

	// hàm xắp xếp của của mảng nhỏ khi được hợp nhất
	private static void sort(int arr[], int l, int r) {
		if (l < r) {
			int m = (l + r) / 2;
			// sắp xếp nửa thứ nhất và nửa thứ 2
			sort(arr, l, m);
			sort(arr, m + 1, r);
			// hợp nhất thành 1 mảng
			merge(arr, l, m, r);
		}
	}
	public static void main(String[] args) {
		int[] arrays = { 11, 22, 55, 44, 33, 7, 1, 10 };
		sort(arrays, 0, arrays.length-1);
		Arrays.stream(arrays).forEach(numbers -> System.out.print(numbers + "  "));
	}
}
