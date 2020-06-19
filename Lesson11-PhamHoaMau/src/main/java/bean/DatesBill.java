package bean;

public class DatesBill extends Bill {
	private int dates;

	public DatesBill() {
	}

	public DatesBill(int id, String date, String nameCustomer, int roomId, double unitPrice, int dates) {
		super(id, date, nameCustomer, roomId, unitPrice);
		this.dates = dates;
	}

	public int getDates() {
		return dates;
	}

	public void setDates(int hours) {
		this.dates = hours;
	}

	@Override
	public String toString() {
		return id + " " + date + " " + nameCustomer + " " + roomId + " " + unitPrice + " " + dates + " "
				+ getClass().getName().substring(5);
	}
	
	
}
