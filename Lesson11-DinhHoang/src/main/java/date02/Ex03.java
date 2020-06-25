package date02;

import java.util.ArrayList;
import java.util.List;

import beans.Cards;

public class Ex03 {
	public static void main(String[] args) {
		List<Cards<String, String>> cards = new ArrayList<>();
		System.out.println("1. TẠO BỘ BÀI 52 LÁ KHÔNG TRÙNG NHAU:");
		CardsUtill.createCards(cards);
		System.out.println("=====================================");
		System.out.println("2. XÁO BÀI:");
		CardsUtill.shuffleCards(cards);
		System.out.println("=====================================");
		System.out.println("3.CHIA BÀI CHO 4 NGƯỜI CHƠI:");
		List<Cards<String, String>> player1 = new ArrayList<>();
		List<Cards<String, String>> player2 = new ArrayList<>();
		List<Cards<String, String>> player3 = new ArrayList<>();
		List<Cards<String, String>> player4 = new ArrayList<>();
		CardsUtill.dealtCards(cards, player1, player2, player3, player4);
		System.out.println("> Bài của người chơi thứ nhất:");
		player1.forEach(System.out::println);
		System.out.println("> Bài của người chơi thứ hai:");
		player2.forEach(System.out::println);
		System.out.println("> Bài của người chơi thứ ba:");
		player3.forEach(System.out::println);
		System.out.println("> Bài của người chơi thứ tư:");
		player4.forEach(System.out::println);
	}
}