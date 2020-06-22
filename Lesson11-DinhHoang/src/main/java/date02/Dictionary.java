package date02;

import java.util.List;
import java.util.Scanner;

import beans.English;

public class Dictionary {
	static void addWord(List<English> englishs) {
		English english = new English();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.print("> Nhập từ cần thêm vào TĐ: ");
		String word = sc.nextLine();
		english.setWord(word);
		System.out.print("- Nhập nghĩa của từ      : ");
		String means = sc.nextLine();
		english.setMeans(means);
		System.out.print("- Nhập loại từ           : ");
		String wordType = sc.nextLine();
		english.setWordType(wordType);
		System.out.print("- Nhập ghi chú           : ");
		String note = sc.nextLine();
		english.setNote(note);
		englishs.add(english);
	}

	static void searchWord(List<English> englishs) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.print("> Nhập từ cần tìm kiếm: ");
		String word = sc.nextLine();
		int tmp = 0;
		for (English e : englishs) {
			if (word.equals(e.getWord())) {
				System.out.println(e);
				tmp++;
				break;
			}
		}
		if (tmp == 0) {
			System.out.println("Từ này không có trong TĐ!");
		}
	}

	static void print(List<English> englishs) {
		englishs.forEach(System.out::println);
	}
}