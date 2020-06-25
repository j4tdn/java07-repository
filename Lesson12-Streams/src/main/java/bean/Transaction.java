package bean;

import java.util.Objects;

public class Transaction {
	private Trader trade;
	private int year;
	private int value;
	
	public Transaction() {
	}

	public Transaction(Trader trade, int year, int value) {
		this.trade = trade;
		this.year = year;
		this.value = value;
	}

	public Trader getTrade() {
		return trade;
	}

	public void setTrade(Trader trade) {
		this.trade = trade;
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
	public String toString() {
		return trade+", "+year+", "+value;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}

		if (o == null || !(o instanceof Transaction)) {
			return false;
		}
		Transaction transation =(Transaction) o;
		return transation.getValue()==getValue() && transation.getYear()==getYear() && transation.getTrade().equals(getTrade());
	}
	@Override
	public int hashCode() {

		return Objects.hash(trade,year,value);
	}
	
	
	
	
}
