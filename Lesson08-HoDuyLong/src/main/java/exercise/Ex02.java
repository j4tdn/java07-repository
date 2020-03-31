package exercise;

public class Ex02 {
	public static void main(String[] args) {
		String inputString = "ho duy lONG";

		printName(inputString);
	}

	private static void printName(String s) {
		if (s.matches("[A-Za-z\\s]+")) {
			String[] array = s.split("[\\s]+");
			String result = "";
			for (String string : array) {
				result = result + string.substring(0, 1).toUpperCase() + string.substring(1).toLowerCase() + " ";
			}
			result = result.trim();
			System.out.println(result);
		} else {
			System.out.println("Invalid !");
		}
	}
}
