package java07.lesson08_NguyenPhanThanhNhat;

import java.util.Scanner;

public class Bai3 {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		String s = ip.nextLine();
		StringBuilder result = new StringBuilder();
		for (char c : s.toCharArray()) {
			result.append(removeSign(c));
		}
		System.out.println(result);
	}

	public static char removeSign(char c) {
		switch (c) {
		case 'À':
		case 'Á':
		case 'Â':
		case 'Ã':
		case 'Ă':
		case 'Ạ':
		case 'Ả':
		case 'Ấ':
		case 'Ầ':
		case 'Ẩ':
		case 'Ẫ':
		case 'Ậ':
		case 'Ắ':
		case 'Ằ':
		case 'Ẳ':
		case 'Ẵ':
		case 'Ặ':
			return 'A';
		case 'È':
		case 'É':
		case 'Ê':
		case 'Ẹ':
		case 'Ẻ':
		case 'Ẽ':
		case 'Ế':
		case 'Ề':
		case 'Ể':
		case 'Ễ':
		case 'Ệ':
			return 'E';
		case 'Ì':
		case 'Í':
		case 'Ĩ':
		case 'Ỉ':
		case 'Ị':
			return 'I';
		case 'Ò':
		case 'Ó':
		case 'Ô':
		case 'Õ':
		case 'Ọ':
		case 'Ơ':
		case 'Ỏ':
		case 'Ố':
		case 'Ồ':
		case 'Ổ':
		case 'Ỗ':
		case 'Ộ':
		case 'Ớ':
		case 'Ờ':
		case 'Ở':
		case 'Ỡ':
		case 'Ợ':
			return 'O';
		case 'Ù':
		case 'Ú':
		case 'Ũ':
		case 'Ư':
		case 'Ụ':
		case 'Ủ':
		case 'Ứ':
		case 'Ừ':
		case 'Ử':
		case 'Ữ':
		case 'Ự':
			return 'U';
		case 'Ý':
			return 'Y';
		case 'à':
		case 'á':
		case 'â':
		case 'ã':
		case 'ă':
		case 'ạ':
		case 'ả':
		case 'ấ':
		case 'ầ':
		case 'ẩ':
		case 'ẫ':
		case 'ậ':
		case 'ắ':
		case 'ằ':
		case 'ẳ':
		case 'ẵ':
		case 'ặ':
			return 'a';
		case 'è':
		case 'é':
		case 'ê':
		case 'ẹ':
		case 'ẻ':
		case 'ẽ':
		case 'ế':
		case 'ề':
		case 'ể':
		case 'ễ':
		case 'ệ':
			return 'e';
		case 'ì':
		case 'í':
		case 'ĩ':
		case 'ỉ':
		case 'ị':
			return 'i';
		case 'ò':
		case 'ó':
		case 'ô':
		case 'õ':
		case 'ọ':
		case 'ơ':
		case 'ỏ':
		case 'ố':
		case 'ồ':
		case 'ổ':
		case 'ỗ':
		case 'ộ':
		case 'ớ':
		case 'ờ':
		case 'ở':
		case 'ỡ':
		case 'ợ':
			return 'o';
		case 'ù':
		case 'ú':
		case 'ũ':
		case 'ư':
		case 'ụ':
		case 'ủ':
		case 'ứ':
		case 'ừ':
		case 'ử':
		case 'ữ':
		case 'ự':
			return 'u';
		case 'ý':
			return 'y';
		case 'Đ':
			return 'D';
		case 'đ':
			return 'd';
		default:
			return c;
		}
	}
}
