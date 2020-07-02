import java.util.Calendar;
import java.util.Scanner;

public class Bai2 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Nhap so tuoi hien tai:");
		int age = scn.nextInt();
		System.out.println("Nhap thoi gian da ngu:");
		System.out.print("Gio: ");
		int hour = scn.nextInt();
		System.out.print("Phut: ");
		int minute = scn.nextInt();
		System.out.println("Nhap thoi gian bat dau ngu:");
		int hourBegin = scn.nextInt();

	}

	private static void handing(int age, int hour, int minute) {
		long sleepedTimeInMinute = hour * 60L + minute;
		long timeLeftInMinute = 0L;
		int hourResult = 0;
		int minuteResult = 0;
		if (age < 3) {
			timeLeftInMinute = 20 * 60L - sleepedTimeInMinute;
			hourResult = (int) (timeLeftInMinute / 60);
			minuteResult = (int) (timeLeftInMinute - hourResult * 60);
		}
	}
}
