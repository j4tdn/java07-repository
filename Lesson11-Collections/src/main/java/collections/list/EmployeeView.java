package collections.list;

//import 1 luc nhieu thu vien: ctrl+shift+o
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import beans.Employee;
import common.Title;

public class EmployeeView {
	public static void main(String[] args) {
		List<Employee> emps = getEmployee();

		Employee newEmp = new Employee(26, "Hai Sau", 26, Title.Dev);
		emps.add(newEmp);
		// emps.add(emps.size()/2, newEmp);

		emps.forEach(emp -> System.out.println(emp));

		System.out.println("============================");
		Employee empById = getEmployee(emps, 7);
		System.out.println("EmpById: " + empById);

		System.out.println("============================");
		emps.removeIf(emp -> emp.getAge() > 65);
		emps.forEach(emp -> System.out.println(emp));

		System.out.println("============================");
		emps.remove(newEmp);
		emps.forEach(emp -> System.out.println(emp));
		
		System.out.println("============================");
		Employee emp2=new Employee(13, "Hoang Teo", 20, Title.President);
		//emps.remove(emp2);
		//emps.forEach(emp -> System.out.println(emp));
		System.out.println(emps.contains(emp2));
	}

	private static List<Employee> getEmployee() {
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

		// fixed-size
		// return Arrays.asList(emp1,emp2,emp3,emp4,emp5);
		return emps;
	}

	private static Employee getEmployee(List<Employee> emps, int id) {
		for (Employee emp : emps) {
			if (id == emp.getId()) {
				return emp;
			}
		}
		return null;
	}
}
