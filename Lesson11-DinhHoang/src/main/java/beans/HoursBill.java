package beans;

public class HoursBill extends Bill {
	private int hour;

	public HoursBill() {
		super();
	}

	public HoursBill(String codeBill, String date, String fullName, String roomCode, int unitPrice, int hour) {
		super(codeBill, date, fullName, roomCode, unitPrice);
		this.hour = hour;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	@Override
	public void pay() {
		if (hour < 24) {
			setPrice(getUnitPrice() * hour);
		} else if (hour >= 24 && hour < 30) {
			setPrice(getUnitPrice() * 24);
		}
	}

	@Override
	public String toString() {
		return super.toString() + "|- Số giờ        : " + hour + "\n" + 
								  "|- Thành tiền    : " + getPrice();
	}
}