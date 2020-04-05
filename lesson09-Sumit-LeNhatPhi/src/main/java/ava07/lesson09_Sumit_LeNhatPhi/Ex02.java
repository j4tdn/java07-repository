package ava07.lesson09_Sumit_LeNhatPhi;

public class Ex02 {
	public static void main(String[] args) {
		String str = "a1b2c1234b5";
		str = str.replaceAll("[^0-9,-\\.]", ",");
		String[] item = str.split(",");
		String count ;
		for (int i = 0; i < item.length; i++) {
			try {
				Double.parseDouble(item[i]);//tách số ra khỏi chữ sysout+item[i]
				if(item[i] > count) {
					count = item[i];
				}
				System.out.println("chuỗi con  lớn nhất:"+count);

			} catch (NumberFormatException e) {
			}
		}

	}
}
