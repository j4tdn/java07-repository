package bt.b1;

public class DailyBill extends Bill {
	private double days;
	public static final long UNITPRICE = 200;

	public DailyBill() {

	}

	public DailyBill(String id, String date, String name, String room, double days) {
		super(id, date, name, room);
		this.days = days;
		this.unitPrice = UNITPRICE;
	}

	public double getDays() {
		return days;
	}

	public void setDays(double days) {
		this.days = days;
	}

	@Override
	public String toString() {
		return super.toString() + ", days = " + days + ", total = " + total;
	}
}
