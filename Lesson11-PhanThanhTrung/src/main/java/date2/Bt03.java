package date2;

import java.util.ArrayList;
import java.util.List;

import card.Cards;

public class Bt03 {
	public static void main(String[] args) {
		List<Cards> cards = new ArrayList<>();
		CardUtil.creatCard(cards);
		CardUtil.shuffleCard(cards);
		List<Cards> player1 = new ArrayList<>();
		List<Cards> player2 = new ArrayList<>();
		List<Cards> player3 = new ArrayList<>();
		List<Cards> player4 = new ArrayList<>();
		CardUtil.disCard(cards, player1, player2, player3, player4);
		;

	}

}
