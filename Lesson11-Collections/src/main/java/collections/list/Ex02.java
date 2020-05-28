package collections.list;

import java.util.ArrayList;
import java.util.List;

public class Ex02 {// là 1 thư việc lưu trữ tập hợp các đối tượng trng colectio là 1 inf cha. có 3 phần list set map là những interfafe là những lớp thực thi, khác nhau lưu trữ dữ liệu và cung cấp 1 số phương thức giúp xử lý bài toán nhanh hơn 
	// giống: các phần tử trng arr và arrlist cùng kiểu dữ liệu, nằm sát nhau liền kề nhau, truy cập từng phần tử nhannh, cùng 1 chỉ số giá trị 
	// khác: arrr số lượng phần từ cố đinh, cung cấp các 
	// arrlist tăng số lượng phần từ 
	
	
	//arraylist : nằm liền kề nhau
	//linkylist: thuộc kiểu dữ liệu danh sách liên kết nhau có con trỏ trước và nhau để tham chiếu trước và sau nó , các phần tử ko nằm liên kết nhau giúp ta dễ dàng xoá thêm 1 phần tử ở giữa 
	
	//thêm phần tử ucosoi đầu thì arrlist chậm hơn vì mình phải dịch chuyển sang phải 1 đơn vị, đối vs linkylist thay đổi liên kết thêm phần từ vào đầu HEAD trỏ vào vị trí hiện tại, thêm ở giữa thì linklylist không có cơ chế truy cập 1 phần từ 
	
	// xoá 1 phần tử
	// cập nhật 1 phần tử
	// lấy phần tử đso ra arralist nhanh hơn vì linky hs phải trỏ tìm 
	
	//list fixx lỗi tại camplie
	//@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		List<Integer> digits = new ArrayList<>();
		
		digits.add(new Integer(5));
		digits.add(10);
		digits.add(20);
		digits.add(30);
		digits.add(40);
		

		// for index
		for (int i = 0; i < digits.size(); i++) {
			System.out.println(digits.get(i));
		}
	}
}
