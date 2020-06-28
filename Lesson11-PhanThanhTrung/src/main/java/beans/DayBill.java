package beans;

public class DayBill extends Bill{
private int numDay;
private float sale=0.8f;
public DayBill() {
	// TODO Auto-generated constructor stub
}
public DayBill(String id, String date, String fullName, String idRoom, int unitPrice,int numDay) {
	super(id, date, fullName, idRoom, unitPrice);
	this.numDay=numDay;
}
public int getNumDay() {
	return numDay;
}
public void setNumDay(int numDay) {
	this.numDay = numDay;
}

@Override
	public void pay() {
		if(getNumDay()<=7) {
			setCost(getNumDay()*getUnitPrice());
		}else {
			setCost(getUnitPrice()*7+(getNumDay()-7)*getUnitPrice()*sale);
		}
	}

@Override
public String toString() {
	return super.toString()+ "DayBill [numDay=" + numDay + "]";
}
}
