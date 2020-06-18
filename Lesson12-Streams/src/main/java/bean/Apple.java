package bean;

import java.util.Objects;

public class Apple {
	private String color;
	private String origin;
	private int weight;

	public Apple() {
		System.out.println("Default constructor");
	}
	public Apple(String color) {
		System.out.println("Apple 1 parameter");
		this.color=color;
	}

	public Apple(String color, String origin, int weight) {
		this.color = color;
		this.origin = origin;
		this.weight = weight;
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
	public int hashCode() {
		return Objects.hash(color, origin, weight);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}

		if (o == null || !(o instanceof Apple)) {
			return false;
		}
		Apple a = (Apple) o;
		return a.getColor().equals(getColor()) && a.getOrigin().equals(getOrigin()) && a.weight == getWeight();
	}

	@Override
	public String toString() {
		return origin + ", " + color + ", " + weight;
	}

}
