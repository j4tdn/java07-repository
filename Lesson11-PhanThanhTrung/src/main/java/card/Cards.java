
package card;

public class Cards {
private String typeCard;
private String numCard;

public Cards() {
	// TODO Auto-generated constructor stub
}

public Cards(String typeCard, String numCard) {
	super();
	this.typeCard = typeCard;
	this.numCard = numCard;
}

public String getTypeCard() {
	return typeCard;
}

public void setTypeCard(String typeCard) {
	this.typeCard = typeCard;
}

public String getNumCard() {
	return numCard;
}

public void setNumCard(String numCard) {
	this.numCard = numCard;
}
@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

@Override
public String toString() {
	return numCard+" "+typeCard+", ";
}


}
