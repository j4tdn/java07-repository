package exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import bean.Card;

public class Ex2_3 {
	public static void main(String[] args) {
		List<Card> cards = new ArrayList<>();
		cards = createCard();
		showCard(cards);
		shuffleCard(cards);
		showCard(cards);
		distributeAndCheckCard(cards);
	}

	private static void distributeAndCheckCard(List<Card> cards) {
		System.out.println("\n========Distribute And Check Card=====");
		List<Card> player1 = new ArrayList<>();
		List<Card> player2 = new ArrayList<>();
		List<Card> player3 = new ArrayList<>();
		List<Card> player4 = new ArrayList<>();

		for (int i = 0; i < cards.size(); i++) {
			if (i % 4 == 0) {
				player1.add(cards.get(i));
				continue;
			}
			if (i % 4 == 1) {
				player2.add(cards.get(i));
				continue;
			}
			if (i % 4 == 2) {
				player3.add(cards.get(i));
				continue;
			}
			if (i % 4 == 3) {
				player4.add(cards.get(i));
			}
		}
		System.out.println("-->The card of player1: ");
		showCard(player1);
		System.out.println("\n-->The card of player2: ");
		showCard(player2);
		System.out.println("\n-->The card of player3: ");
		showCard(player3);
		System.out.println("\n-->The card of player4: ");
		showCard(player4);
	}

	private static void shuffleCard(List<Card> cards) {
		System.out.println("\n========Shuffle Card ====");
		Collections.shuffle(cards);
	}

	private static void showCard(List<Card> cards) {
		String[] valueCard = { "J", "Q", "K", "A" };
		for (Card card : cards) {
			if (card.getValue() > 10) {
				System.out.print(valueCard[card.getValue() % 11] + " " + card.getType() + " ");
			} else {
				System.out.print(card);
			}
		}
	}

	private static List<Card> createCard() {
		System.out.println("========Create Card======");
		List<Card> cards = new ArrayList<>();
		String[] typeCard = { "Co", "Ro", "Chuon", "Bich" };
		for (int i = 2; i < 15; i++) {
			for (int j = 0; j < typeCard.length; j++) {
				cards.add(new Card(typeCard[j], i));
			}
		}
		return cards;
	}
}
