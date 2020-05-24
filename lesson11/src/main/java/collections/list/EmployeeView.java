package collections.list;

import java.util.ArrayList;
import java.util.List;

import bin.Employee;
import common.Title;

public class EmployeeView {
	public static void main(String[] args) {

		List<Employee> employees = getEmployee();
		Employee newEmp = new Employee(1, "trung phan", 22, Title.Dev);
		System.out.println("=====================");
		employees.add(employees.size() / 2, newEmp);
		employees.add(newEmp);
		employees.forEach(employee -> System.out.println(employee + " "));
		System.out.println("======================");
		Employee emById = getEmp(employees, 7);
		System.out.println(emById);
		System.out.println("=============");
		employees.removeIf(employee -> employee.getAge() > 65);
		employees.forEach(employee -> System.out.println(employee + " "));
	}

	public static List<Employee> getEmployee() {
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

	private static Employee getEmp(List<Employee> emps, int id) {
		for (Employee emp : emps) {
			if (id == emp.getId()) {
				return emp;

			}
		}
		return null;
	}

}
