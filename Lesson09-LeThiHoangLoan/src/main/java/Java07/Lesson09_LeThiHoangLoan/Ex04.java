package Java07.Lesson09_LeThiHoangLoan;

import java.io.IOException;
import java.util.Scanner;

public class Ex04 {
	public static Scanner ip = new Scanner(System.in);
	private static final String PASS = "admin123";

	public static void main(String[] args) {
		String name = "";
		String oldPass = "";
		String password = "";

		System.out.println("Nhap ten tai khoan");
		try {
			name = ipName();
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		System.out.println("Thay mat khau \n Nhap mat khau cu");
		while (true) {
			try {
				 check();
				break;
			} catch (Exception e) {
				System.out.println("Exception :" + e.getMessage());
				System.out.println("Nhap lai mat khau cu");
			}
		}
		
		System.out.println("Nhap mk moi");
		while (true) {
			try {
				password = ipPassword();
				break;
			} catch (Exception e) {
				System.out.println("Exception :" + e.getMessage());
				System.out.println("Nhap lai Password");
			}
		}

	}

	public static String ipName() throws Exception {
		String name = ip.nextLine();
		for (int i = 0; i < name.length(); i++) {

			if ((name.charAt(i) >= 65 && name.charAt(i) <= 90) || (name.charAt(i) >= 97 && name.charAt(i) <= 122)) {

			} else {
				throw new Exception("Ten ko duoc co so hay ki tu dac biet");
			}
		}

		return name;
	}

	public static String ipPassword() throws Exception {
		String pass = ip.nextLine();
		String array = "!@#$%^&*";
		boolean bl1 = false, bl2 = false;


		if (pass.length()<8) {
			throw new Exception("Mat khau >=8 kitu");
		}
		for (int i = 0; i < pass.length(); i++) {
			if (pass.charAt(i) >= 65 && pass.charAt(i) <= 90) {
				bl1 = true;
			}
			for (int j = 0; j < array.length(); j++) {
				if (array.charAt(j) == pass.charAt(i)) {
					bl2 = true;
				}
			}
		}
		if (bl1 != true || bl2 != true) {
			throw new Exception("Mat khau phai co it nhat 1 chu Hoa va 1 ki tu dac biet");
		}
		return pass;

	}

	public static boolean check() throws Exception {
		String oldPass = ip.nextLine();

		if (!oldPass.equals(PASS)) {
			throw new IOException("Sai mat khau");
		}
		return true;
		
	}

}














