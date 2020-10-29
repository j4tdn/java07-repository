package views;

import dao.StaffDao;
import dao.StaffDaoImpl;

public class StaffView {
	
	private static StaffDao staffDao;
	
	static {
		staffDao = new StaffDaoImpl();
	};
	
	public static void main(String[] args) {
		String username = "Admid3";
		String password = "12345678";
		Integer staffId = 3;
		boolean isValid = staffDao.updateAcount(staffId, username, password);
		System.out.println(isValid);
	}
}
