package test02;

public class test {
	public static void main(String[] args) {
		String str = "aa6b326c6e22h";
		System.out.println(getMaxNumber(str));
	}
	private static int getMaxNumber(String str) {
		String[] charArr = str.split("");
		String strNumber = "";
		for (int i = 0; i < charArr.length; i++) {
			if (!charArr[i].matches("\\d")) {
				charArr[i] = " ";
			}
			strNumber += charArr[i];
		}
		System.out.println(strNumber);
		String numbers[] = strNumber.split("[\\s]+");
		System.out.println(numbers[1]);
	//	int max = Integer.parseInt(numbers[0]);
		int max = 0;
		
		for (String number: numbers) {
			System.out.println(number);
//			max = Integer.parseInt(number) > max ? Integer.parseInt(number) : max;
			System.out.println(number);
		}
		return max;
	}
}
