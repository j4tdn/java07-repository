package date02;

import java.util.Objects;

import date01.Student;

public class DishCD {
	private Integer id;
	private String type;
	private String singer;
	private int number;
	private Float price;

	public DishCD() {

	}

	public DishCD(Integer id, String type, String singer, int number, float price) {
		this.id = id;
		this.type = type;
		this.singer = singer;
		if (number > 0) {
			this.number = number;
		}
		if (price > 0) {
			this.price = price;
		}
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || !(o instanceof DishCD)) {
			return false;
		}
		DishCD d = (DishCD) o;
		return !d.getId().equals(getId());
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public String toString() {
		return id + "-" + type + "-" + singer + "-" + number + "-" + price;
	}

}
