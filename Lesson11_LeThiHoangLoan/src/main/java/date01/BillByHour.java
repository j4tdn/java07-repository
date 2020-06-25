package date01;

import java.time.LocalDateTime;

public class BillByHour extends Bill {
	private int hour;

	public BillByHour() {

	}

	public BillByHour(String id, String date, String fullName, String roomId, Integer price, int hour) {
		super(id, date, fullName, roomId, price);
		this.hour = hour;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	@Override
	public String toString() {
		return super.toString() + " - " + hour;
	}

}
