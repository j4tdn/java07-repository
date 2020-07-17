package JAVA07_Swing.swing_DEMO1;

public abstract class SanPham {
	private String masp;
	private String tensp;
	private float soluong;
	private float dongia;
	abstract float tinhtien();
	public SanPham(String masp, String tensp, float soluong, float dongia) {
		super();
		this.masp = masp;
		this.tensp = tensp;
		this.soluong = soluong;
		this.dongia = dongia;
	}
	public String getMasp() {
		return masp;
	}
	public void setMasp(String masp) {
		this.masp = masp;
	}
	public String getTensp() {
		return tensp;
	}
	public void setTensp(String tensp) {
		this.tensp = tensp;
	}
	public float getSoluong() {
		return soluong;
	}
	public void setSoluong(float soluong) {
		this.soluong = soluong;
	}
	public float getDongia() {
		return dongia;
	}
	public void setDongia(float dongia) {
		this.dongia = dongia;
	}
	
	public SanPham() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "SanPham  Mã Sản Phẩm: " + masp + " Tên Sản Phẩm: " + tensp + " Số Lượng: " + soluong + "  Đơn Giá" + dongia + "]";
	}
	
}
