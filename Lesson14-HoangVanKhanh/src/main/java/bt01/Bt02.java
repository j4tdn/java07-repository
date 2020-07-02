package bt01;

import java.util.Scanner;

public class Bt02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap do tuoi :");
		int old = Integer.parseInt(sc.nextLine());
		System.out.println("Nhap so gio ngu :");
		int hour = Integer.parseInt(sc.nextLine());
		System.out.println("Nhap so phut ngu :");
		int minute = Integer.parseInt(sc.nextLine());
		people(old, hour, minute);
	}

	public static void people(int old, int hour, int minute) {
		if (old <= 3) {
			int timetoithieu = 20;
			if (hour < timetoithieu) {
				int timeSleep = (timetoithieu * 60) - (hour * 60) - minute;
				int slep = 23 * 60 + timeSleep;
				int gio = slep / 60;
				int phut = (slep / 60) - gio;
				if (gio < 25) {

					System.out.println(" thoi gian bat dau ngu :" + 23 + "H");
					System.out.println("Ban nen thuc day luc :" + gio + "H" + phut + "phut");

				} else {
					int homsau = gio - 24;
					System.out.println(" thoi gian bat dau ngu :" + 23 + "H");
					System.out.println("Ban nen thuc day luc :" + homsau + "H" + phut + "phut" + " ngay hom sau");
				}
			} else {
				System.out.println("ko can ngu");
			}

		}
		if (4 <= old && old <= 13) {
			int timetoithieu = (10 + 12) / 2;
			if (hour < timetoithieu) {
				int timeSleep = (timetoithieu * 60) - (hour * 60) - minute;
				int slep = 23 * 60 + timeSleep;
				int gio = slep / 60;
				int phut = (slep / 60) - gio;
				if (gio < 25) {

					System.out.println(" thoi gian bat dau ngu :" + 23 + "H");
					System.out.println("Ban nen thuc day luc :" + gio + "H" + phut + "phut");

				} else {
					int homsau = gio - 24;
					System.out.println(" thoi gian bat dau ngu :" + 23 + "H");
					System.out.println("Ban nen thuc day luc :" + homsau + "H" + phut + "phut" + " ngay hom sau");
				}
			} else {
				System.out.println("ko can ngu");
			}

		}
		if (14 <= old && old <= 17) {
			int timetoithieu = (8 + 10) / 2;
			if (hour < timetoithieu) {
				int timeSleep = (9 * 60) - (hour * 60) - minute;
				int slep = 23 * 60 + timeSleep;
				int gio = slep / 60;
				int phut = (slep / 60) - gio;
				if (gio < 25) {

					System.out.println(" thoi gian bat dau ngu :" + 23 + "H");
					System.out.println("Ban nen thuc day luc :" + gio + "H" + phut + "phut");

				} else {
					int homsau = gio - 24;
					System.out.println(" thoi gian bat dau ngu :" + 23 + "H");
					System.out.println("Ban nen thuc day luc :" + homsau + "H" + phut + "phut" + " ngay hom sau");
				}
			} else {
				System.out.println("ko can ngu");
			}

		}
		if (18 <= old && old <= 64) {
			int timetoithieu = (9 + 7) / 2;
			if (hour < timetoithieu) {
				int timeSleep = (8 * 60) - (hour * 60) - minute;
				int slep = 23 * 60 + timeSleep;
				int gio = slep / 60;
				int phut = (slep / 60) - gio;
				if (gio < 25) {

					System.out.println(" thoi gian bat dau ngu :" + 23 + "H");
					System.out.println("Ban nen thuc day luc :" + gio + "H" + phut + "phut");

				} else {
					int homsau = gio - 24;
					System.out.println(" thoi gian bat dau ngu :" + 23 + "H");
					System.out.println("Ban nen thuc day luc :" + homsau + "H" + phut + "phut" + " ngay hom sau");
				}
			} else {
				System.out.println("ko can ngu");
			}

		}
		if (65 <= old) {
			float timetoithieu = (7 + 8) / 2;
			float timeSleep = (timetoithieu * 60) - (hour * 60) - minute;
			if (hour < timetoithieu) {
				float slep = 23 * 60 + timeSleep;
				float gio = slep / 60;
				float phut = (slep / 60) - gio;
				if (gio < 25) {

					System.out.println(" thoi gian bat dau ngu :" + 23 + "H");
					System.out.println("Ban nen thuc day luc :" + gio + "H" + phut + "phut");

				} else {
					float homsau = gio - 24;
					System.out.println(" thoi gian bat dau ngu :" + 23 + "H");
					System.out.println("Ban nen thuc day luc :" + homsau + "H" + phut + "phut" + " ngay hom sau");
				}

			} else {
				System.out.println("ko can ngu");
			}
		}

	}

}
