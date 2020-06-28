package date2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import CD.CDStore;

public class Bt02 {
	public static void main(String[] args) {
		List<CDStore> cds = new ArrayList<>();
		creatListCD(cds);
		do {

			Scanner sc = new Scanner(System.in);

			System.out.println("1.Nhập thêm danh sách sinh viên");
			System.out.println("2.Số lượng CD trong store: ");
			System.out.println("3.Tổng giá CD");
			System.out.println("4.Sắp xếp giảm dần theo giá: ");
			System.out.println("5.Sắp xếp theo tựa CD:");
			System.out.println("6.Exit");
			System.out.println("Nhập lựa chọn:");
			int key = Integer.parseInt(sc.nextLine());
			switch (key) {
			case 1:
				creatCD(cds);
				break;
			case 2:
				System.out.println(cds.size());
				break;
			case 3:
				totalPrice(cds);
				break;
			case 4:
				sortByPrice(cds);
				break;
			case 5:
				sortByTypeCD(cds);
				break;
			case 6:
				System.exit(0);
			}

		} while (true);
	}

	private static void creatListCD(List<CDStore> cds) {
		cds.add(new CDStore(001, "nhạc trẻ", "jayki", 5, 100));
		cds.add(new CDStore(002, "nhạc thiếu nhi", "xuan mai", 7, 200));
		cds.add(new CDStore(003, "phim hành động", "hoang", 2, 300));
		cds.add(new CDStore(004, "phim sieu nhan", "jayki", 5, 100));
		cds.add(new CDStore(005, "phim nhật bản", "tokuda", 1, 500));
	}

	private static void creatCD(List<CDStore> cds) {
		Scanner sc = new Scanner(System.in);
		CDStore cd = new CDStore();
		System.out.println("Nhập mã CD: ");
		int id = Integer.parseInt(sc.nextLine());
		cd.setId(id);
		System.out.println("Nhập loại CD");
		String loaiCD = sc.nextLine();
		cd.setLoaiCD(loaiCD);
		System.out.println("Nhập tên ca sĩ");
		String caSi = sc.nextLine();
		cd.setCaSi(caSi);
		System.out.println("Nhập số bài hát: ");
		int soBaiHat = Integer.parseInt(sc.nextLine());
		cd.setSoBaiHat(soBaiHat);
		System.out.println("Nhập giá của đĩa: ");
		int price = Integer.parseInt(sc.nextLine());
		cd.setPrice(price);
		cds.add(cd);
	}

	private static int totalPrice(List<CDStore> cds) {
		int sum = 0;
		for (CDStore cd : cds) {
			sum += cd.getPrice();
		}
		return sum;
	}

	private static void sortByPrice(List<CDStore> cds) {
		List<CDStore> cdss = new ArrayList<>(cds);
		cdss.sort(Comparator.comparing(CDStore::getPrice).reversed());
		cdss.forEach(System.out::println);

	}

	private static void sortByTypeCD(List<CDStore> cds) {
		List<CDStore> cdss = new ArrayList<>(cds);
		cdss.sort(Comparator.comparing(CDStore::getLoaiCD));
		cdss.forEach(System.out::println);

	}

}
