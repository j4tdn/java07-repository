package collections.list;

import java.util.ArrayList;
import java.util.List;

import beans.Employee;
import comon.Title;

public class EmplyeeView {
	public static void main(String[] args) {
		List<Employee> emps = getEmplyee();

		Employee newEmp = new Employee(26, "Hoang Ba", 26, Title.Assistant);

		emps.add(newEmp);

		emps.forEach(emp -> System.out.println(emp));
		System.out.println("================================");

//		Employee empById = getEmp(emps, 7);
//	System.out.println("EmpById: " + empById);

		emps.removeIf(emp -> emp.getAge() > 65);
	}

	private static List<Employee> getEmplyee() {
		List<Employee> emps = new ArrayList<>();
		Employee emp1 = new Employee(1, "Le Na", 70, Title.Dev);
		Employee emp2 = new Employee(13, "Hoang Teo", 20, Title.President);
		Employee emp3 = new Employee(22, "Van Nam", 30, Title.Dev);
		Employee emp4 = new Employee(9, "Ngoc Thanh", 19, Title.Assistant);
		Employee emp5 = new Employee(7, "Hoang Ka", 92, Title.Dev);

		emps.add(emp1);
		emps.add(emp2);
		emps.add(emp3);
		emps.add(emp4);
		emps.add(emp5);

		return emps;
	}

	/*
	 * private static Employee getEmp(List<Employee> emp, int id) { for(Employee
	 * emp:emps) { if(id==emp) { return } } }
	 */

}
