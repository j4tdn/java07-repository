package bt.b1;

public class HourlyBill extends Bill {
	private double hours;
	public static final long UNITPRICE = 10;

	public HourlyBill() {

	}

	public HourlyBill(String id, String date, String name, String room, double hours) {
		super(id, date, name, room);
		this.hours = hours;
		this.unitPrice = UNITPRICE;
	}

	public double getHours() {
		return hours;
	}

	public void setHours(double hours) {
		this.hours = hours;
	}

	@Override
	public String toString() {
		return super.toString() + ", hours = " + hours + ", total = " + total;
	}
}
