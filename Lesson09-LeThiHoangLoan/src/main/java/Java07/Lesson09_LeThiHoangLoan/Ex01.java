package Java07.Lesson09_LeThiHoangLoan;

public class Ex01 {

	public static void main(String[] args) {
		String strings = "we are learning the   bad pro language";
		String[] sArray = strings.split("[\\s]+");

		System.out.println(sArray.length);
	}
}
