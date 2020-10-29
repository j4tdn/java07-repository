package view;

import dao.StaffDao;
import dao.StaffDaoImpl;

public class StaffView {

	private static StaffDao staffDao;
	static {
		staffDao=new StaffDaoImpl();
	}
	public static void main(String[] args) {
		String username="ngu";
		String password="dmm";
		Integer staffId=1;
		
		boolean isVaild=staffDao.updateAcount(staffId, username, password);
		System.out.println(isVaild);
}
	
}

