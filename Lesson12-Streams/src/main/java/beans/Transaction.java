package beans;

import java.util.Objects;

public class Transaction {
	private Trader trader;
	private int year;
	private int value;
	public Transaction() {
		super();
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
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		return other.getTrader().equals(getTrader()) && other.getYear() == getYear() && other.getValue() == getValue();
	}
	@Override
	public String toString() {
		return trader + " "  + year + " " + value;
	}
}
