package date01;

import java.time.LocalDateTime;

public class BillByDay extends Bill {
	private int day;

	public BillByDay() {
	}

	public BillByDay(String id, String date, String fullName, String roomId, Integer price, int day) {
		super(id,date,fullName,roomId,price);
		this.day = day;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	@Override
	public String toString() {
		return super.toString() + " - " + day;
	}

}
