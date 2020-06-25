package date2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import beans.Card;

public class Ex03 {
	
	private static Random rd = new Random();
	
	public static void main(String[] args) {
		List<Card> listCard = createCards();
		play(listCard);
	}

	private static List<Card> createCards() {
		List<Card> listCard = new ArrayList<>();
		while (listCard.size() < 52) {
			Card card = createCard();
			while (listCard.contains(card)) {
				card = createCard();
			}
			listCard.add(card);
		}
		Collections.shuffle(listCard);
		return listCard;
	}
	
	private static void show(List<Card> cards) {
		cards.forEach(System.out::println);
	}
	
	private static Card createCard() {
		List<String> numbers = Arrays.asList("2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A");
		List<String> attributes = Arrays.asList("heart", "diamond", "club", "spade");
		int indexNumber = rd.nextInt(13);
		int indexAtribute = rd.nextInt(4);
		String number = numbers.get(indexNumber);
		String attribute = attributes.get(indexAtribute);
		Card card = new Card(number, attribute);
		return card;
	}
	
	private static void play(List<Card> listCard) {
		List<Card> player1 = new ArrayList<>(); 
		List<Card> player2 = new ArrayList<>(); 
		List<Card> player3 = new ArrayList<>(); 
		List<Card> player4 = new ArrayList<>(); 
		for (int i = 0; i < listCard.size(); i++) {
			if (i % 4 == 0) {
				player1.add(listCard.get(i));
			}
			if (i % 4 == 1) {
				player2.add(listCard.get(i));
			}
			if (i % 4 == 2) {
				player3.add(listCard.get(i));
			}
			if (i % 4 == 3) {
				player4.add(listCard.get(i));
			}
		}
		System.out.println("Player 1: ");
		show(player1);
		System.out.println("Player 2: ");
		show(player2);
		System.out.println("Player 3: ");
		show(player3);
		System.out.println("Player 4: ");
		show(player4);
	}
	
}




