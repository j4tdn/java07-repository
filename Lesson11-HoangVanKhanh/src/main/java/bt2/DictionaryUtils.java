package bt2;

import java.util.List;
import java.util.Scanner;

public class DictionaryUtils {
	public static void addword(List<Dictionary> dictionaries) {
		Dictionary dictionaries2 = new Dictionary();
		Scanner sc = new Scanner(System.in);
		System.out.println("Add to words :");
		String word = sc.nextLine();
		dictionaries2.setWords(word);

		System.out.println("Add to means :");
		String mean = sc.nextLine();
		dictionaries2.setMeans(mean);

		System.out.println("Add to wordType :");
		String wordType = sc.nextLine();
		dictionaries2.setWordType(wordType);

		System.out.println("Add to Note :");
		String note = sc.nextLine();
		dictionaries2.setNote(note);

		dictionaries.add(dictionaries2);

	}

	public static void searchDictionary(List<Dictionary> dictionaries) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the word to search :");
		String word = sc.nextLine();
		for (Dictionary dic : dictionaries) {
			if (word.equals(dic.getWords())) {
				System.out.println(dic);
				break;
			} else
				System.out.println("This word is not in the Dictionary");
		}
	}

}
