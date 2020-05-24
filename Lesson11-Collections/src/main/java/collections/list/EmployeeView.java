package collections.list;

import java.util.ArrayList;
import java.util.List;

import beans.Employee;
import common.Title;

public class EmployeeView {
	public static void main(String[] args) {
		List<Employee> emps = getEmployees();
		addEmployee(emps);
		showEmployees(emps);
		getEmp(emps, 7);
		emps = delEmp(emps);	
		showEmployees(emps);
	}

	private static List<Employee> delEmp(List<Employee> emps) {
		Employee emp2 = new Employee(13, "Hoang Teo", 20, Title.President);
		emps.removeIf(emp -> emp.getAge() > 65);
		emps.contains(emp2);
		return emps;
	}

	private static Employee getEmp(List<Employee> emps, int id) {
		System.out.println("====get employee====");
		for (Employee employee : emps) {
			if (employee.getId() == id) {
				System.out.println(employee);
				return employee;
			}
		}
		return null;
	}

	private static void showEmployees(List<Employee> emps) {
		System.out.println("=====all employess====");
		emps.forEach(emp -> System.out.println(emp));
	}

	private static void addEmployee(List<Employee> emps) {
		Employee newEmp = new Employee(25, "Le A", 71, Title.Dev);
		emps.add(newEmp);
	}

	private static List<Employee> getEmployees() {
		List<Employee> emps = new ArrayList<>();
		Employee emp1 = new Employee(1, "Le Na", 70, Title.Dev);
		Employee emp2 = new Employee(13, "Hoang Teo", 20, Title.President);
		Employee emp3 = new Employee(22, "Van Nam", 30, Title.Dev);
		Employee emp4 = new Employee(9, "Ngoc Thanh", 19, Title.Assistant);
		Employee emp5 = new Employee(7, "Hoang Ka", 92, Title.Dev);
		
		//fixed-size
		//Arrays.asList(emp1, emp2, emp3, emp4, emp5);
		
		emps.add(emp1);
		emps.add(emp2);
		emps.add(emp3);
		emps.add(emp4);
		emps.add(emp5);
		return emps;
	}
}
