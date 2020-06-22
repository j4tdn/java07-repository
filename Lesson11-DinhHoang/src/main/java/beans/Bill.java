package beans;

import java.util.Objects;

public class Bill {
	private String codeBill;
	private String date;
	private String fullName;
	private String roomCode;
	private int unitPrice;
	private float price;

	public Bill() {
	}

	public Bill(String codeBill, String date, String fullName, String roomCode, int unitPrice) {
		this.codeBill = codeBill;
		this.date = date;
		this.fullName = fullName;
		this.roomCode = roomCode;
		this.unitPrice = unitPrice;
	}

	public String getCodeBill() {
		return codeBill;
	}

	public void setCodeBill(String codeBill) {
		this.codeBill = codeBill;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getRoomCode() {
		return roomCode;
	}

	public void setRoomCode(String roomCode) {
		this.roomCode = roomCode;
	}

	public int getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public void pay() {
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || obj instanceof Bill) {
			return false;
		}
		Bill b = (Bill) obj;
		return b.getCodeBill().equals(getCodeBill()) && b.getDate().equals(getDate())
				&& b.getFullName().equals(getFullName()) && b.getRoomCode().equals(getRoomCode())
				&& b.getUnitPrice() == getUnitPrice() ;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codeBill, date, fullName, roomCode, unitPrice);
	}

	@Override
	public String toString() {
		return     "|- Mã hóa đơn    : " + codeBill + "\n" + 
				   "|- Ngày hóa đơn  : " + date + "\n" +
				   "|- Tên khách hàng: " + fullName + "\n" +
				   "|- Mã phòng      : " + roomCode + "\n" +
				   "|- Đơn giá       : " + unitPrice + "\n";
	}
}
