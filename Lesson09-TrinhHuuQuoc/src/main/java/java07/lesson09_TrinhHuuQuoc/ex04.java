package java07.lesson09_TrinhHuuQuoc;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ex04 {
	public static void main(String[] args) {
		System.out.println("Nhập tên người dùng:");
		Scanner scanner= new Scanner(System.in);
		String fullNameString= scanner.nextLine();
		String pasString= "admin123";
		
		String regret= "?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
		Pattern pattern= Pattern.compile(regret);
	}
}
