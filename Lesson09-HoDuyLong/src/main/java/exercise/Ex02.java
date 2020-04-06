package exercise;

public class Ex02 {
	public static void main(String[] args) {
		String inputString1 = "aa6b326c6e22h";
		String inputString2 = "aa6b546c6e22h";
		int maxNumOfStr1 = maxNumber(inputString1);
		int maxNumOfStr2 = maxNumber(inputString2);
		
		System.out.println((maxNumOfStr1 < maxNumOfStr2 ? maxNumOfStr1 : maxNumOfStr2) + ", " + (maxNumOfStr1 > maxNumOfStr2 ? maxNumOfStr1 : maxNumOfStr2));
	}
	
	private static int maxNumber(String s) {
		if (s.isEmpty()) {
			return 0;
		}
		else {
			int max = 0;
			String[] numbers = s.split("[\\D]+");
			for (String number : numbers) {
				if (number.equals("")) {
					number = "0";
				}
				if (max < Integer.parseInt(number)) {
					max = Integer.parseInt(number);
				}
			}
			return max;
		}
	}
}
