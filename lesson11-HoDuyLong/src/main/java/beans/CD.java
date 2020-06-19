package beans;

import java.util.Objects;

public class CD {
	private int id;
	private String type;
	private String singer;
	private int numberOfSongs;
	private float price;

	public CD() {

	}

	public CD(int id, String type, String singer, int numberOfSongs, float price) {
		this.id = id;
		this.type = type;
		this.singer = singer;
		this.numberOfSongs = numberOfSongs;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public int getNumberOfSongs() {
		return numberOfSongs;
	}

	public void setNumberOfSongs(int numberOfSongs) {
		this.numberOfSongs = numberOfSongs;
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
		CD that = (CD) obj;
		return this.getId() == that.getId();
	}

	@Override
	public String toString() {
		return id + ", " + type + ", " + singer + ", " + numberOfSongs + ", " + price;
	}
}
