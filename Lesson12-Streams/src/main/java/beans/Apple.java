package beans;

import java.util.Objects;

public class Apple {
	private String color;
	private String origin;
	private int weight;
	private Store store;

	public Apple() {
	}

	public Apple(String color) {
		this.color = color;
	}

	public Apple(String color, String origin, int weight) {
		this.color = color;
		this.origin = origin;
		this.weight = weight;
	}
	
	public Apple(String color, String origin, int weight, Store store) {
		this.color = color;
		this.origin = origin;
		this.weight = weight;
		this.store = store;
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

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || obj instanceof Apple) {
			return false;
		}
		Apple a = (Apple) obj;
		return a.getColor().equals(getColor()) && a.getOrigin().equals(getOrigin()) && a.getWeight() == getWeight();
	}

	@Override
	public int hashCode() {
		return Objects.hash(color, origin, weight);
	}

	@Override
	public String toString() {
		return "+ " + origin + ", " + color + ", " + weight + "g, " + store;
	}
}