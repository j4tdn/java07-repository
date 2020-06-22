package bt2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bt02 {
	public static List<Store> store = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("=================MENU=================");
			System.out.println("1.Them 1 CD vao danh sach");
			System.out.println("2.Tinh so luong CD co trong danh sach");
			System.out.println("3.Tong gia thanh cua cac CD");
			System.out.println("4.Sap xep danh sach giam dan theo gia thanh");
			System.out.println("5.Sap xep danh sach tang dan theo Loai CD");
			System.out.println("6.Exit");
			System.out.println("======================================");
			System.out.println("Nhap N De thuc hien thao tac :");
			int n = Integer.parseInt(sc.nextLine());

			switch (n) {
			case 1:
				StoreUtils.imp(store);
				store.forEach(System.out::println);

				break;
			case 2:
				StoreUtils.amountOfCD(store);
				store.forEach(System.out::println);
				break;
			case 3:
				StoreUtils.sumOfCD(store);

				store.forEach(System.out::println);
				break;
			case 4:
				StoreUtils.sortByPrice(store);

				store.forEach(System.out::println);
				break;
			case 5:
				StoreUtils.sortByTypeCD(store);

				store.forEach(System.out::println);
				break;
			case 6:
				System.exit(0);

				break;

			default:
				break;
			}
		} while (true);
	}

}
