package beans;

public class Transaction {
	
	private Trader trader;
	private int year;
	private int value;
	
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Transaction(Trader trader, int year, int value) {
		super();
		this.trader = trader;
		this.year = year;
		this.value = value;
	}

	public Trader getTrader() {
		return trader;
	}

	public void setTrader(Trader trader) {
		this.trader = trader;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((trader == null) ? 0 : trader.hashCode());
		result = prime * result + value;
		result = prime * result + year;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || !(obj instanceof Transaction))
			return false;
		
		Transaction t = (Transaction) obj;
		return t.getTrader().equals(trader) && t.getYear() == year && t.getValue() == value;
	}
	
	@Override
	public String toString() {
 		return this.getTrader() +", " + this.getYear()  + " " + this.getValue();
	}

}
