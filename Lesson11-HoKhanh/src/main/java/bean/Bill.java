package bean;

import java.util.Objects;

public class Bill {
	protected String codeBill;
	protected String dateBill;
	protected String fullname;
	protected String codeRoom;
	protected int price;

	public Bill() {
	}

	public Bill(String codeBill, String dateBill, String fullname, String codeRoom, int price) {
		this.codeBill = codeBill;
		this.dateBill = dateBill;
		this.fullname = fullname;
		this.codeRoom = codeRoom;
		this.price = price;
	}

	public String getCodeBill() {
		return codeBill;
	}

	public void setCodeBill(String codeBill) {
		this.codeBill = codeBill;
	}

	public String getDateBill() {
		return dateBill;
	}

	public void setDateBill(String dateBill) {
		this.dateBill = dateBill;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getCodeRoom() {
		return codeRoom;
	}

	public void setCodeRoom(String codeRoom) {
		this.codeRoom = codeRoom;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public int hashCode() {
		return Objects.hash();
	}

}
