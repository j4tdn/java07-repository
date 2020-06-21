package bt1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class BillUtils {
	private static Scanner ip = new Scanner(System.in);
	private static final double DISCOUNT = 0.8d;

	private BillUtils() {

	}

	public static <T extends Bill> List<T> getBills(List<T> bills) {
		HourlyBill b1 = new HourlyBill("HD-021", "30/09/2017", "Van Nam", "108", 18);
		DailyBill b2 = new DailyBill("HD-084", "15/09/2017", "Le Na", "307", 6);
		DailyBill b3 = new DailyBill("HD-013", "20/08/2017", "Ngoc Thanh", "703", 10);
		HourlyBill b4 = new HourlyBill("HD-075", "03/10/2017", "Phan Ka", "602", 5);
		HourlyBill b5 = new HourlyBill("HD-018", "07/03/2017", "Hoang Teo", "109", 20);
		HourlyBill b6 = new HourlyBill("HD-007", "09/09/2017", "Nguyen An", "201", 15);
		DailyBill b7 = new DailyBill("HD-039", "18/09/2017", "Tran My", "303", 16);
		bills.add((T) b1);
		bills.add((T) b2);
		bills.add((T) b3);
		bills.add((T) b4);
		bills.add((T) b5);
		bills.add((T) b6);
		bills.add((T) b7);

		return bills;
	}

	public static <T extends Bill> int[] countingByType(List<T> bills) {
		int[] result = new int[2];
		for (T t : bills) {
			if (t instanceof HourlyBill) {
				result[0]++;
			} else {
				result[1]++;
			}
		}
		return result;
	}

	public static <T extends Bill> T total(T bill) {
		if (bill instanceof HourlyBill) {
			bill.setTotal(((HourlyBill) bill).getHours() * bill.getUnitPrice());
		} else {
			double days = ((DailyBill) bill).getDays();
			if (days > 7) {
				double lastDays = days - 7;
				bill.setTotal(7 * bill.getUnitPrice() + lastDays * DISCOUNT * bill.getUnitPrice());
			} else {
				bill.setTotal(days * bill.getUnitPrice());
			}
		}
		return bill;
	}

	public static <T extends Bill> void show(List<T> bills) {
		bills.forEach(System.out::println);
	}

	public static <T extends Bill> List<T> setTotals(List<T> bills) {
		bills.forEach(b -> total(b));
		return bills;
	}

	public static <T extends Bill> void add(List<T> bills) {
		System.out.print("Nhap ma hoa don: ");
		String id = ip.nextLine();

		System.out.print("Nhap ngay hoa don: ");
		String dateString = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date c = null;
		while (true) {
			try {
				dateString = ip.nextLine();
				c = sdf.parse(dateString);
				break;
			} catch (ParseException e) {
				System.out.print("Sai dinh dang! Nhap lai: ");
			}
		}

		System.out.print("Nhap ten khach hang: ");
		String name = ip.nextLine();

		System.out.print("Nhap ma phong: ");
		String room = ip.nextLine();

		System.out.print("Nhap so gio thue: ");
		double hours = ip.nextDouble();

		if (hours < 30) {
			HourlyBill hourlyBill = new HourlyBill(id, dateString, name, room, hours);
			T t = (T) hourlyBill;
			bills.add(t);
		} else {
			double days = Math.round(hours / 24);
			DailyBill dailyBill = new DailyBill(id, dateString, name, room, days);
			T t = (T) total(dailyBill);
			bills.add(t);
		}
	}

	public static <T extends Bill> List<T> delete(List<T> bills, String id) {
		for (T t : bills) {
			if (t.getId().equals(id)) {
				bills.remove(t);
				break;
			}
		}
		return bills;
	}

	public static <T extends Bill> double averageAmountOfMonth(List<T> bills, int month, int year) {
		double total = 0;
		int count = 0;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date c = null;

		for (T t : bills) {
			try {
				c = sdf.parse(t.getDate());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			Calendar date = Calendar.getInstance();
			date.setTime(c);
			if (date.get(Calendar.MONTH) == month && date.get(Calendar.YEAR) == year) {
				total += t.getTotal();
				count++;
			}
		}
		return (double) (total / count);
	}
}
