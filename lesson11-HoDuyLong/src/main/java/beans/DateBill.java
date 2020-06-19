package beans;

public class DateBill extends CommonBill {
	private float days;

	public DateBill() {

	}

	public DateBill(String id, String date, String customerName, String idRoom, float price) {
		this(id, date, customerName, idRoom, price, 0);
	}

	public DateBill(String id, String date, String customerName, String idRoom, float price, float days) {
		super(id, date, customerName, idRoom, price);
		this.days = days;
	}

	public float getDays() {
		return days;
	}

	public void setDays(float days) {
		this.days = days;
	}

	@Override
	public String toString() {
		return super.toString() + ", " + days + ", " + total();
	}

	public float total() {
		if (days > 7) {
			return 7 * price + (days - 7) * price * 0.8f;
		}
		return days * price;
	}
}
