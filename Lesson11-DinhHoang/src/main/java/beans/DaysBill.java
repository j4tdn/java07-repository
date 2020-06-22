package beans;

public class DaysBill extends Bill {
	private int day;
	private float promotion = 0.8f;

	public DaysBill() {
	}

	public DaysBill(String codeBill, String date, String fullName, String roomCode, int unitPrice, int day) {
		super(codeBill, date, fullName, roomCode, unitPrice);
		this.day = day;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	@Override
	public void pay() {
		if (day <= 7) {
			setPrice(getUnitPrice() * day);
		} else {
			int daysLeft = day - 7;
			setPrice(getUnitPrice() * 7 + getUnitPrice() * daysLeft * promotion);
		}
	}

	@Override
	public String toString() {
		return super.toString() + "|- Số ngày       : " + day + "\n" + 
								  "|- Thành tiền    : " + getPrice();
	}
}