package bt.b2;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class CDUtils {
	private static Scanner ip = new Scanner(System.in);

	private CDUtils() {

	}

	public static void menu(List<CD> cds) {
		int n;
		cds = getCD(cds);
		do {
			System.out.println("1.Them 1 CD vao danh sach");
			System.out.println("2.So luong CD co trong danh sach");
			System.out.println("3.Tong gia thanh cua cac CD");
			System.out.println("4.Sap xep danh sach giam dan theo gia thanh");
			System.out.println("5.Sap xep danh sach tang dan theo tua CD");
			System.out.println("6.Huy");
			n = Integer.parseInt(ip.nextLine());
			switch (n) {
			case 1:
				addCD(cds);
				show(cds);
				break;
			case 2:
				System.out.println("So luong CD co trong danh sach: " + countCDNumbers(cds));
				break;
			case 3:
				System.out.println("Tong gia thanh cua cac CD: " + totalPrices(cds));
				break;
			case 4:
				cds = sort(cds, Comparator.comparing(CD::getPrice).reversed());
				show(cds);
				break;
			case 5:
				cds = sort(cds, Comparator.comparing(CD::getType));
				show(cds);
			}
		} while (n != 6);
	}

	private static List<CD> getCD(List<CD> cds) {
		CD cd1 = new CD(13, "Nhac tre", "Son Tung M-TP", 10, 200d);
		CD cd2 = new CD(26, "Nhac tre em", "Xuan Mai", 15, 120d);
		CD cd3 = new CD(10, "Nhac xua", "Bang Kieu", 22, 180d);
		CD cd4 = new CD(24, "Nhac tre", "Bao Thy", 18, 220d);
		CD cd5 = new CD(31, "Nhac tre", "My Tam", 15, 200d);
		cds.add(cd1);
		cds.add(cd2);
		cds.add(cd3);
		cds.add(cd4);
		cds.add(cd5);
		return cds;
	}

	private static void show(List<CD> cds) {
		cds.forEach(System.out::println);
	}

	private static void addCD(List<CD> cds) {
		System.out.print("Nhap ma CD: ");
		int id = Integer.parseInt(ip.nextLine());
		while (!isValidId(cds, id)) {
			System.out.print("Trung ma CD! Nhap lai: ");
			id = Integer.parseInt(ip.nextLine());
		}
		System.out.print("Nhap loai CD: ");
		String type = ip.nextLine();
		System.out.print("Nhap ten ca si: ");
		String singer = ip.nextLine();
		System.out.print("Nhap so bai hat: ");
		int songs = Integer.parseInt(ip.nextLine());
		System.out.print("Nhap gia thanh: ");
		double price = Integer.parseInt(ip.nextLine());

		cds.add(new CD(id, type, singer, songs, price));
	}

	private static boolean isValidId(List<CD> cds, int id) {
		for (CD cd : cds) {
			if (cd.getId() == id) {
				return false;
			}
		}
		return true;
	}

	private static int countCDNumbers(List<CD> cds) {
		return cds.size();
	}

	private static double totalPrices(List<CD> cds) {
		double total = 0;
		for (CD cd : cds) {
			total += cd.getPrice();
		}
		return total;
	}

	private static List<CD> sort(List<CD> cds, Comparator<CD> com) {
		cds.sort(com);
		return cds;
	}
}
