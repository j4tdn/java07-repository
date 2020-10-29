package view;

import dao.StaffDao;
import dao.StaffDaoImpl;

public class StaffView {
	private static StaffDao staffDao;
	static {
		staffDao = new StaffDaoImpl();
	}
	public static void main(String[] args) {
		String username = "user1";
		String password = "123456";
		Integer staffid = 1;
		boolean isValid = staffDao.updateAcount(staffid, username, password);
		System.out.println(isValid);
	}

}
