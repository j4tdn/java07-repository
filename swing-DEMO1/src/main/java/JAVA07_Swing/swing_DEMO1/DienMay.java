package JAVA07_Swing.swing_DEMO1;

public class DienMay extends SanPham {
	public DienMay(String masp, String tensp, float soluong, float dongia) {
		super(masp, tensp, soluong, dongia);
	}
	@Override
	float tinhtien() {
		float tt = (float) (getSoluong() * getSoluong() * (1 - 0.1));
		return tt;
	}
}
