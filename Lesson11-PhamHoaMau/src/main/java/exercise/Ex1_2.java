package exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import bean.Bill;
import bean.DatesBill;
import bean.HoursBill;

public class Ex1_2 {
	public static void main(String[] args) {
		List<Bill> bills = new ArrayList<>();
		bills = createBill(bills);
		show(bills);
		numberOfBillTypes(bills);
		bills = addBill(bills);
		show(bills);
		bills = deleteBill(bills, 4);
		show(bills);
		avgRoomRental(bills, "12/2012");

	}

	private static void avgRoomRental(List<Bill> bills, String string) {
		System.out.println("========Pay The Bill=========");
		int count = 0;
		double sum = 0;
		for (Bill bill : bills) {
			if (string.equals(bill.getDate().substring(3))) {
				count += 1;
				if (bill instanceof HoursBill) {
					if (((HoursBill) bill).getHours() <= 24) {
						sum += ((HoursBill) bill).getHours() * ((HoursBill) bill).getUnitPrice();
					} else {
						sum += 24 * ((HoursBill) bill).getUnitPrice();
					}
				} else {
					if (((DatesBill) bill).getDates() <= 7) {
						sum += ((DatesBill) bill).getDates() * ((DatesBill) bill).getUnitPrice();
					} else {
						sum += 7 * ((DatesBill) bill).getUnitPrice()
								+ (((DatesBill) bill).getDates() - 7) * ((DatesBill) bill).getUnitPrice() * 0.8;
					}
				}
			}
		}
		System.out.println("Average Room Rental: " + sum / count);
	}

	private static List<Bill> deleteBill(List<Bill> bills, Integer id) {
		System.out.println("========Delete Bill=========");
		for (int i = 0; i < bills.size(); i++) {
			if (id.equals(bills.get(i).getId())) {
				bills.remove(i);
			}
		}
		return bills;
	}

	private static List<Bill> addBill(List<Bill> bills) {
		System.out.println("=======Add Bills==========");
		int hours = 48;
		Bill newBill;
		if (hours <= 30) {
			newBill = new HoursBill(6, "17/12/2012", "Nguyen C", 102, 200, hours);
		} else {
			int dates = hours / 24;
			newBill = new DatesBill(6, "17/12/2012", "Nguyen C", 102, 200, dates);
		}
		bills = Stream.of(bills, Arrays.asList(newBill)).flatMap(x -> x.stream()).collect(Collectors.toList());
		return bills;
	}

	private static void numberOfBillTypes(List<Bill> bills) {
		System.out.println("=======Bill Types==========");
		int countHoursBill = 0, countDatesBill = 0;
		for (Bill bill : bills) {
			if (bill instanceof HoursBill) {
				countHoursBill += 1;
			} else {
				countDatesBill += 1;
			}
		}
		System.out.println("HoursBill: " + countHoursBill + "\nDatesBill: " + countDatesBill);
	}

	private static void show(List<Bill> bills) {
		for (Bill bill : bills) {
			System.out.println(bill);
		}
	}

	private static List<Bill> createBill(List<Bill> bills) {
		System.out.println("======Create Bills===========");
		HoursBill bill1 = new HoursBill(1, "12/10/2012", "Nguyen A", 101, 100, 25);
		HoursBill bill2 = new HoursBill(2, "13/12/2012", "Nguyen C", 201, 100, 15);
		DatesBill bill3 = new DatesBill(3, "14/12/2012", "Nguyen A", 201, 100, 5);
		DatesBill bill4 = new DatesBill(4, "15/12/2012", "Nguyen B", 101, 100, 8);
		DatesBill bill5 = new DatesBill(5, "16/1/2013", "Nguyen D", 201, 100, 15);
		bills = Arrays.asList(bill1, bill2, bill3, bill4, bill5);
		return bills;
	}
}
