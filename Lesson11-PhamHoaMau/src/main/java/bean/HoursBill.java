package bean;

public class HoursBill extends Bill {
	private int hours;

	public HoursBill(int id, String date, String nameCustomer, int roomId, double unitPrice, int hours) {
		super(id, date, nameCustomer, roomId, unitPrice);
		this.hours = hours;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	@Override
	public String toString() {
		return id + " " + date + " " + nameCustomer + " " + roomId + " " + unitPrice + " " + hours + " "
				+ getClass().getName().substring(5);
	}

}
