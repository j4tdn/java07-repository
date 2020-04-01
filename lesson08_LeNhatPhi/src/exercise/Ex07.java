package exercise;

public class Ex07 {
	public static void main(String[] args) {
		String string = "aaabaaabbaaaaa";
		int current = 0;
		int count = 1;
		int max = 0;
		int maxIndex = 0;
		for (int i = 0; i < string.length() - 1; i++) {
			if (string.charAt(i) != string.charAt(i + 1)) {
				if (count > max) {
					max = count;
					maxIndex = current;
				}
				current = i + 1;
				count = 1;
			} else {
				++count;
			}
		}
		if (count > max) {
			max = count;
			maxIndex = current;
		}
		System.out.println("Vị trí thứ: "+"["+maxIndex+"]");
		System.out.print("Chuỗi dài nhất:");
		for (int i = maxIndex; i < maxIndex + max; i++) {
			System.out.print(string.charAt(i));
		}
	}

}
