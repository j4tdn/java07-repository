package beans;

import java.util.Objects;

public class Cards<T, O> {
	private T typeOfCard;
	private O orderOfCards;

	public Cards() {
	}

	public Cards(T typeOfCard, O orderOfCards) {
		super();
		this.typeOfCard = typeOfCard;
		this.orderOfCards = orderOfCards;
	}

	public T getTypeOfCard() {
		return typeOfCard;
	}

	public void setTypeOfCard(T typeOfCard) {
		this.typeOfCard = typeOfCard;
	}

	public O getOrderOfCards() {
		return orderOfCards;
	}

	public void setOrderOfCards(O orderOfCards) {
		this.orderOfCards = orderOfCards;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || obj instanceof Cards) {
			return false;
		}
		@SuppressWarnings("unchecked")
		Cards<T, O> c = (Cards<T, O>) obj;
		return c.getOrderOfCards().equals(getOrderOfCards()) && c.getTypeOfCard().equals(getTypeOfCard());
	}

	@Override
	public int hashCode() {
		return Objects.hash(typeOfCard, orderOfCards);
	}

	@Override
	public String toString() {
		return orderOfCards + " " + typeOfCard;
	}
}