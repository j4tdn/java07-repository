package date2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

import beans.CD;

public class Ex02 {
	
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		menu();
	}
	
	private static void menu() {
		int choose = 0;
		List<CD> listCD = mock();
		do {
			System.out.println("==============MENU==============");
			System.out.println("1.Add data");
			System.out.println("2.Count CD");
			System.out.println("3.Total of CD");
			System.out.println("4.Sorted desending by price");
			System.out.println("5.Sorted asending by type");
			System.out.println("6.Show");
			System.out.println("Enter...");
			choose = Integer.parseInt(sc.nextLine());
			switch (choose) {
				case 1: {
					addData(listCD);
					break;
				}
				case 2: {
					int number = getCount(listCD);
					System.out.println("Cout: " + number);
					break;
				}
				case 3: {
					float price = getPirce(listCD);
					System.out.println("Price: " + price);
					break;
				}
				case 4: {
					sort(listCD, Comparator.comparing(CD::getPrice).reversed());
					break;
				}
				case 5: {
					sort(listCD, Comparator.comparing(CD::getType));
					break;
				}
				case 6: {
					showData(listCD);
					break;
				}
				default: {
					break;
				}
			}
		} while (choose != 0);
	}

	private static void sort(List<CD> listCD, Comparator<CD> comparator) {
		listCD.sort((c1, c2) -> comparator.compare(c1, c2));
	}

	private static float getPirce(List<CD> listCD) {
		Function<CD, Float> func = cd -> cd.getCount() * cd.getPrice();
		float price = 0;
		for (CD cd : listCD) {
			price += func.apply(cd);
		}
		return price;
	}

	private static int getCount(List<CD> listCD) {
		Function<CD, Integer> func = CD::getCount;
		int count = 0;
		for (CD cd : listCD) {
			count += func.apply(cd);
		}
		return count;
	}

	private static float total(List<CD> listCD) {
		// TODO Auto-generated method stub
		return 0;
	}

	private static void showData(List<CD> listCD) {
		listCD.forEach(System.out::println);
	}

	private static boolean addData(List<CD> listCD) {
		CD cd = create();
		while (listCD.contains(cd)) {
			System.out.println("Id false! Enter again: ");
			cd = create();
		}
		return listCD.add(cd);
	}
	
	private static CD create() {
		System.out.println("Enter id: ");
		String id = sc.nextLine();
		System.out.println("Enter type: ");
		String type = sc.nextLine();
		System.out.println("Enter singer: ");
		String singer = sc.nextLine();
		System.out.println("Enter count: ");
		int count = Integer.parseInt(sc.nextLine());
		System.out.println("Enter price: ");
		float price = Float.parseFloat(sc.nextLine());
		
		CD cd = new CD(id, type, singer, count, price);
		
		return cd;
	}

	private static List<CD> mock() {
		List<CD> cds = new ArrayList<>();
		CD c1 = new CD("cd01", "Rock", "Michael Jackcon", 120, 20);
		CD c2 = new CD("cd02", "Ballad", "Noo Phuoc Thinh", 150, 30);
		CD c3 = new CD("cd03", "Bollero", "Ngoc Son", 180, 15);
		CD c4 = new CD("cd04", "Indie", "Vu", 120, 18);
		CD c5 = new CD("cd05", "Jazz", "My Tam", 120, 20);
		cds.add(c1);
		cds.add(c2);
		cds.add(c3);
		cds.add(c4);
		cds.add(c5);
		return cds;
	}
	
}
