package bt2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bt04 {
	public static void main(String[] args) {
		List<Dictionary> dictionaries = new ArrayList<>();
		do {
			System.out.println("================MENU===============");
			System.out.println("1.Add new Dictionary");
			System.out.println("2.Look up Dictionary");
			System.out.println("3.Print out all words in the Dictionary");
			System.out.println("4.Exit");
			System.out.println("===================================");
			Scanner sc = new Scanner(System.in);
			System.out.print("Nhap :");
			int n = Integer.parseInt(sc.nextLine());
			switch (n) {
			case 1:
				DictionaryUtils.addword(dictionaries);

				break;
			case 2:
				DictionaryUtils.searchDictionary(dictionaries);

				break;
			case 3:
				dictionaries.forEach(System.out::println);

				break;
			case 4:
				System.exit(0);

				break;

			default:
				break;
			}
		} while (true);
	}

}
