package beans;

public class BillOfHours extends Bill{
	private int hours;

	public BillOfHours() {
		super();
	}

	public BillOfHours(String idBill, String date, String nameCus, String idRoom, float price,int hours) {
		super(idBill, date, nameCus, idRoom, price);
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
		return super.toString() + " " + hours;
	}
}
