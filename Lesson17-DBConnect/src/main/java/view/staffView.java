package view;

import dao.StaffDao;
import dao.StaffDaoImpl;

public class staffView {
	private static StaffDao staffDao;
	static {
		staffDao = new StaffDaoImpl();

	}
	public static void main(String[] args) {
		String username = "haylam";
		String password = "123abc";
		Integer staffId = 1;
		boolean isValid = staffDao.updateAcount(staffId, username, password);
		System.out.println(isValid);
	}
}
