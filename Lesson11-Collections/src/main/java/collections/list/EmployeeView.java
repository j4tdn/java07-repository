package collections.list;

import java.util.ArrayList;
import java.util.List;
import beans.Employee;
import common.Title;

public class EmployeeView {
	public static void main(String[] args) {
		List<Employee> employees = getEmployee();

		Employee newEmp = new Employee(5, "Gà", 15, Title.Dev);
		employees.add(employees.size() / 2, newEmp);

		employees.forEach(employee -> System.out.println(employee));
		System.out.println("=============================");

		Employee empById = getEmp(employees, 1);

		System.out.println(empById);
		System.out.println("=============================");
		employees.removeIf(emp -> emp.getAge() >= 60);
		employees.forEach(employee -> System.out.println(employee));
		System.out.println("=============================");

		Employee emp2 = new Employee(13, "Hoang Teo", 20, Title.President);
		employees.remove(emp2);
		employees.forEach(employee -> System.out.println(employee));
		System.out.println("=============================");
	}

	private static List<Employee> getEmployee() {
		List<Employee> emps = new ArrayList<>();
		Employee emp1 = new Employee(1, "Le Na", 60, Title.Dev);
		Employee emp2 = new Employee(13, "Hoang Teo", 20, Title.President);
		Employee emp3 = new Employee(22, "Van Nam", 30, Title.Dev);
		Employee emp4 = new Employee(9, "Ngoc Thanh", 19, Title.Assistant);
		Employee emp5 = new Employee(7, "Hoang Ka", 62, Title.Dev);

//		return Arrays.asList(emp1, emp2, emp3, emp4, emp5);
		emps.add(emp1);
		emps.add(emp2);
		emps.add(emp3);
		emps.add(emp4);
		emps.add(emp5);
		return emps;
	}

	private static Employee getEmp(List<Employee> emp, int id) {
		for (Employee i : emp) {
			if (i.getId() == id) {
				return i;
			}
		}
		return null;
	}
}