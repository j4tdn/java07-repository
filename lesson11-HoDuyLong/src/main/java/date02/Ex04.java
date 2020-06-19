package date02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import beans.Dictionary;

public class Ex04 {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		List<Dictionary> dictionary = new ArrayList<>();
		Dictionary word1 = new Dictionary("Dog", "Con cho", "Danh tu", "abc");
		Dictionary word2 = new Dictionary("Handsome", "Dep trai", "Tinh tu", "xyz");

		dictionary.add(word1);
		dictionary.add(word2);

		addAWord(dictionary);

		Dictionary word = search(dictionary, "Long");
		System.out.println(word == null ? "Cannot find!" : word);
	}

	private static void addAWord(List<Dictionary> dictionary) {
		System.out.println("Input word: ");
		String word = sc.nextLine();

		if (!contain(dictionary, word)) {
			Dictionary newWord = new Dictionary();
			newWord.setWord(word);
			System.out.println("Input definition: ");
			newWord.setDefinition(sc.nextLine());
			System.out.println("Input type: ");
			newWord.setType(sc.nextLine());
			System.out.println("Input note: ");
			newWord.setNote(sc.nextLine());
			dictionary.add(newWord);
			show(dictionary);
		} else {
			System.out.println("Word exists!");
		}
	}

	private static boolean contain(List<Dictionary> dictionary, String word) {
		for (Dictionary aWord : dictionary) {
			if (aWord.getWord().toLowerCase().equals(word.toLowerCase())) {
				return true;
			}
		}
		return false;
	}

	private static void show(List<Dictionary> dictionary) {
		dictionary.forEach(System.out::println);
	}

	private static Dictionary search(List<Dictionary> dictionary, String word) {
		for (Dictionary aWord : dictionary) {
			if (aWord.getWord().toLowerCase().equals(word.toLowerCase())) {
				return aWord;
			}
		}
		return null;
	}
}
