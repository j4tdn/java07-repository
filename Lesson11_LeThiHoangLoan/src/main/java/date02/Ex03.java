package date02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ex03 {
	public static void main(String[] args) {
		List<Card<String, String>> listCard = creat();
		Collections.shuffle(listCard);
		listCard.forEach(System.out::println);
		System.out.println("================");
		deal(listCard);
	}

	public static List<Card<String, String>> creat() {

		String[] arrayThutu = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A" };
		String[] arrayType = { "co", "ro", "chuon", "bich" };

		List<Card<String, String>> listCard = new ArrayList<Card<String, String>>();

		for (int i = 0; i < arrayThutu.length; i++) {
			for (int j = 0; j < arrayType.length; j++) {
				listCard.add(new Card<>(arrayThutu[i], arrayType[j]));
			}

		}
		return listCard;
	}

	public static void deal(List<Card<String, String>> listCard) {
		List<Card<String, String>> people1 = new ArrayList<Card<String, String>>();
		List<Card<String, String>> people2 = new ArrayList<Card<String, String>>();
		List<Card<String, String>> people3 = new ArrayList<Card<String, String>>();
		List<Card<String, String>> people4 = new ArrayList<Card<String, String>>();

		for (int i = 0; i < listCard.size(); i += 4) {
			people1.add(listCard.get(i));
			people2.add(listCard.get(i + 1));
			people3.add(listCard.get(i + 2));
			people4.add(listCard.get(i + 3));

		}

		people1.forEach(System.out::println);
		System.out.println("================");
		people2.forEach(System.out::println);
		System.out.println("================");
		people3.forEach(System.out::println);
		System.out.println("================");
		people4.forEach(System.out::println);

	}

}
