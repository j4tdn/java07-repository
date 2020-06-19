package exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import bean.Dictionary;

public class Ex2_4 {
	public static void main(String[] args) {
		List<Dictionary> dictionaries = new ArrayList<>();
		dictionaries = createDictionary();
		showDictionary(dictionaries);
		dictionaries = addWords(dictionaries);
		showDictionary(dictionaries);
		searchWord(dictionaries, "APPLE");

	}

	private static void searchWord(List<Dictionary> dictionaries, String string) {
		System.out.println("=====Search Word=====");
		for (Dictionary dictionary : dictionaries) {
			if (dictionary.equals(string)) {
				System.out.println(dictionary);
			}
		}
	}

	private static List<Dictionary> addWords(List<Dictionary> dictionaries) {
		System.out.println("=====Add Words=====");
		Dictionary word5 = new Dictionary("Business",
				"  the activity of making money by producing or buying and selling goods, or providing services",
				"noun", "uncountable");
		Dictionary word6 = new Dictionary("Sauce",
				"a thick cooked liquid that is served with food to give it a particular taste", "noun", "uncountable");
		Dictionary word7 = new Dictionary("Extremely", "to a very great degree", "adverd", "");
		dictionaries = Stream.of(dictionaries, Arrays.asList(word5, word6, word7)).flatMap(x -> x.stream())
				.collect(Collectors.toList());
		return dictionaries;
	}

	private static void showDictionary(List<Dictionary> dictionaries) {
		for (Dictionary dictionary : dictionaries) {
			System.out.println(dictionary);
		}
	}

	private static List<Dictionary> createDictionary() {
		System.out.println("===Create Dictionary===");
		List<Dictionary> dictionaries = new ArrayList<>();
		Dictionary word1 = new Dictionary("Apple",
				"a hard round fruit that has red, light green, or yellow skin and is white inside", "noun",
				"countable");
		Dictionary word2 = new Dictionary("Orange",
				" a round fruit that has a thick orange skin and is divided into parts inside", "noun", "countable");
		Dictionary word3 = new Dictionary("Buy", "to get something by paying money for it", "verb", "bought");
		Dictionary word4 = new Dictionary("Careful",
				"trying very hard to avoid doing anything wrong or to avoid damaging or losing something", "adj",
				"carefully");
		dictionaries = Arrays.asList(word1, word2, word3, word4);
		return dictionaries;
	}
}
