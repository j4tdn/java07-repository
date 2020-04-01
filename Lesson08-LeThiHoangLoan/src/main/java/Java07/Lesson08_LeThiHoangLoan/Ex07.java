package Java07.Lesson08_LeThiHoangLoan;

public class Ex07 {
	public static void main(String[] args) {

		String str = "aaassssddaaaeeeeelllllllll";
		int temp = 0;
		int start1 = 0;
		int start2 = 0;
		int max = 1;
		int min = str.length();
		
		while (temp < str.length()) {
			int value = check(temp, str);
			if (value > max) {
				max = value;
				start1 = temp;
			}
			
			if (value < min) {
				min = value;
				start2 = temp;
			}

			temp += value;
		}
		System.out.print("Độ dài chuỗi lớn nhất " + max + ":");
		for (int i = start1; i < start1 + max; i++) {
			System.out.print(str.charAt(i));
		}
		System.out.print(" [" + start1 + "]");

		System.out.print("\nĐộ dài chuỗi nhỏ nhất " + min + ":");
		for (int i = start2; i < start2 + min; i++) {
			System.out.print(str.charAt(i));
		}
		System.out.print(" [" + start2 + "]");

	}

	private static int check(int temp, String str) {
		int count = 1;
		for (int i = temp; i < str.length() - 1; i++) {
			if (str.charAt(i) == str.charAt(i + 1)) {
				count++;
			} else {
				break;
			}
		}
		return count;
	}
}
