package beans;

public class CommonBill {
	protected String id;
	protected String date;
	protected String customerName;
	protected String idRoom;
	protected float price;

	public CommonBill() {

	}

	public CommonBill(String id, String date, String customerName, String idRoom, float price) {
		this.id = id;
		this.date = date;
		this.customerName = customerName;
		this.idRoom = idRoom;
		this.price = price;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
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
	public String toString() {
		return id + ", " + date + ", " + customerName + ", " + idRoom + ", " + price;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || !(obj instanceof CommonBill)) {
			return false;
		}
		CommonBill that = (CommonBill) obj;
		return this.getId().equals(that.getId());
	}
}
