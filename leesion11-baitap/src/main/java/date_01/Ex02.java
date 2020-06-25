package date_01;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex02 {
	public static void main(String[] args) {
		List<Ex02_hotel> custumerHotel = new ArrayList<>();
		custumerHotel = createCustumer();
		show(custumerHotel);
		totalbill(custumerHotel);
		// custumerHotel = addBill();
		custumerHotel = delete(custumerHotel, 114);
		show(custumerHotel);
	}

	private static List<Ex02_hotel> createCustumer() {
		Ex02_billHours bill1 = new Ex02_billHours(111, "11/11/2020", "Lê Nhật 1", 100, 22);
		Ex02_billHours bill2 = new Ex02_billHours(112, "12/8/2020", "Lê Nhật 2", 200, 24);
		Ex02_billdate bill4 = new Ex02_billdate(114, "11/4/2020", "Lê Nhật 4", 400, 24);
		Ex02_billdate bill5 = new Ex02_billdate(115, "14/8/2020", "Lê Nhật 5", 500, 6);
		Ex02_billdate bill6 = new Ex02_billdate(116, "16/4/2020", "Lê Nhật 6", 600, 13);
		List<Ex02_hotel> custumer = Arrays.asList(bill1, bill2, bill4, bill5, bill6);
		return custumer;
	}

	private static void totalbill(List<Ex02_hotel> bills) {
		int billHours = 0;
		int billDate = 0;
		for (Ex02_hotel bill : bills) {
			if (bill instanceof Ex02_billHours) {
				billHours += 1;
			} else {
				billDate += 1;
			}
		}
		System.out.println("Bill Of Date: " + billDate);
		System.out.println("Bill of Hours: " + billHours);
	}

//	private static List<Ex02_hotel> addBill() { Chưa hợp lý lắm =D 
//		Ex02_billdate bill6 = new Ex02_billdate(116, "16/4/2020", "Lê Nhật 7", 700, 16);
//		List<Ex02_hotel> bills = Arrays.asList(bill6);
//		return bills;
//	}

	private static List<Ex02_hotel> delete(List<Ex02_hotel> bills, Integer idBill) {
		for (int i = 0; i < bills.size(); i++) {
			if (idBill.equals(bills.get(i).getIdbill())) {
				bills.remove(i);
			}
		}
		return bills;
	}
	private static void show(List<Ex02_hotel> hoteBill) {
		for (Ex02_hotel hoteBills : hoteBill) {
			System.out.println(hoteBills);
		}
	}

}
