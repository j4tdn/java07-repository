package view;

import dao.StaffDao;
import dao.StaffDaoImpl;

public class StaffView {
	private static StaffDao staffDao;

	static {
		staffDao = new StaffDaoImpl();
	}

	public static void main(String[] args) {
		String username = "TK01";
		String password = "12345678";
		Integer staffId = 1;

		boolean isVaLid = staffDao.updateAccount(staffId, username, password);
		System.out.println(isVaLid);
	}
}