package beans;

import java.util.Objects;

public class Apple {
	private String color;
	private String origin;
	private int weight;
	private Store store;

	public Apple() {
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return color + "," + weight + "," + origin;
	}

	public Apple(String color) {
		System.out.println("123Apple");
		this.color = color;
	}

	public Apple(String color, String origin, int weight) {
		super();
		this.color = color;
		this.origin = origin;
		this.weight = weight;
		
	}
	public Apple(String color, String origin, int weight,Store store) {
		super();
		this.color = color;
		this.origin = origin;
		this.weight = weight;
		this.store = store;
	}
	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	@Override
	public int hashCode() {
		return Objects.hash(color, origin, weight);
	}

	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || !(o instanceof Apple)) {
			return false;
		}
		Apple a = (Apple) o;
		return a.getColor().equals(a.getColor()) && a.getOrigin().equals(a.getOrigin()) && a.getWeight() == getWeight();
	}


}
