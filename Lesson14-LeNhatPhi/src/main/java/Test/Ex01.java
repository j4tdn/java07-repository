package Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ex01 {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 5, 5, 3, 1 };
		int n = arr.length;
		appear(arr, n);
	}

	public static void appear(int[] arr, int n) {
		HashMap<Integer, Integer> hm = new HashMap<>();
		for (int i = 0; i < n; i++) {
			if (hm.containsKey(arr[i])) {
				hm.put(arr[i], 1 + hm.get(arr[i]));
			} else
				hm.put(arr[i], 1);
		}
		System.out.println("Appear One");
		for (Map.Entry entry : hm.entrySet()) {

			if (Integer.parseInt(String.valueOf(entry.getValue())) == 1)
				System.out.print(entry.getKey() + " ");
		}
		System.out.println("\nAppear More");
		for (Map.Entry entry : hm.entrySet()) {
			if (Integer.parseInt(String.valueOf(entry.getValue())) > 1)
				System.out.print(entry.getKey() + " ");
		}
	}

}
