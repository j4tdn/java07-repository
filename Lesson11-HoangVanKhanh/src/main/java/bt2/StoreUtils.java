package bt2;

import java.util.List;
import java.util.Scanner;

public class StoreUtils {
	public static Scanner sc = new Scanner(System.in);

	public static void imp(List<Store> store) {
		Store stores = new Store();
		do {
			System.out.println("Import IdCD :");
			int idCD = Integer.parseInt(sc.nextLine());
			if (check(store, idCD)) {
				stores.setIdCD(idCD);
				break;
			}
		} while (true);
		System.out.println("Import TypeCD :");
		String typeCD = sc.nextLine();
		stores.setTypeCD(typeCD);
		System.out.println("Import Singer :");
		String singer = sc.nextLine();
		stores.setSinger(singer);
		System.out.println("Import SongsNumber :");
		int number = Integer.parseInt(sc.nextLine());
		stores.setSongsNumber(number);
		System.out.println("Import Price :");
		double price = Double.parseDouble(sc.nextLine());
		stores.setPrice(price);
		store.add(stores);

	}

	public static boolean check(List<Store> store, int id) {
		for (Store st : store) {
			if (id == st.getIdCD()) {
				return false;
			}
		}
		return true;
	}

	public static void amountOfCD(List<Store> store) {
		System.out.print("So luong dia CD co trong danh sach la :");
		System.out.println(store.size());
	}

	public static void sumOfCD(List<Store> store) {
		double sum = 0;
		for (Store st : store) {
			sum += st.getPrice();
		}
		System.out.println(sum);
	}

	public static void sortByPrice(List<Store> store) {
		store.sort((s1,s2) -> String.valueOf(s2.getPrice()).compareTo(String.valueOf(s1.getPrice())));
		

	}
	public static void sortByTypeCD(List<Store> store) {
		store.sort((s1,s2) -> String.valueOf(s1.getTypeCD()).compareTo(String.valueOf(s2.getTypeCD())));
		

	}

}
