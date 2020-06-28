package beans;

public class HoursBill extends Bill {
	private int hours;

	public HoursBill() {
		// TODO Auto-generated constructor stub
	}

	public HoursBill(String id, String date, String fullName, String idRoom, int unitPrice, int hours) {
		super(id, date, fullName, idRoom, unitPrice);
		// TODO Auto-generated constructor stub
		this.hours = hours;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	@Override
	public void pay() {
		if (getHours() <= 24) {
			setCost(getHours() * getUnitPrice());

		} else if (getHours() > 24 && getHours() < 30) {
			setCost(24 * getUnitPrice());
		} else {
			System.out.println("vi so gio lon hon 30 nen ko dung loai hoa don nay ");
		}
	}

	@Override
	public String toString() {
		return super.toString() + "HoursBill [hours=" + hours + "]";
	}
}
