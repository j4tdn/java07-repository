package dao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import date01.Bill;
import date01.BillByDay;
import date01.BillByHour;

public class BillDaoImpl implements BillDao {

	@Override
	public List<Bill> getAll() {

		return mock();
	}

	private static List<Bill> mock() {
		List<Bill> listBill = new ArrayList<Bill>();

		Bill bill1 = new BillByDay("HD-001", "11/5/2017", "Le Tinh", "P101", 500, 10);
		Bill bill2 = new BillByDay("HD-002","03/05/2017", "Le Thinh", "P102", 400, 12);
		Bill bill3 = new BillByDay("HD-003", "05/09/2017", "Le Dinh", "P105", 300, 6);
		Bill bill4 = new BillByDay("HD-004", "21/07/2017", "Le Vinh", "P102", 400, 1);
		Bill bill5 = new BillByHour("HD-006", "30/09/2017", "Le Minh", "P102", 50, 10);
		Bill bill6 = new BillByHour("HD-007", "13/03/2017", "Le Sinh", "P102", 80, 35);

		listBill.add(bill1);
		listBill.add(bill2);
		listBill.add(bill3);
		listBill.add(bill4);
		listBill.add(bill5);
		listBill.add(bill6);

		return listBill;
	}

}
