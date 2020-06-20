package beans;

import java.util.Objects;

public class Card {
	private String number;
	private String attribute;

	public Card() {
		super();
	}

	public Card(String number, String attribute) {
		super();
		this.number = number;
		this.attribute = attribute;
	}

	public String getNumber() {
		return number;
	}

	public void setNumbers(String numbers) {
		this.number = numbers;
	}

	public String getAttribute() {
		return attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	@Override
	public int hashCode() {
		return Objects.hash(number, attribute);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || !(obj instanceof Card)) {
			return false;
		}
		Card c = (Card) obj;
		return c.getNumber().equals(getNumber()) && c.getAttribute().equals(getAttribute());
	}

	@Override
	public String toString() {
		return number + " " + attribute;
	}

}
