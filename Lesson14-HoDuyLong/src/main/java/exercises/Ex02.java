package exercises;

import java.util.Scanner;

public class Ex02 {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		wakeUpTime();
	}

	private static void wakeUpTime() {
		System.out.println("Input your age: ");
		int age = Integer.parseInt(sc.nextLine());
		System.out.println("Input your hours slept: ");
		int hourSlept = Integer.parseInt(sc.nextLine());
		System.out.println("Input your minutes slept: ");
		int minsSlept = Integer.parseInt(sc.nextLine());
		System.out.println("Input your hours sleep: ");
		int hourSleep = Integer.parseInt(sc.nextLine());
		System.out.println("Input your minutes sleep: ");
		int minsSleep = Integer.parseInt(sc.nextLine());

		int timeNeed = sleepTimeAtLeast(age);
		int timeRemain = timeNeed - (hourSlept * 60 + minsSlept);
		int hourWakeUp = ((timeRemain / 60) + hourSleep) - 24;
		int minWakeup = (timeRemain % 60) + minsSleep;
		if (minWakeup >= 60) {
			minWakeup -= 60;
			hourWakeUp++;
		}

		System.out.println(hourWakeUp + "H" + minWakeup);

	}

	private static int sleepTimeAtLeast(int age) {
		if (age >= 1 && age <= 3) {
			return 20 * 60;
		} else if (age >= 4 && age <= 13) {
			return 11 * 60;
		} else if (age >= 14 && age <= 17) {
			return 9 * 60;
		} else if (age >= 18 && age <= 64) {
			return 8 * 60;
		} else {
			return (int) (7.5 * 60);
		}
	}
}
