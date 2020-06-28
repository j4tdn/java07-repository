package beans;

public class Bill {

	private String id;
	private String date;
	private String fullName;
	private String idRoom;
	private int unitPrice;
	private float Cost;

	public float getCost() {
		return Cost;
	}

	public void setCost(float cost) {
		Cost = cost;
	}

	public Bill() {
		// TODO Auto-generated constructor stub
	}

	public Bill(String id, String date, String fullName, String idRoom, int unitPrice) {
		super();
		this.id = id;
		this.date = date;
		this.fullName = fullName;
		this.idRoom = idRoom;
		this.unitPrice = unitPrice;
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

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getIdRoom() {
		return idRoom;
	}

	public void setIdRoom(String idRoom) {
		this.idRoom = idRoom;
	}

	public int getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}

	public void pay() {

	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public String toString() {
		return "Bill [id=" + id + ", date=" + date + ", fullName=" + fullName + ", idRoom=" + idRoom + ", unitPrice="
				+ unitPrice + ", Cost=" + Cost + "]";
	}

}
