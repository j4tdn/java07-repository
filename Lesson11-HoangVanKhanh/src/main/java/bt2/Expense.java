package bt2;

import java.util.Objects;

public class Expense {
	private String expenseInformation;
	private int amount;

	public Expense() {
		// TODO Auto-generated constructor stub
	}

	public Expense(String expenseInformation, int amount) {
		super();
		this.expenseInformation = expenseInformation;
		this.amount = amount;
	}

	public String getExpenseInformation() {
		return expenseInformation;
	}

	public void setExpenseInformation(String expenseInformation) {
		this.expenseInformation = expenseInformation;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "expenseInformation :" + expenseInformation + " amount :" + amount;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || o instanceof Expense)
			return false;
		Expense e = (Expense) o;
		return e.getExpenseInformation().equals(getExpenseInformation()) && e.getAmount() == getAmount();
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Objects.hash(expenseInformation, amount);
	}

}
