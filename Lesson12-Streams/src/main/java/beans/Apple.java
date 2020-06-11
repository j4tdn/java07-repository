package beans;

import java.util.Objects;

public class Apple {
	private String color;
	private int weigth;
	private String origin;

	public Apple() {
		// TODO Auto-generated constructor stub
	}

	public Apple(String color, int weigth, String origin) {
		super();
		this.color = color;
		this.weigth = weigth;
		this.origin = origin;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getWeigth() {
		return weigth;
	}

	public void setWeigth(int weigth) {
		this.weigth = weigth;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	@Override
	public int hashCode() {

		return Objects.hash(color, origin, weigth);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || (o instanceof Apple)) {
			return false;
		}
		Apple a = (Apple) o;
		return a.getColor().equals(getColor()) && a.getOrigin().equals(getOrigin()) && a.getWeigth() == getWeigth();
	}

	@Override
	public String toString() {
		return "color :" + color + " ," + "weigth :" + weigth + " ," + "origin :" + origin;
	}

}
