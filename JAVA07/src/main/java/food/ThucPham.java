package food;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class ThucPham {
	private int mahang;
	private String tenhang;
	private Double dongia;
	private Date nsx, hsd;

	public ThucPham(int mahang, String tenhang, Double dongia, Date nsx, Date hsd) {
		super();
		this.mahang = mahang;
		this.tenhang = tenhang;
		this.dongia = dongia;
		this.nsx = nsx;
		this.hsd = hsd;
	}

	public ThucPham() {
		// TODO Auto-generated constructor stub
	}

	public int getMahang() {
		return mahang;
	}

	public void setMahang(int mahang) {
		this.mahang = mahang;
	}

	public String getTenhang() {
		return tenhang;
	}

	public void setTenhang(String tenhang) {
		this.tenhang = tenhang;
	}

	public Double getDongia() {
		return dongia;
	}

	public void setDongia(Double dongia) {
		this.dongia = dongia;
	}

	public Date getNsx() {
		return nsx;
	}

	public void setNsx(Date nsx) {
		this.nsx = nsx;
	}

	public Date getHsd() {
		return hsd;
	}

	public void setHsd(Date hsd) {
		this.hsd = hsd;
	}

	@Override
	public String toString() {
		Locale localeVn = new Locale("vi", "VN");
		NumberFormat numberFormat = NumberFormat.getCurrencyInstance(localeVn);
		String str = numberFormat.format(dongia);
		// biến đổi ngày
		SimpleDateFormat simpleDF = new SimpleDateFormat("dd/MM/yyyy");
		String str1 = simpleDF.format(hsd);
		String str2 = simpleDF.format(nsx);
		return "Thông tin sản phẩm: \n" + "Tên sản phẩm: " + tenhang + "\n Mã hàng " + mahang + "\n đơn giá: "
				+ dongia + "\n Ngày sản xuất: " + str2 + "\n Hạn sử dụng: " + str1;
	}

	public void setNSX(int year, int month, int day) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month - 1, day);
		this.nsx = calendar.getTime();
	}

	public void setHHD(int year, int month, int day) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month - 1, day);
		this.hsd = calendar.getTime();
	}

	public boolean kiemTraTenHang(boolean k) {
		if (this.getTenhang() == " " || this.getTenhang().isEmpty()) {
			System.out.println("Không được để trống");
		} else {
			k = false;
		}
		return k;
	}

	public boolean kiemTraNgay(boolean t) {
		if (this.getNsx().compareTo(this.getHsd()) < 0) {
			t = false;
		} else {
			System.out.println(" Ngày hết hạn không được nhỏ hơn ngày sản xuất ");
		}
		return t;
	}

	public void kiemtraHSD() {
		Date today = new Date();
		today.getTime();
		SimpleDateFormat simDF = new SimpleDateFormat("dd/MM/yyyy");
		String str = simDF.format(today);
		if (getHsd().compareTo(today) < 0) {
			System.out.println("Hôm nay là ngày: " + str + " Hàng hoá đã hết hạn");
		} else {
			System.out.println("Hôm nay là ngày: " + str + "Hàng hoá còn hạn");
		}
	}

}
