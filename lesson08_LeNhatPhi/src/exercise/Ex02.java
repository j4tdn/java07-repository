package exercise;

public class Ex02 {
	public static void main(String[] args) {
		String name = "  lê     nhật      phi  ";

		StringBuffer bf = new StringBuffer(name);
		int i = 0;
		do {
			bf.replace(i, i + 1, bf.substring(i, i + 1).toUpperCase());
			i = bf.indexOf(" ", i) + 1;

		} while (i > 0 && i < bf.length());
		System.out.println("Name: " + bf.toString().trim().replaceAll("[\\s]+", " "));
	}
}
