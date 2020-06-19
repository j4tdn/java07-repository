package date02;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import beans.CD;

public class Ex02 {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("===========MENU=============");
		System.out.println("1. Add a CD into list");
		System.out.println("2. Number of CDs");
		System.out.println("3. total price of CD list");
		System.out.println("4. Sort in descending of price");
		System.out.println("5. Sort in ascending of type");
		System.out.println("0. Quit");

		int n = 0;

		List<CD> cds = new ArrayList<>();
		CD cd1 = new CD(1, "Jav", "Phuoc", 15, 10.2f);
		CD cd2 = new CD(2, "Kpop", "Huy", 10, 9.8f);
		CD cd3 = new CD(3, "Vpop", "Phu", 7, 20.5f);

		cds.add(cd1);
		cds.add(cd2);
		cds.add(cd3);

		do {
			System.out.print("=> Your choice: ");
			n = Integer.parseInt(sc.nextLine());

			switch (n) {
			case 1:
				addCD(cds);
				break;
			case 2:
				System.out.println("Number of CDs in list: " + numberOfCDs(cds));
				break;
			case 3:
				System.out.println("Total price of CDs: " + totalPrice(cds));
				break;
			case 4:
				sortByPrice(cds);
				break;
			case 5:
				sortByType(cds);
				break;
			case 0:

				break;
			default:
				System.out.println("Invalid input!");
			}
		} while (n != 0);
	}

	private static void addCD(List<CD> cds) {
		System.out.print("Input id: ");
		int id = Integer.parseInt(sc.nextLine());

		if (checkId(cds, id)) {
			CD newCD = new CD();
			newCD.setId(id);
			System.out.print("Input type: ");
			newCD.setType(sc.nextLine());
			System.out.print("Input singer: ");
			newCD.setSinger(sc.nextLine());
			System.out.print("Input number of songs: ");
			newCD.setNumberOfSongs(Integer.parseInt(sc.nextLine()));
			System.out.print("Input price: ");
			newCD.setPrice(Float.parseFloat(sc.nextLine()));
			cds.add(newCD);
			show(cds);
		} else {
			System.out.println("Id exists!");
		}
	}

	private static boolean checkId(List<CD> cds, int id) {
		for (CD cd : cds) {
			if (cd.getId() == id) {
				return false;
			}
		}
		return true;
	}

	private static void show(List<CD> cds) {
		cds.forEach(System.out::println);
	}

	private static int numberOfCDs(List<CD> cds) {
		return cds.size();
	}

	private static float totalPrice(List<CD> cds) {
		float total = 0.0f;

		for (CD cd : cds) {
			total += cd.getPrice();
		}
		return total;
	}

	private static void sortByPrice(List<CD> cds) {
		cds.sort(Comparator.comparing(CD::getPrice, Comparator.reverseOrder()));
		show(cds);
	}

	private static void sortByType(List<CD> cds) {
		cds.sort(Comparator.comparing(CD::getType));
		show(cds);
	}
}
