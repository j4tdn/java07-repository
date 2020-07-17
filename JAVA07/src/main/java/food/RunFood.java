package food;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class RunFood extends ThucPham {

	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		ThucPham tp = new ThucPham();
		boolean kt = true;
		boolean th = true;
		System.out.println("Nhập mã hàng: ");
		tp.setMahang(ip.nextInt());
		ip.nextLine();
		do {
			System.out.println("Nhập tên hàng: ");
			tp.setTenhang(ip.nextLine());
		}while(tp.kiemTraTenHang(kt)); 
			System.out.println("Nhập đơn giá");
			tp.setDongia(ip.nextDouble());
		do {
			System.out.println("Nhập ngày tháng sản xuất");
			tp.setNSX(ip.nextInt(), ip.nextInt(), ip.nextInt());
			System.out.println("Nhập ngày tháng năm hết hạn");
			tp.setHHD(ip.nextInt(), ip.nextInt(), ip.nextInt());
		}while(tp.kiemTraNgay(th));
		System.out.println(tp);
		tp.kiemtraHSD();
		
		
	}
}
