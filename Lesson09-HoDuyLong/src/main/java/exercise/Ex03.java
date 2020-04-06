package exercise;

import java.util.Arrays;

public class Ex03 {
	public static void main(String[] args) {
		String[] input = {"102-Nam-C", "104-Hoàng-D", "109-Lan-A", "103-Bảo-F", "105-Nguyên-B", "107-Vũ-F", "103-Bảo-F", "202-Đạt-C", "107-Vũ-C", 
				"193-Bảo-B", "199-Tài-A"};
		System.out.println("Study just one time in 2018 and have A result");
		studyOnceAndHaveA(input);
		
	}
	
	private static void studyOnceAndHaveA(String[] stringArray) {
		int[] maSV = new int[stringArray.length];
		int i = 0;
		for (String str : stringArray) {
			maSV[i] = Integer.parseInt(str.substring(0, 3));
			i++;
		}
		Arrays.sort(maSV);
		for (int j = 0 ; j < maSV.length - 1 ; j++) {
			if (maSV[j] == maSV[j+1]) {
				maSV[j] = 0;
				maSV[j+1] = 0;
			}
		}
		for (int j = 0 ; j < stringArray.length ; j++) {
			for (int k = 0 ; k < maSV.length ; k++) {
				if (Integer.parseInt(stringArray[j].substring(0, 3)) == maSV[k] && stringArray[j].contains("A")) {
					System.out.println(stringArray[j]);
				}
			}
		}
	}
}
