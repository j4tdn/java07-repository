package beans;

public class BillOfDay extends Bill{
	private int day;

	public BillOfDay() {
		super();
	}

	public BillOfDay(String idBill, String date, String nameCus, String idRoom, float price,int day) {
		super(idBill, date, nameCus, idRoom, price);
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
		return super.toString() + " " + day;
	}
}
