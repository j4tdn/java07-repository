package date01;

import java.util.List;
import java.util.Scanner;

import service.BillService;
import service.BillServiceImpl;

public class Ex02 {
	private static Scanner ip = new Scanner(System.in);
	private static BillService service = new BillServiceImpl();

	public static void main(String[] args) {
		List<Bill> list = service.getAll();
		show(list);
		System.out.println("=======================");
		totalByType(list);
		
		System.out.println("=======================");
		addBill(list);
		show(list);
		
		System.out.println("=======================");
		remove(list);
		show(list);
		
	}

	public static void show(List<Bill> list) {
		float average = 0;
		int count = 0;
		for (int i = 0; i < list.size(); i++) {
			System.out.println("Ma khach hang : " + list.get(i).getId());
			System.out.println("Ngay hoa don : " + list.get(i).getDate());
			System.out.println("Ho ten : " + list.get(i).getFullName());
			System.out.println("Ma phong : " + list.get(i).getRoomId());
			System.out.println("Gia phong : " + list.get(i).getPrice() + " K");

			if (list.get(i) instanceof BillByHour) {

				BillByHour bill = (BillByHour) list.get(i);

				if (bill.getHour() < 24) {
					System.out.println(bill.getPrice() * (bill.getHour()));
					if ("09/2017".equals(bill.getDate().substring(3))) {
						average += bill.getPrice() * (bill.getHour());
						count++;
					}
				}
				if (bill.getHour() > 24 && bill.getHour() < 30) {
					System.out.println(bill.getPrice() * 24);
					if ("09/2017".equals(bill.getDate().substring(3))) {
						average += bill.getPrice() * 24;
						count++;
					}
				} else {
					// BillByDay b = (BillByDay) bill.setDay();;
				}
			}
			if (list.get(i) instanceof BillByDay) {

				BillByDay bill = (BillByDay) list.get(i);
				if (bill.getDay() > 7) {
					System.out.println(7 * bill.getPrice() + (bill.getDay() - 7) * bill.getPrice() * 0.8);
					if ("09/2017".equals(bill.getDate().substring(3))) {
						average += 7 * bill.getPrice() + (bill.getDay() - 7) * bill.getPrice() * 0.8;
						count++;
					}
				} else {
					System.out.println(bill.getPrice() * (bill.getDay()));
					if ("09/2017".equals(bill.getDate().substring(3))) {
						average += bill.getPrice() * (bill.getDay());
						count++;
					}
				}
			}

			System.out.println("===============");
		}
		System.out.println("Tiền trung bình hóa đơn thuê phòng trong tháng 9/2017 : " + average / count);
	}

	public static void totalByType(List<Bill> list) {
		int roomByHour = 0;
		int roomByDay = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) instanceof BillByDay) {
				roomByDay++;

			}

			if (list.get(i) instanceof BillByHour) {
				roomByHour++;
			}
		}
		System.out.println("So phong thue theo ngay : " + roomByDay);
		System.out.println("So phong thue theo gio : " + roomByHour);
	}

	public static List<Bill> addBill(List<Bill> list) {
		System.out.println("Thue theo ngay hay theo gio ?(Ngay-1/Gio-2) ");
		int key = ip.nextInt();
		switch (key) {
		case 1:
			Bill billByDate = new BillByDay("HD-008", "12/01/2017", "Le Kinh", "P109", 500, 3);
			list.add(billByDate);
			break;
		case 2:
			Bill billByHour = new BillByHour("HD-009", "21/11/2017", "Le Kinh", "P105", 50, 8);
			list.add(billByHour);
			break;
		}
		return list;

	}

	public static List<Bill> remove(List<Bill> list) {
		for (int i = 0; i < list.size(); i++) {
			list.removeIf(a -> "HD-007".equals(a.getId()));
		}
		return list;
	}

}
