package java07.Lesson09_submit;

public class Bt01 {
	public static void main(String[] args) {
		String s = "we are learning the bad pro language";
		String[] array = s.split("[\\s]+");
		int number = 0;
		for (int i = 0; i < array.length; i++) {
			number++;
		}
		System.out.println(number + " words");
	}

}
