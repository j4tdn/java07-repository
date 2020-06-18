package bean;

public class Bill {
	protected int id;
	protected String date;
	protected String nameCustomer;
	protected int roomId;
	protected double unitPrice;

	
	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof Bill)) {
			return false;
		}
		else {
			if(getId() == ((Bill)obj).getId()) {
				return true;
			}
		}
		return false;
	}

	public Bill(int id, String date, String nameCustomer, int roomId, double unitPrice) {
		this.id = id;
		this.date = date;
		this.nameCustomer = nameCustomer;
		this.roomId = roomId;
		this.unitPrice = unitPrice;
	}

	public Bill() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getNameCustomer() {
		return nameCustomer;
	}

	public void setNameCustomer(String nameCustomer) {
		this.nameCustomer = nameCustomer;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

}
