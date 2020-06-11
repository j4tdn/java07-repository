package beans;

import java.util.Objects;

public class Apple {
	private String color;
	private String origin;
	private int weight;
	
	public Apple() {
		super();
	}
	
	public Apple(String color, String origin, int weight) {
		super();
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
		return a.getColor().equals(color) && a.getOrigin().equals(origin) && a.getWeight() == weight;
	}
	
	@Override
	public String toString() {
		return color + " " + origin + " " + weight;
	}
}
