package exercise;

public class Ex04 {
	public static void main(String[] args) {
		int number1 = 75;
		int number2 = 15;
		if(equivalentPrimeNumber(prime(number1), prime(number2)) == true) {
			System.out.println("Is equivalent prime number");
		}else {
			System.out.println("isn't equivalent prime number");
		}
		
	}
	public static StringBuilder prime(int n) {
		StringBuilder stringPrime = new StringBuilder();
		String string;
		int count = 0;
		for (int i = 2; i > 1; i++) {
			if (n % i == 0) {
				n /= i;
				if (i != count) {
					string = Integer.toString(i);
					stringPrime.append(string);
				}
				count = i;
			}
		}
		return stringPrime;
	}

	public static boolean equivalentPrimeNumber(StringBuilder number1, StringBuilder number2) {
		return (number1.toString().compareTo(number2.toString()) == 0) ? true : false;
	}

}
