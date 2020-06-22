package beans;

import java.util.Objects;

public class Expense {
	private String expenditures;
	private int amountOfMon;

	public Expense() {
	}

	public Expense(String expenditures, int amountOfMon) {
		this.expenditures = expenditures;
		this.amountOfMon = amountOfMon;
	}

	public String getExpenditures() {
		return expenditures;
	}

	public void setExpenditures(String expenditures) {
		this.expenditures = expenditures;
	}

	public int getAmountOfMon() {
		return amountOfMon;
	}

	public void setAmountOfMon(int amountOfMon) {
		this.amountOfMon = amountOfMon;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || obj instanceof Expense) {
			return false;
		}
		Expense e = (Expense) obj;
		return e.getExpenditures().equals(getExpenditures()) && e.getAmountOfMon() == getAmountOfMon();
	}

	@Override
	public int hashCode() {
		return Objects.hash(expenditures, amountOfMon);
	}

	@Override
	public String toString() {
		return "- " + expenditures + ": " + amountOfMon + " nghìn VNĐ";
	}
}