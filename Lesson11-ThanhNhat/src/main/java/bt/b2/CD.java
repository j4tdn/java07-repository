package bt.b2;

import java.util.Objects;

public class CD {
	private int id;
	private String type;
	private String singer;
	private int songs;
	private Double price;

	public CD() {

	}

	public CD(int id, String type, String singer, int songs, Double price) {
		super();
		this.id = id;
		this.type = type;
		this.singer = singer;
		this.songs = songs;
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

	public int getSongs() {
		return songs;
	}

	public void setSongs(int songs) {
		this.songs = songs;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || !(o instanceof CD)) {
			return false;
		}
		CD s = (CD) o;
		return s.getId() == getId();
	}

	@Override
	public String toString() {
		return "CD [id=" + id + ", type=" + type + ", singer=" + singer + ", songs=" + songs + ", price=" + price + "]";
	}
}
