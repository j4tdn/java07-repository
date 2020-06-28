package date2;

import java.util.Collections;
import java.util.List;

import card.Cards;

public class CardUtil {

	static void creatCard(List<Cards> cards) {
		int count = -9;
		TypeCard[] typeCard = TypeCard.values();
		NumCard[] numCards = NumCard.values();
		for (int i = 2; i < 15; i++) {

			for (int j = 0; j < 4; j++) {
				Cards card = new Cards();
				if (i <= 10) {
					card.setNumCard(String.valueOf(i));
					card.setTypeCard(String.valueOf(typeCard[j]));
					cards.add(card);
				} else {
					card.setNumCard(String.valueOf(numCards[count]));
					card.setTypeCard(String.valueOf(typeCard[j]));
					cards.add(card);
				}
			}
			count++;
		}
	}

	static void shuffleCard(List<Cards> cards) {
		Collections.shuffle(cards);
		cards.forEach(System.out::println);
	}

	static void disCard(List<Cards> cards, List<Cards> p1, List<Cards> p2, List<Cards> p3, List<Cards> p4) {
		for (int i = 0; i < cards.size() - 4; i += 4) {
			p1.add(cards.get(i));
			p2.add(cards.get(i + 1));
			p3.add(cards.get(i + 2));
			p4.add(cards.get(i + 3));

		}
		System.out.println("Bài của ngưởi chơi 1 :");
		p1.forEach(System.out::print);
		System.out.println();
		System.out.println("Bài của ngưởi chơi 2 :");
		p2.forEach(System.out::print);
		System.out.println();
		System.out.println("Bài của ngưởi chơi 3 :");
		p3.forEach(System.out::print);
		System.out.println();
		System.out.println("Bài của ngưởi chơi 4 :");
		p4.forEach(System.out::print);

	}
}

enum TypeCard {

	CƠ, RÔ, CHUỒN, BÍCH
}

enum NumCard {
	J, Q, K, A
}
