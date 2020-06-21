package date02;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Ex04 {
	private static Scanner ip = new Scanner(System.in);

	public static void main(String[] args) {
		Map<String, Dictionary> mapDict = mock();
		add(mapDict);
		for (Entry<String, Dictionary> e : mapDict.entrySet()) {
			System.out.println(e);
		}
		System.out.println("================");
		find(mapDict);
	}

	public static Map<String, Dictionary> add(Map<String, Dictionary> mapDict) {
		Dictionary dict = new Dictionary("cat", "meo", "noun", "meomeo");
		mapDict.put(dict.getWord(), dict);
		return mapDict;

	}

	public static Map<String, Dictionary> mock() {
		Map<String, Dictionary> mapDict = new LinkedHashMap<String, Dictionary>();
		Dictionary dict1 = new Dictionary("hello", "Xin chào", "verb", "Đồng nghĩa : Hi");
		Dictionary dict2 = new Dictionary("bird", "chim", "noun", ":)");
		Dictionary dict3 = new Dictionary("dog", "chó", "noun", ":)");
		mapDict.put(dict1.getWord(), dict1);
		mapDict.put(dict2.getWord(), dict2);
		mapDict.put(dict3.getWord(), dict3);

		return mapDict;
	}

	public static void find(Map<String, Dictionary> mapDict) {
		int tmp = 0;
		do {
			System.out.println("Nhap tu");
			String word = ip.nextLine();
			for (String key : mapDict.keySet()) {
				if (word.equals(key)) {
					System.out.println(key + "->" + mapDict.get(key));
				}

			}
			System.out.println("\nContinue 1(yes)/0(no):");
			tmp = ip.nextInt();
			System.out.println(word);
		} while (tmp == 1);

	}
}
