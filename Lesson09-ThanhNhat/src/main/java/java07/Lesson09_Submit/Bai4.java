package java07.Lesson09_Submit;

import java.util.Scanner;

public class Bai4 {
	private static boolean ISVALID = false;
	private static int MINLENGTHID = 8;
	private static int LIMIT = 3;
	public static String DEFAULTPASS = "admin123";
	private static Scanner ip = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.print("Nhập thông tin tên tài khoản: ");
		String id = ip.nextLine();
		User user = new User(id, DEFAULTPASS);
		System.out.println(user);
		System.out.print("Đổi mật khẩu: ");
		String password = null;
		while (true) {
			try {
				password = ip.nextLine();
				ISVALID = isValidPass(password, id);
				break;
			} catch (RuntimeException e) {
				System.out.println(e.getMessage());
			}
		}
		user.setPass(password);
		System.out.println("Đổi mật khẩu thành công!");
		System.out.println(user);
	}

	private static boolean isValidPass(String password, String id) {
		if (password.length() < 8 || password.length() > 63) {
			throw new RuntimeException("Độ dài mật khẩu: >= 8");
		}
		if (check1(password) == false) {
			throw new RuntimeException("Mật khẩu phải gồm ít nhất 1 kí tự hoa!");
		}
		if (check2(password) == false) {
			throw new RuntimeException("Mật khẩu phải gồm ít nhất 1 chữ số!");
		}
		if (check3(password) == false) {
			throw new RuntimeException("Mật khẩu phải gồm ít nhất 1 kí tự đặc biệt!");
		}
		if (check4(password, id) == false) {
			throw new RuntimeException("Mật khẩu không được trùng quá 3 ký tự với tên tài khoản!");
		}
		return true;
	}

	private static boolean check1(String s) {
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')
				return true;
		}
		return false;
	}

	private static boolean check2(String s) {
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= '0' && s.charAt(i) <= '9')
				return true;
		}
		return false;
	}

	private static boolean check3(String s) {
		char[] chars = { '~', '!', '@', '#', '$', '%', '^', '&', '*' };
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j < chars.length; j++) {
				if (s.charAt(i) == chars[j])
					return true;
			}
		}
		return false;
	}

	private static boolean check4(String password, String id) {
		int count = 0;
		for (int i = 0; i < id.length(); i++) {
			if (password.indexOf(id.charAt(i)) >= 0) {
				count++;
				if (count == LIMIT)
					return false;
			}
		}
		return true;
	}
}

class User {
	private String id;
	private String pass;

	public User(String id, String pass) {
		super();
		this.id = id;
		this.pass = pass;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", pass=" + pass + "]";
	}
}