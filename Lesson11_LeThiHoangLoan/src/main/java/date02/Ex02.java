package date02;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Ex02 {
	public static Scanner ip = new Scanner(System.in);

	public static void main(String[] args) {
		menu();
	}

	public static void menu() {
		int tf;
		int key = 0;
		List<DishCD> dishCD = creat();
		do {
			System.out.println("1.Them 1 CD\r\n");
			System.out.println("2.Tong so CD\r\n");
			System.out.println("3.Tong gia tien\r\n");
			System.out.println("4.Sắp xếp Sap xep giam theo gia\r\n");
			System.out.println("5.Sap xep tang theo tua CD.\r\n");
			System.out.println("\nNhap ");

			key = ip.nextInt();

			switch (key) {
			case 1:

				DishCD dish = new DishCD(1, "tre", "Bui Anh Tuan", 11, 32);
				if (dish.equals(dishCD) == true) {
					dishCD = add(dishCD, dish);
				} else {
					System.out.println("da co");
				}
				break;
			case 2:
				System.out.println(totalDish(dishCD));
				break;
			case 3:
				System.out.println(totalMoney(dishCD));
				break;
			case 4:
				DescByMoney(dishCD);
				show(dishCD);
				break;
			case 5:
				AscByType(dishCD);
				show(dishCD);
				break;

			}
			System.out.println("\nContinue 1(yes)/0(no):");
			tf = ip.nextInt();
		} while (tf == 1);
	}

	public static List<DishCD> creat() {
		List<DishCD> dishCDs = new ArrayList<>();

		dishCDs.add(new DishCD(1, "tre", "Bui Anh Tuan", 11, 32));
		dishCDs.add(new DishCD(2, "tru tinh", "Cam Ly", 12, 43));
		dishCDs.add(new DishCD(3, "vang", "Dan Truong", 10, 44));
		dishCDs.add(new DishCD(4, "tre", "My Tam", 15, 55));
		return dishCDs;

	}

	public static List<DishCD> AscByType(List<DishCD> dishCD) {
		dishCD.sort(Comparator.comparing(DishCD::getType));

		return dishCD;

	}

	public static List<DishCD> show(List<DishCD> dishCD) {
		dishCD.forEach(System.out::println);
		return dishCD;
	}

	public static List<DishCD> DescByMoney(List<DishCD> dishCD) {
		dishCD.sort(Comparator.comparing(DishCD::getPrice).reversed());
		return dishCD;
	}

	public static Float totalMoney(List<DishCD> dishCD) {
		Float totalPrice = (float) 0;

		for (DishCD d : dishCD) {
			totalPrice += d.getPrice();
		}
		return totalPrice;

	}

	public static int totalDish(List<DishCD> dishCD) {
		return dishCD.size();

	}

	public static List<DishCD> add(List<DishCD> dishCD, DishCD dish) {
		dishCD.add(dish);
		return dishCD;
	}
}
