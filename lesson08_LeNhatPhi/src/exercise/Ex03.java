package exercise;

import java.text.Normalizer;//cung cấp phương thức chuẩn hoá Uni thành vb thường
import java.util.regex.Pattern;

public class Ex03 {
	public static void main(String[] args) {
		String string = "Mẹ em biểu không được chơi với phi bởi vì phi quá đẹp trai ";
		String temp = Normalizer.normalize(string, Normalizer.Form.NFD);//chuỗi string được truyền vào theo định dạng nfd
		Pattern pattern = Pattern.compile("\\p{IncombiningDiacriticalMarks}+");
		System.out.println(pattern.matcher(temp).replaceAll("").replace("đ", "d").replace("Đ", "d"));
	}

}
