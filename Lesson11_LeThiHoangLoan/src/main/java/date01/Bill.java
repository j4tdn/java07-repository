package date01;

import java.time.LocalDateTime;
import java.util.Objects;

public class Bill {
	private String id;
	private String date;
	private String fullName;
	private String roomId;
	private int price;

	public Bill() {
	}

	public Bill(String id, String date, String fullName, String roomId, Integer price) {
		this.id = id;
		this.date = date;
		this.fullName = fullName;
		this.roomId = roomId;
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

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || !(o instanceof Bill)) {
			return false;
		}
		Bill s = (Bill) o;
		return s.getId().equals(getId());
	}

	public String toString() {
		return id + " : " + date + " - " + fullName + "  -  " + roomId + "  -  " + price;
	}

}
