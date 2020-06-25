package bt1;

import java.util.Objects;

public class Bill {
	protected String id;
	protected String date;
	protected String name;
	protected String room;
	protected double unitPrice;
	protected double total;

	public Bill() {

	}

	public Bill(String id, String date, String name, String room) {
		super();
		this.id = id;
		this.date = date;
		this.name = name;
		this.room = room;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, date, name, room);
	}

	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || !(o instanceof Bill)) {
			return false;
		}
		Bill s = (Bill) o;
		return s.getId().equals(getId()) && s.getDate().equals(getDate()) && s.getName().equals(getName())
				&& s.getRoom().equals(getRoom());
	}

	@Override
	public String toString() {
		return "id=" + id + ", date=" + date + ", name=" + name + ", room=" + room + ", unitPrice=" + unitPrice;
	}

}
