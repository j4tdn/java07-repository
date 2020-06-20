package bt02;

import java.util.Date;

public class BillByDate extends Bill{
	private int date;
	public BillByDate(Integer billCode, Date billDate, String name, String roomCode, float price) {
		super(billCode, billDate, name, roomCode, price);
		// TODO Auto-generated constructor stub
	}
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	

}
