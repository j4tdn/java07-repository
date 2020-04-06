package views;

import java.util.Scanner;

public class Ex04 extends login {
	public Ex04(String username, String pass) {
		super(username, pass);
	}

	private static final int LENGTHNAME = 8;

	public static void main(String[] args) {
		String username = input("username:");
		String pass = "admin123";
		login lg = new login(username, pass);

		System.out.println("Mật khẩu ban đầu của tài khoản là:" + lg.getPass());
		String check;
		while (true) {
			try {
				check = input("Mật khẩu muốn thay đổi:");
				if (isValidPass(check, username)) {
					lg.setPass(check);
					System.out.println("Đổi thành công.");
				}
				break;
			} catch (RuntimeException e) {
				System.out.println(e.getMessage());
			}
		}

	}

	static String input(String a) {
		Scanner ip = new Scanner(System.in);
		System.out.print("Nhập " + a);
		String string = ip.nextLine();
		return string;
	}

	private static boolean isValidPass(String password, String username) {
		int count = 0;
		for (char element : password.toLowerCase().toCharArray()) {
			for (char elementOfPasswordDefault : username.toLowerCase().toCharArray()) {
				if (element == elementOfPasswordDefault) {
					count++;
					break;
				}
			}
		}
		if (password.length() < 8 || password.length() > 63) {
			throw new RuntimeException("Số lượng kí tự [8-63]");
		}
		if (checkUperCase(password) == false) {
			throw new RuntimeException("Mật khẩu phải gồm ít nhất 1 kí tự hoa!");
		}
		if (check2(password) == false) {
			throw new RuntimeException("Mật khẩu phải gồm ít nhất 1 kí tự đặc biệt!");
		}
		if (isNumber(password) == false) {
			throw new RuntimeException("Mật khẩu phải gồm ít nhất 1 kí tự số!");
		}
		if (count > 3) {
			throw new RuntimeException("Không trùng với tên username quá 3 kí tự");
		}

		return true;
	}

	private static boolean isNumber(String s) {
		char[] chars = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j < chars.length; j++) {
				if (s.charAt(i) == chars[j])
					return true;
			}
		}
		return false;
	}

	private static boolean checkUperCase(String s) {
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')
				return true;
		}
		return false;
	}

	private static boolean check2(String s) {
		char[] chars = { '!', '@', '#', '$', '%', '^', '&', '*' };
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j < chars.length; j++) {
				if (s.charAt(i) == chars[j])
					return true;
			}
		}
		return false;
	}

}

class login {
	String username;
	String pass = "admin123";

	public login(String username, String pass) {
		super();
		this.username = username;
		this.pass = pass;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

}
