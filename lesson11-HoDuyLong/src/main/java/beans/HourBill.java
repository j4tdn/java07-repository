package beans;

public class HourBill extends CommonBill {
	private float hours;

	public HourBill() {

	}

	public HourBill(String id, String date, String customerName, String idRoom, float price) {
		this(id, date, customerName, idRoom, price, 0);
	}

	public HourBill(String id, String date, String customerName, String idRoom, float price, float hours) {
		super(id, date, customerName, idRoom, price);
		this.hours = hours;
	}

	public float getHours() {
		return hours;
	}

	public void setHours(float hours) {
		this.hours = hours;
	}

	@Override
	public String toString() {
		return super.toString() + ", " + hours + ", " + total();
	}

	public float total() {
		float total = 0;
		if (hours < 24) {
			total = hours * price;
		} else if (hours >= 24 && hours <= 30) {
			total = 24 * price;
		}
		return total;
	}
}
