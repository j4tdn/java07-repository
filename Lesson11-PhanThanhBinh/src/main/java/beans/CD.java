package beans;

import java.util.Objects;
import java.util.function.ObjLongConsumer;

public class CD {
	private String id;
	private String type;
	private String singer;
	private int count;
	private float price;
	public CD() {
		super();
	}
	public CD(String id, String type, String singer, int count, float price) {
		super();
		this.id = id;
		this.type = type;
		this.singer = singer;
		this.count = count;
		this.price = price;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || !(obj instanceof CD)) {
			return false;
		}
		CD c = (CD) obj;
		return c.getId().equals(getId());
	}
	@Override
	public String toString() {
		return id + " " + type + " " + singer + " " + count + " " + price;
	}
	
}
