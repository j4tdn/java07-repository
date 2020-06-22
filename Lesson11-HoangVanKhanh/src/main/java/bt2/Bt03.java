package bt2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Bt03 {
	public static List<Card<String, String>> card = new ArrayList<>();
	public static void main(String[] args) {
		List<Card<String, String>> player1=new ArrayList<>();
		List<Card<String, String>> player2=new ArrayList<>();
		List<Card<String, String>> player3=new ArrayList<>();
		List<Card<String, String>> player4=new ArrayList<>();
		
		System.out.println("Khoi tao bo bai :");
		CardUtils.createdCard(card);
		System.out.println("Xao bai");
		Collections.shuffle(card);
		card.forEach(System.out::println);
		System.out.println("Chia bai cho 4 Player");
		CardUtils.distributeTheCard(card,player1,player2,player3,player4);
		
	}


}
