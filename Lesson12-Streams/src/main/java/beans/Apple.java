package beans;

import java.util.Objects;

public class Apple {
	private String color;
	private int weight;
	private String origin;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public Apple() {
	}

	public Apple(String color, int weight, String origin) {
		this.color = color;
		this.weight = weight;
		this.origin = origin;
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
		return a.getColor().equals(getColor()) && a.getOrigin().equals(getOrigin()) && a.getWeight() == getWeight();
	}

	@Override
	public String toString() {
		return color + "," + origin + " ," + weight;
	}

}
