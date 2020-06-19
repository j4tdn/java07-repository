package date01;

import java.util.ArrayList;
import java.util.List;

import beans.CommonBill;
import beans.DateBill;
import beans.HourBill;

public class Ex02 {
	public static void main(String[] args) {
		List<CommonBill> bills = getBills();

		bills.forEach(System.out::println);

		System.out.println("=======================");
		System.out.println("Number of HourBills: " + numberOfHourBills(bills));
		System.out.println("Number of DateBills: " + numberOfDateBills(bills));

		CommonBill newBill = new HourBill("HD-007", "20/07/2020", "Long", "R-04", 50, 19);
		addABill(bills, newBill);

		System.out.println("=======================");
		bills.forEach(System.out::println);

		System.out.println("=======================");
		bills.removeIf(bill -> "HD-007".equals(bill.getId()));
		bills.forEach(System.out::println);

		System.out.println("=======================");
		System.out.println("Profit of 09/2017: " + totalOfMonth(bills, 9, 2017));
	}

	private static List<CommonBill> getBills() {
		List<CommonBill> bills = new ArrayList<>();

		CommonBill bill1 = new HourBill("HD-001", "01/09/2017", "Long", "R-01", 50, 9);
		CommonBill bill2 = new HourBill("HD-002", "02/09/2020", "Tuan", "R-02", 70, 48);
		CommonBill bill3 = new HourBill("HD-003", "03/02/2020", "Phu", "R-03", 80, 26);
		CommonBill bill4 = new DateBill("HD-004", "05/09/2017", "Phuoc", "R-08", 50, 5);
		CommonBill bill5 = new DateBill("HD-005", "06/03/2020", "Viet", "R-09", 70, 9);

		bills.add(bill1);
		bills.add(bill2);
		bills.add(bill3);
		bills.add(bill4);
		bills.add(bill5);

		check(bills);
		return bills;
	}

	private static void check(List<CommonBill> bills) {
		List<String> ids = new ArrayList<>();
		for (CommonBill bill : bills) {
			if (bill instanceof HourBill && ((HourBill) bill).getHours() > 30) {
				ids.add(bill.getId());
			}
		}
		for (String id : ids) {
			bills.add(transferHourBillToDateBill((HourBill) getBill(bills, id)));
			bills.remove(getBill(bills, id));
		}
	}

	private static DateBill transferHourBillToDateBill(HourBill bill) {
		DateBill newBill = new DateBill();
		if (bill.getHours() > 30) {
			newBill.setId(bill.getId());
			newBill.setDate(bill.getDate());
			newBill.setCustomerName(bill.getCustomerName());
			newBill.setIdRoom(bill.getIdRoom());
			newBill.setPrice(bill.getPrice());
			newBill.setDays(bill.getHours() / 24);
		}
		return newBill;
	}

	private static CommonBill getBill(List<CommonBill> bills, String id) {
		for (CommonBill bill : bills) {
			if (id.equals(bill.getId())) {
				return bill;
			}
		}
		return null;
	}

	private static int numberOfHourBills(List<CommonBill> bills) {
		int total = 0;

		for (CommonBill bill : bills) {
			if (bill instanceof HourBill) {
				total++;
			}
		}
		return total;
	}

	private static int numberOfDateBills(List<CommonBill> bills) {
		int total = 0;

		for (CommonBill bill : bills) {
			if (bill instanceof DateBill) {
				total++;
			}
		}
		return total;
	}

	private static void addABill(List<CommonBill> bills, CommonBill newBill) {
		if (!bills.contains(newBill)) {
			bills.add(newBill);
		}
		check(bills);
	}

	private static int totalOfMonth(List<CommonBill> bills, int m, int y) {
		int total = 0;

		for (CommonBill bill : bills) {
			if (Integer.parseInt(bill.getDate().substring(4, 5)) == m
					&& Integer.parseInt(bill.getDate().substring(6)) == y) {
				if (bill instanceof HourBill) {
					total += ((HourBill) bill).total();
				} else if (bill instanceof DateBill) {
					total += ((DateBill) bill).total();
				}
			}
		}
		return total;
	}
}
