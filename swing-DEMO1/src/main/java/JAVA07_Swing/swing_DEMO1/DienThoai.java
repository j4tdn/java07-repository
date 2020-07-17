package JAVA07_Swing.swing_DEMO1;

public class DienThoai extends SanPham {
	public DienThoai(String masp, String tensp, float soluong, float dongia) {
		super(masp, tensp, soluong, dongia);
	}

	@Override
	float tinhtien() {
		float tt = (float) (getSoluong() * getDongia() * (1 - 0.2));
		return tt;
	}

}
