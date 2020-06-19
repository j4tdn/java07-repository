package exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import bean.CD;
import bean.Student;

public class Ex2_2 {

	public static void main(String[] args) {
		List<CD> stores = new ArrayList<>();
		stores = createStore();
		showStore(stores);
		stores = addCD(stores);
		showStore(stores);
		showSize(stores);
		totalPrice(stores);
		sortDESCByPrice(stores);
		showStore(stores);
		sortASCByType(stores);
		showStore(stores);
	}

	private static void sortASCByType(List<CD> stores) {
		System.out.println("======Total Price=====");
		Collections.sort(stores, (o1, o2) -> o1.getCDType().compareTo(o2.getCDType()));
	}

	private static void sortDESCByPrice(List<CD> stores) {
		System.out.println("======Sort DESC By Price=====");
		Collections.sort(stores, (o1, o2) -> o2.getPrice().compareTo(o1.getPrice()));
	}

	private static void totalPrice(List<CD> stores) {
		Double sum = 0.0;
		System.out.println("======Total Price=====");
		for (CD cd : stores) {
			sum += cd.getPrice();
		}
		System.out.println("Total price of cds in the store: " + sum);
	}

	private static void showSize(List<CD> stores) {
		System.out.println("======Show Size=====");
		System.out.println("Number of CD in the store: " + stores.size());
	}

	private static List<CD> addCD(List<CD> stores) {
		System.out.println("======Add Store=====");
		List<CD> tmp = new ArrayList<>();
		CD cd1 = new CD(1, "bolero", "Quang Le", 10, 20000.00);
		CD cd2 = new CD(6, "r&r", "Tran Lap", 20, 100000.00);
		CD cd3 = new CD(7, "rap", "Den ft Linh", 10, 25000.00);
		tmp = Arrays.asList(cd1, cd2, cd3);
		for (CD cd : tmp) {
			if (!stores.contains(cd)) {
				stores = Stream.of(stores, Arrays.asList(cd)).flatMap(x -> x.stream()).collect(Collectors.toList());
			}
		}
		return stores;
	}

	private static void showStore(List<CD> stores) {
		for (CD cd : stores) {
			System.out.println(cd);
		}
	}

	private static List<CD> createStore() {
		System.out.println("======Create Store=====");
		List<CD> stores = new ArrayList<>();
		CD cd1 = new CD(1, "bolero", "Quang Le", 10, 20000.00);
		CD cd2 = new CD(2, "rock", "Tran Lap", 15, 25000.00);
		CD cd3 = new CD(3, "rap", "Den ft Linh", 18, 30000.00);
		CD cd4 = new CD(4, "bolero", "Le Quyen", 11, 50000.00);
		CD cd5 = new CD(5, "rock", "Tuan Hung", 16, 100000.00);
		stores = Arrays.asList(cd1, cd2, cd3, cd4, cd5);
		return stores;
	}

}
