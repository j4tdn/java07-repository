package java07.Lesson09_PhamHoaMau;

public class Ex04 {
	public static void main(String[] args) {
		String username = "PhamHoaMau", passwordTemp = "admin123", pass = "Hoamau@1912";
		checkPassword(pass);
	}

	private static void checkPassword(String pass) {
		String pattern = "(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
		System.out.println((pass.matches(pattern) ? "OK!!!" : "Wrong format!!!"));
	}
}
