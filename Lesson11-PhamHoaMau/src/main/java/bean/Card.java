package bean;

public class Card {
	private String Type;
	private Integer Value;
	public Card() {
	}
	
	@Override
	public String toString() {
		return Value + " " + Type + " ";
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		this.Type = type;
	}
	public Integer getValue() {
		return Value;
	}
	public void setValue(Integer value) {
		Value = value;
	}
	public Card(String type, Integer value) {
		this.Type = type;
		this.Value = value;
	}
	
	
}
