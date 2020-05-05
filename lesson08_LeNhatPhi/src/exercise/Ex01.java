package exercise;

public class Ex01 {

	public static void main(String[] args) {
		String string = "hoài, hùng, oanh, liệt";
		char characters = 0;
		System.out.println("characters per line: ");
		for (int i = 0; i < string.length(); i++) {
			kytu = string.charAt(i);
			System.out.println(kytu);
		}

		System.out.println("========================");
		for (int i = 0; i < string.length(); i++) {
			kytu = string.charAt(i);
			if (Character.isSpace(kytu)) {
				System.out.println();
			} else {
				System.out.print(kytu);
			}
		}
		System.out.println("\n=========================");
		String reverse = new StringBuffer(string).reverse().toString();
		System.out.println(reverse);
		
		
	}
}
