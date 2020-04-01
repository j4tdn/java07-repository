package Java07.Lesson08_LeThiHoangLoan;

public class Ex05 {
	public static void main(String[] args) {
		String s1 = "ASMEOMEOHSDFH";
		String s2 = "JXHFDMEOMEOWRWE";
		int max = 1;
		int first = 0;
		int temp = 1;
		
		System.out.println(s1);
		System.out.println(s2);
		
		for (int i = 0; i < s1.length(); i++) {
			for (int j = 0; j < s2.length(); j++) {
				for (int count = 1; count < s1.length() - i; count++) {
					if (j + count < s2.length()) {
						if (s1.substring(i, i + count).equals(s2.substring(j, j + count))) {
							temp = count;
						}
					}
				}
				if (temp > max) {
					first = i;
					max = temp ;
				}
			}
		}
		System.out.println(s1.substring(first, first + max));

	}
}
