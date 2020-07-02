import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Ex01 {
	public static void main(String args[]) {
		int arrayNumbers[] = { 1, 2, 3, 4, 5, 6, 5, 5, 3, 1 };
		System.out.print("Các số chỉ xuất hiện 1 lần : ");
		appearOneTime(arrayNumbers);
		System.out.println();
		System.out.print("Các số xuất hiện trên 1 lần: ");
		Map<Integer, Integer> map = appearManyTimes(arrayNumbers);
		for (Entry<Integer, Integer> e : map.entrySet()) {
			if (e.getValue() > 1) {
				System.out.print(e.getKey() + " ");
			}
		}
	}

	private static void appearOneTime(int arrayNumbers[]) {
		int length = arrayNumbers.length;
		Arrays.sort(arrayNumbers);
		if (arrayNumbers[0] != arrayNumbers[1])
			System.out.println(arrayNumbers[0] + " ");
		for (int i = 1; i < length - 1; i++)
			if (arrayNumbers[i] != arrayNumbers[i + 1] && arrayNumbers[i] != arrayNumbers[i - 1])
				System.out.print(arrayNumbers[i] + " ");
		if (arrayNumbers[length - 2] != arrayNumbers[length - 1])
			System.out.print(arrayNumbers[length - 1] + " ");
	}

	private static Map<Integer, Integer> appearManyTimes(int arrayNumbers[]) {
		int length = arrayNumbers.length;
		Map<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
		for (int i = 0; i < length; i++) {
			try {
				map.put(arrayNumbers[i], map.get(arrayNumbers[i]) + 1);
			} catch (Exception e) {
				map.put(arrayNumbers[i], 1);
			}
		}
		return map;
	}

}