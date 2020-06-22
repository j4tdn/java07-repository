package date02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import beans.StoreCD;

public class StoreCDUtil {
	static void createData(List<StoreCD> storeCDs) {
		StoreCD st1 = new StoreCD(1, "CD-DA", "Sơn Tùng M-TP", 10, 50.0f);
		StoreCD st2 = new StoreCD(2, "DTS-CD", "Lê Bảo Bình", 8, 45.0f);
		StoreCD st3 = new StoreCD(3, "DTS-CD", "Đức Phúc", 5, 35.5f);
		StoreCD st4 = new StoreCD(4, "CD-DA", "Bích Phương", 5, 35.5f);
		StoreCD st5 = new StoreCD(5, "DTS-CD", "ERIK", 6, 40.0f);
		storeCDs.add(st1);
		storeCDs.add(st2);
		storeCDs.add(st3);
		storeCDs.add(st4);
		storeCDs.add(st5);
	}

	static void print(List<StoreCD> storeCDs) {
		storeCDs.forEach(System.out::println);
	}

	static void addCD(List<StoreCD> storeCDs) {
		StoreCD st = new StoreCD();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("THÊM MỚI MỘT CD : ");
			System.out.print("- id        : ");
			int id = Integer.parseInt(sc.nextLine());
			if (checkId(id, storeCDs)) {
				st.setId(id);
				break;
			}
			System.out.println("Trùng id, mời nhập lại!");
		} while (true);
		System.out.print("- species   : ");
		String species = sc.nextLine();
		st.setSpecies(species);
		System.out.print("- singer    : ");
		String singer = sc.nextLine();
		st.setSinger(singer);
		System.out.print("- numOfSongs: ");
		int numOfSongs = Integer.parseInt(sc.nextLine());
		st.setNumOfSongs(numOfSongs);
		System.out.print("- price     : ");
		float price = Float.parseFloat(sc.nextLine());
		st.setPrice(price);
		storeCDs.add(st);
		System.out.println("Đã thêm thành công 1 CD!");
	}

	static boolean checkId(int id, List<StoreCD> storeCDs) {
		for (StoreCD st : storeCDs) {
			if (id == st.getId()) {
				return false;
			}
		}
		return true;
	}

	static float totalMon(List<StoreCD> storeCDs) {
		float totalMon = 0;
		for (StoreCD st : storeCDs) {
			totalMon += st.getPrice();
		}
		return totalMon;
	}

	static void sortByPrice(List<StoreCD> storeCDs) {
		List<StoreCD> sts = new ArrayList<>(storeCDs);
		sts.sort((s1, s2) -> String.valueOf(s1.getPrice()).compareTo(String.valueOf(s2.getPrice())));
		print(sts);
	}

	static void sortBySpecies(List<StoreCD> storeCDs) {
		List<StoreCD> sts = new ArrayList<>(storeCDs);
		sts.sort((s1, s2) -> s1.getSpecies().compareTo(s2.getSpecies()));
		print(sts);
	}
}