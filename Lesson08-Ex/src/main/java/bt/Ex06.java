package bt;

public class Ex06 {
	public static void main(String[] args) {
		StringBuilder s = new StringBuilder();
		int K = 100;

		for (int i = 1; i <= K; i++) {
			s = s.append(i);
		}
//		System.out.println(s);
//		System.out.println(s.length());

		System.out.println(s.charAt(K));
	}
}
