package beans;

import java.util.Objects;

public class Transaction {
	private Trader trader;
	private int year;
	private int value;

	public Transaction() {

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
		return Objects.hash(trader, year, value);
	}

	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || !(o instanceof Transaction)) {
			return false;
		}
		Transaction s = (Transaction) o;
		return s.getTrader().equals(getTrader()) && s.getYear() == (getYear()) && s.getValue() == (getValue());
	}

	@Override
	public String toString() {
		return "Transaction [trader=" + trader + ", year=" + year + ", value=" + value + "]";
	}

}
