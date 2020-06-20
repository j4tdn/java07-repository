package bt02;

import java.util.Date;

public class Bill {
	public Integer billCode;
	public Date billDate;
	public String name;
	public String roomCode;
	public float price;
	
	private void Bill() {
		// TODO Auto-generated method stub

	}
	public Bill(Integer billCode, Date billDate, String name, String roomCode, float price) {
		super();
		this.billCode = billCode;
		this.billDate = billDate;
		this.name = name;
		this.roomCode = roomCode;
		this.price = price;
	}
	public Integer getBillCode() {
		return billCode;
	}
	public void setBillCode(Integer billCode) {
		this.billCode = billCode;
	}
	public Date getBillDate() {
		return billDate;
	}
	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRoomCode() {
		return roomCode;
	}
	public void setRoomCode(String roomCode) {
		this.roomCode = roomCode;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	
	
	

}
