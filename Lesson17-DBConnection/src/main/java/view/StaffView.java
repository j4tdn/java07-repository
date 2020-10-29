package view;

import dao.StaffDao;
import dao.StaffDaoImpl;

public class StaffView {
	private static StaffDao staffDao;
	
	static {
		staffDao = new StaffDaoImpl();
	}
	
	public static void main(String[] args) {
		String username = "hoduylong";
		String password = "123456long";
		Integer staffId = 1;
		
		boolean isValid = staffDao.updateAccount(staffId, username, password);
		System.out.println(isValid);
	}
}
