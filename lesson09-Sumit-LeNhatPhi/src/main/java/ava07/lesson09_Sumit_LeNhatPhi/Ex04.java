package ava07.lesson09_Sumit_LeNhatPhi;

import java.util.Scanner;

public class Ex04 {
	static Scanner cs = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		System.out.println("Thay đổi mật khẩu tài khoản");
		input();
		while (true) {
			try {
				System.out.println("Yêu Cầu đổi mật Khẩu");
				changePass();
				System.out.println("Nhập thành công");
				break;
			} catch (Exception e) {
				System.out.println("Nhập sai yêu cầu nhập lại");
			}
		}

	}

	public static void input() {

		System.out.println("Nhập id: ");
		String id = cs.nextLine();
		if (id.equals("nhatphi")) {
			System.out.println("Mật Khẩu của id này là : admin123");
		}
	}

	public static void changePass() throws Exception {
		System.out.println("Nhập Mật Khẩu muốn đổi:");
		String pass = cs.nextLine();
		if (!validPasss(pass)) {
			throw new Exception("Không hợp lệ!");
		}
	}

	private static boolean validPasss(String pass) {
		return pass.matches("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$");// Ít nhất một chữ cái
																								// viết hoa
																								// ,(?=.*?[A-Z])
																								// Ít nhất một chữ cái
																								// thường, (?=.*?[a-z])
																								// Ít nhất một chữ
																								// số(?=.*?[0-9])
																								// Ít nhất một kí tự đặc
																								// biệt,
																								// (?=.*?[#?!@$%^&*-])
																								// tối thiểu 8 ký tự
																								// .{8,}
	}

}
