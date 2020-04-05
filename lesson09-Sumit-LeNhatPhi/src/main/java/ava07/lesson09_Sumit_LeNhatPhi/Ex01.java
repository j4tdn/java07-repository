package ava07.lesson09_Sumit_LeNhatPhi;

public class Ex01 {
	public static void main(String[] args) {
		String str = "Lê Nhật Phi Duy Tân Quảng Trị";
		int count = 0;
		char space = ' ';
		boolean check = true;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != space) {
				if (check) {
					count++;
					check = false;
				}
			} else {
				check = true;
			}
		}
		System.out.println(count);
	}
}
