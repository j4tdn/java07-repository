package date1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import beans.Bill;
import beans.DayBill;
import beans.HoursBill;

public class Bt02 {
	public static void main(String[] args) {
		List<DayBill> dayBill = new ArrayList<>();
		List<HoursBill> hourBill = new ArrayList<>();

		Scanner sc = new Scanner(System.in);
		System.out.println("1:Hoa don theo ngay, 2:Hoa dơn theo gio");
		System.out.print("Nhap lua chon: ");
		int key = Integer.parseInt(sc.nextLine());

		switch (key) {
		case 1:
			String days = "ngay";
			dayBill.add((DayBill) input(new DayBill(), days));
			output(dayBill);
			break;
		case 2:
			String hours = "gio";
			hourBill.add((HoursBill) input(new HoursBill(), hours));
			output(hourBill);
			break;
		default:
			break;
		}
		System.out.println("Tong so luong hoa don ngay" + dayBill.size());
		System.out.println("Tong hoa don theo gio: " + hourBill.size());
		System.out.println("them hoa don: ngay(1), gio(2)");
		int key2 = Integer.parseInt(sc.nextLine());

		switch (key2) {
		case 1:
			System.out.println("Them hoa don theo ngay: ");
			String days = "ngay";
			dayBill.add((DayBill) input(new DayBill(), days));
			break;
		case 2:
			String hours = "gio";
			hourBill.add((HoursBill) input(new HoursBill(), hours));
			break;
		default:
			break;
		}
		output(hourBill);
		output(dayBill);
		System.out.println("---------------------");
		remove(dayBill, hourBill);
		System.out.println("danh sach sau khi xóa");
		output(hourBill);
		output(dayBill);
		System.out.println("nhap tháng cần tính tổng:");
		String month = sc.nextLine();
		System.out.println(sumPrice(dayBill, hourBill, month));
	}

	private static Bill input(Bill bills, String key) {

		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap ma hoa don: ");
		String id = sc.nextLine();
		bills.setId(id);
		System.out.print("Nhap ngay hoa don: ");
		String day = sc.nextLine();
		bills.setDate(day);
		System.out.print("Nhap ten khach hang: ");
		String name = sc.nextLine();
		bills.setFullName(name);
		System.out.print("Nhap ma phong: ");
		String idRoom = sc.nextLine();
		bills.setIdRoom(idRoom);
		System.out.print("Nhap don gia: ");
		int unitPrice = Integer.parseInt(sc.nextLine());
		bills.setUnitPrice(unitPrice);
		if (key.equals("ngay")) {
			System.out.print("Nhap so ngay: ");
			int numDay = Integer.parseInt(sc.nextLine());
			((DayBill) bills).setNumDay(numDay);
			bills.pay();
		} else {
			System.out.print("Nhap so gio:");
			int numHours = Integer.parseInt(sc.nextLine());

			((HoursBill) bills).setHours(numHours);
			bills.pay();
		}
		return bills;
	}

	private static void output(List<? extends Bill> bills) {

		bills.forEach(System.out::println);
	}

	private static void remove(List<DayBill> dayBill, List<HoursBill> hourBill) {
		System.out.println("Nhập mã hóa đơn cần xóa: ");
		Scanner sc = new Scanner(System.in);
		String removeID = sc.nextLine();
		dayBill.removeIf(b -> removeID.equals(b.getId()));
		hourBill.removeIf(b -> removeID.equals(b.getId()));
	}

	private static float sumPrice(List<DayBill> dayBill, List<HoursBill> hoursbill, String month) {
		float totalPrice = 0.0f;
		for (Bill bill : dayBill) {
			String tmp = bill.getDate().substring(3);
			if (month.equals(tmp)) {
				totalPrice = totalPrice + bill.getCost();
			}
		}
		for (Bill bill : hoursbill) {
			String tmp = bill.getDate().substring(3);
			if (month.equals(tmp)) {
				totalPrice = totalPrice + bill.getCost();
			}
		}
		return totalPrice;
	}
}
