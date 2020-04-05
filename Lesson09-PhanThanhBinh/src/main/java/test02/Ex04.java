package test02;

import java.util.Scanner;

public class Ex04 {
	private static Scanner sc = new Scanner(System.in); 
	public static void main(String[] args) {
		System.out.print("Enter name user: ");
		String name = sc.nextLine();
		String passwork = "admin123";
		User user = new User(name, passwork);
		do {
			try {
				changePass(user);
				System.out.println("Password successfully changed");
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage());
				passwork = sc.nextLine();
				user = new User(name, passwork);
			}
		} while (true);
	}
	
	private static void changePass(User user) throws Exception {
		String pattern = "((?=.*[\\d])(?=.*[A-Z])(?=.*[!@#$%^&*]).{8,})";
		if (!user.getPasswork().matches(pattern)) {
			throw new Exception("Passwork is not valid! Enter pass again: ");
		}
		int count = 0;
		for (char charName: user.getName().toCharArray()) {
			for (char charPass: user.getPasswork().toCharArray()) {
				if (charName == charPass) {
					count++;
					break;
				}
			}
		}
		if (count >= 3) {
			throw new Exception("Passwork is not valid! Enter pass again:");
		}
	}
}

class User {
	private String name;
	private String passwork;
	
	public User(String name, String passwork) {
		super();
		this.name = name;
		this.passwork = passwork;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPasswork() {
		return passwork;
	}

	public void setPasswork(String passwork) {
		this.passwork = passwork;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", passwork=" + passwork + "]";
	}
	
}
