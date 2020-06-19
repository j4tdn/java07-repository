package beans;

import java.util.Objects;

public class Bill {
	private String idBill;
	private String date;
	private String nameCus;
	private	String idRoom;
	private float price;
	public Bill() {
		super();
	}
	public Bill(String idBill, String date, String nameCus, String idRoom, float price) {
		super();
		this.idBill = idBill;
		this.date = date;
		this.nameCus = nameCus;
		this.idRoom = idRoom;
		this.price = price;
	}
	public String getIdBill() {
		return idBill;
	}
	public void setIdBill(String idBill) {
		this.idBill = idBill;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getNameCus() {
		return nameCus;
	}
	public void setNameCus(String nameCus) {
		this.nameCus = nameCus;
	}
	public String getIdRoom() {
		return idRoom;
	}
	public void setIdRoom(String idRoom) {
		this.idRoom = idRoom;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	@Override
	public int hashCode() {
		return Objects.hash(idBill, date, nameCus, idRoom, price);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || !(obj instanceof Bill)) {
			return false;
		}
		Bill bill = (Bill) obj;
		return bill.getIdBill().equals(getIdBill()) && bill.getDate().equals(getDate())
				&& bill.getNameCus().equals(getNameCus()) && bill.getIdRoom().equals(getIdRoom())
				&& bill.getPrice() == (getPrice());
	}
	@Override
	public String toString() {
		return idBill + " " + date + " " + nameCus + " " + idRoom + " " + price;
	}
	
}
