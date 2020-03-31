package exercise;

public class Ex05 {
	public static void main(String[] args) {
		String str1 = "ABCDEF";
		String str2 = "ABCHE";
		findMaxLength(str1, str2);
	}
	
	private static void findMaxLength(String str1, String str2) {
		int length = 1;
		int max = 1;
		int start = 0;
		int end = 0;
		String str = str1 + str2;
		String[] strArr = str.split("");
		for (int i = 0; i < str1.length(); i++) {
			if(i + str1.length() < strArr.length) {
				if(strArr[i].equals(strArr[str1.length() + i])) {
					length++;
					if(length > max) {
						max = length;
						start = i + 2 - length;
						end = i + 2;
					}
				} else {
					length = 1;
				}
			}
		}
		
		for (int j = start; j < end - 1; j++) {
			System.out.print(strArr[j] + "");
		}
	}
}
