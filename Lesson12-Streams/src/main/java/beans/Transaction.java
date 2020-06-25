package beans;

import java.util.Objects;

public class Transaction {
	private Trader trader;
	private int year;
	private int value;

	public Transaction() {
	}

	public Transaction(Trader trader, int year, int value) {
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
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || obj instanceof Transaction) {
			return false;
		}
		Transaction t = (Transaction) obj;
		return t.getTrader().equals(getTrader()) && t.getYear() == getYear() && t.getValue() == getValue();
	}

	@Override
	public int hashCode() {
		return Objects.hash(year, value);
	}

	@Override
	public String toString() {
		return "Year: " + year + "\nValue: " + value;
	}
}
