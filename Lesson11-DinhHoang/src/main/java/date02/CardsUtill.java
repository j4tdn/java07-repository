package date02;

import java.util.Collections;
import java.util.List;

import beans.Cards;
import common.OrderOfCards;
import common.TypeOfCard;

public class CardsUtill {
	static void createCards(List<Cards<String, String>> cards) {
		TypeOfCard[] typeOfCards = TypeOfCard.values();
		OrderOfCards[] orderOfCards = OrderOfCards.values();
		int count = -9;
		for (int i = 2; i < 15; i++) {
			for (int j = 0; j < 4; j++) {
				Cards<String, String> card = new Cards<>();
				if (i <= 10) {
					card.setOrderOfCards(String.valueOf(i));
					card.setTypeOfCard(String.valueOf(typeOfCards[j]));
					cards.add(card);
				} else {
					card.setOrderOfCards(String.valueOf(orderOfCards[count]));
					card.setTypeOfCard(String.valueOf(typeOfCards[j]));
					cards.add(card);
				}
			}
			count++;
		}
		cards.forEach(System.out::println);
	}

	static void shuffleCards(List<Cards<String, String>> cards) {
		Collections.shuffle(cards);
		cards.forEach(System.out::println);
	}

	static void dealtCards(List<Cards<String, String>> cards, List<Cards<String, String>> player1,
			List<Cards<String, String>> player2, List<Cards<String, String>> player3,
			List<Cards<String, String>> player4) {
		for (int i = 0; i < cards.size() - 4; i += 4) {
			player1.add(cards.get(i));
			player2.add(cards.get(i + 1));
			player3.add(cards.get(i + 2));
			player4.add(cards.get(i + 3));
		}
	}
}