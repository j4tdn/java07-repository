import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Ex011 {
	public static void main(String args[]) {
		int arr[] = { 7, 7, 8, 8, 9, 1, 1, 4, 2, 2 };
		int arr2[] = { 5, 7, 9, 10, 20, 9, 7, 11 };
		int n = arr.length;
		int m = arr2.length;
		System.out.print("các số chỉ xuất hiện 1 lần:");
		occurredOnce(arr, n);
		System.out.println();
		System.out.print("các số xuất hiện trên 1 lần: ");
		printRepeating(arr2, m);
	}

	static void occurredOnce(int arr[], int n) {
		Arrays.sort(arr);
		if (arr[0] != arr[1])
			System.out.println(arr[0] + " ");
		for (int i = 1; i < n - 1; i++)
			if (arr[i] != arr[i + 1] && arr[i] != arr[i - 1])
				System.out.print(arr[i] + " ");
		if (arr[n - 2] != arr[n - 1])
			System.out.print(arr[n - 1] + " ");
	}

	static void printRepeating(int arr[], int n) {
		Map<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
		for (int i = 0; i < n; i++) {
			try {
				map.put(arr[i], map.get(arr[i]) + 1);
			} catch (Exception e) {
				map.put(arr[i], 1);
			}
		}
		for (Entry<Integer, Integer> e : map.entrySet()) {
			if (e.getValue() > 1) {
				System.out.print(e.getKey() + " ");
			}
		}
	}

}
