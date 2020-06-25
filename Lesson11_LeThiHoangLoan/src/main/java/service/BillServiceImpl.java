package service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

import dao.BillDao;
import dao.BillDaoImpl;
import date01.Bill;

public class BillServiceImpl implements BillService{
	private static BillDao dao = new BillDaoImpl();

	@Override
	public List<Bill> getAll() {
		return dao.getAll();
	}

	

}
