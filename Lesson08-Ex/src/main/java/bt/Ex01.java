package bt;

public class Ex01 {
	public static void main(String[] args) {
		String s = "Đặng Đình Hoàng";
		characters(s);
		System.out.println("+++++++++++++++");
		words(s);
	}

	private static void characters(String s) {
		// In ra mỗi kí tự trên một dòng
		for (int i = 0; i < s.length(); i++) {
			System.out.println(s.charAt(i));
		}
		System.out.println("+++++++++++++++");
		// In ra chuỗi đảo ngược theo kí tự
		for (int i = s.length() - 1; i >= 0; i--) {
			System.out.println(s.charAt(i));
		}
	}

	private static void words(String s) {
		// In ra mỗi từ trên mỗi dòng
		String[] words = s.split("\\s");
		for (String word : words) {
			System.out.println(word);
		}
		System.out.println("+++++++++++++++");
		// In ra chuỗi đảo ngược theo từ
		for (int i = words.length - 1; i >= 0; i--) {
			System.out.println(words[i]);
		}
	}
}