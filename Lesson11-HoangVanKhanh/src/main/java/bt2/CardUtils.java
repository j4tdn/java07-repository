package bt2;

import java.util.List;

import common.OrderOfCard;
import common.TypeOfCard;

public class CardUtils {
	public static void createdCard(List<Card<String, String>> card) {
		TypeOfCard[] type = TypeOfCard.values();
		OrderOfCard[] order = OrderOfCard.values();
		int count = -9;

		for (int i = 2; i < 15; i++) {
			for (int j = 0; j < 4; j++) {
				Card<String, String> cards = new Card<>();
				if (i <= 10) {
					cards.setOrderOfCard(String.valueOf(i));
					cards.setTypeOfCard(String.valueOf(type[j]));
					card.add(cards);
				} else {
					cards.setOrderOfCard(String.valueOf(order[count]));
					cards.setTypeOfCard(String.valueOf(type[j]));
					card.add(cards);
				}

			}
			count++;
		}
		card.forEach(System.out::println);

	}

	public static void distributeTheCard(List<Card<String, String>> cards, List<Card<String, String>> player1,
			List<Card<String, String>> player2, List<Card<String, String>> player3,
			List<Card<String, String>> player4) {
		for(int i=0;i<cards.size()-4;i+=4) {
			player1.add(cards.get(i));
			player2.add(cards.get(i+1));
			player3.add(cards.get(i+2));
			player4.add(cards.get(i+3));
			
		}
		System.out.println("Bai cua player 1:");
		player1.forEach(System.out::println);
		System.out.println("Bai cua player 2:");
		player2.forEach(System.out::println);
		System.out.println("Bai cua player 3:");
		player3.forEach(System.out::println);
		System.out.println("Bai cua player 4:");
		player4.forEach(System.out::println);
		

	}

}
