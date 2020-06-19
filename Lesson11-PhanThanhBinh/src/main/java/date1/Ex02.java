package date1;

import java.util.ArrayList;
import java.util.List;

import beans.Bill;
import beans.BillOfDay;
import beans.BillOfHours;

public class Ex02 {

	public static void main(String[] args) {
		List<Bill> bills = mockData();
		Bill newBill = new BillOfHours("HD-008", "20/06/2020", "LeA", "101", 30f, 40);
		addData(bills, newBill);
		bills = delBill(bills, "HD-007");
		show(bills);
		float total = getToTalOfTime(bills, "09/2017");
		int countOfHours = countBillOfHours(bills);
		int countOfDay = countBillOfDay(bills);
		System.out.println("Count bill of hours: " + countOfHours);
		System.out.println("Count bill of day: " + countOfDay);
		System.out.println("Total of 09/2017: " + total);
	}

	private static List<Bill> mockData() {
		List<Bill> bills = new ArrayList<>();
		Bill b1 = new BillOfDay("HD-001", "19/06/2020", "LeA", "101", 240f, 3);
		Bill b2 = new BillOfDay("HD-002", "19/09/2017", "LeB", "102", 300f, 8);
		Bill b3 = new BillOfHours("HD-003", "25/06/2020", "LeC", "101", 25f, 18);
		Bill b4 = new BillOfHours("HD-004", "28/09/2017", "LeD", "101", 15f, 27);
		Bill b5 = new BillOfDay("HD-005", "21/08/2020", "LeE", "103", 360f, 3);
		Bill b6 = new BillOfHours("HD-007", "19/06/2020", "LeF", "103", 20f, 20);
		bills.add(b1);
		bills.add(b2);
		bills.add(b3);
		bills.add(b4);
		bills.add(b5);
		bills.add(b6);

		return bills;
	}

	private static boolean addData(List<Bill> bills, Bill bill) {
		return bills.add(bill);
	}

	private static void show(List<Bill> bills) {
		bills.forEach(System.out::println);
	}

	private static int countBillOfHours(List<Bill> bills) {
		int count = 0;

		for (Bill bill : bills) {
			if (bill instanceof BillOfHours) {
				count++;
			}
		}
			
		return count;
	}
	
	private static int countBillOfDay(List<Bill> bills) {
		int count = 0;

		for (Bill bill : bills) {
			if (bill instanceof BillOfDay) {
				count++;
			}
		}
			
		return count;
	}
	
	private static float getTotalOfHours(Bill bill) {
		float total = 0;

		if (bill instanceof BillOfHours) {
			BillOfHours billOfHours = (BillOfHours) bill;
			if (billOfHours.getHours() <= 24) {
				total = billOfHours.getHours() * bill.getPrice();
			} else if (billOfHours.getHours() > 24 && billOfHours.getHours() < 30) {
				total = 24 * bill.getPrice();
			} else {
				int day = billOfHours.getHours() / 24;
				float newPrice = billOfHours.getPrice() * 24;
				if (day <= 7) {
					total = day * newPrice;
				} else {
					total = 7 * newPrice + newPrice * (day - 7) * 0.8f;
				}
			}
		}

		return total;
	}

	private static float getTotalOfDay(Bill bill) {
		float total = 0;
		if (bill instanceof BillOfDay) {
			BillOfDay billOfDays = (BillOfDay) bill;
			if (billOfDays.getDay() <= 7) {
				total = billOfDays.getDay() * billOfDays.getPrice();
			} else {
				total = 7 * billOfDays.getPrice()+ billOfDays.getPrice() * (billOfDays.getDay() - 7) * 0.8f;
			}

		}
		return total;
	}

	private static List<Bill> delBill(List<Bill> bills, String id) {
		for (int i = 0; i < bills.size(); i++) {
			if (id.equals(bills.get(i).getIdBill())) {
				bills.remove(bills.get(i));
			}
		}
		return bills;
	}
	
	private static float getToTalOfTime(List<Bill> bills, String time) {
		float total = 0;
		for (Bill bill : bills) {
			String[] times = bill.getDate().split("/");
			String monthYear = times[1] + "/" + times[2];
			if (time.equals(monthYear)) {
				if (bill instanceof BillOfHours) {
					total += getTotalOfHours(bill);
				}
				if (bill instanceof BillOfDay) {
					total += getTotalOfDay(bill);
				}
			}
		}
		return total;
	}
}
