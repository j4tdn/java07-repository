package bt2;

import java.util.Objects;

public class Card<T , R> {
	
	private T orderOfCard;
	private R typeOfCard;
	
	public Card() {
		// TODO Auto-generated constructor stub
	}
	public Card(R typeOfCard, T orderOfCard) {
		super();
		this.typeOfCard = typeOfCard;
		this.orderOfCard = orderOfCard;
	}
	public R getTypeOfCard() {
		return typeOfCard;
	}
	public void setTypeOfCard(R typeOfCard) {
		this.typeOfCard = typeOfCard;
	}
	public T getOrderOfCard() {
		return orderOfCard;
	}
	public void setOrderOfCard(T orderOfCard) {
		this.orderOfCard = orderOfCard;
	}
	@Override
	public String toString() {
		return orderOfCard + " " + typeOfCard;
	}
	
	@Override
	public boolean equals(Object o) {
		if(this==o) return true;
		if(o==null || o instanceof Card) return false;
		Card c= (Card) o;
		return c.getOrderOfCard().equals(getOrderOfCard()) &&c.getTypeOfCard().equals(getTypeOfCard());
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Objects.hash(getOrderOfCard(),getTypeOfCard());
	}
	
	

}
