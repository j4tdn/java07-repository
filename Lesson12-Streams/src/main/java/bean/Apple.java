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
		this.color = color;
	}

	public Apple(String color, String origin, int weight) {
		this.color = color;
		this.origin = origin;
		this.weight = weight;
	}

	public int hashCode() {
		return Objects.hash(origin, color, weight);
	}

	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(obj == null || obj instanceof Apple)  {
			return false;
		}
		Apple a = (Apple) obj;
		return color.equals(a.getColor()) && origin.equals(a.getOrigin()) && weight == a.getWeight();
	}

	@Override
	public String toString() {
		return "origin=" + origin + ", color=" + color + ", weight=" + weight;
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
}
