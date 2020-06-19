package date01;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Ex04 {
	public static void main(String[] args) throws InterruptedException {
		String[] students = { "Ho Duy Long", "Ho Quang Phuoc", "Pham Phu", "Tran Quoc Tuan", "Hoang Thi Dung" };

		print(students);

		System.out.println("============SHUFFLE============");
		shuffle(students);

		System.out.println("============GET RANDOM STUDENT============");
		Thread.sleep(3000);
		getRandomStudent(students);
	}

	private static void print(String[] students) {
		Arrays.stream(students).forEach(System.out::println);
	}

	private static void shuffle(String[] students) {
		List<String> list = Arrays.asList(students);
		Collections.shuffle(list);

		list.forEach(System.out::println);
	}

	private static void getRandomStudent(String[] students) {
		List<String> list = Arrays.asList(students);
		Random rd = new Random();

		System.out.println(list.get(rd.nextInt(list.size())));
	}
}
