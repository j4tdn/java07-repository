package collections.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import beans.Employee;
import common.Title;

public class EmployeeView {
	public static void main(String[] args) {
		List<Employee> emps = getAll();

		Employee e = new Employee(26, "hai Sau", 26, Title.Dev);
		emps.add(emps.size()/2 +1, e);
		
		emps.forEach(emp -> System.out.println(emp));
		System.out.println("==============================");
		
		Employee employeeById= searchId(emps, 7);
		System.out.println("empById: "+ employeeById);
		
		Employee emp2 = new Employee(13, "Hoang Teo", 20, Title.President);
		System.out.println("===================");
		emps.removeIf(emp -> emp.getAge()>65);
		emps.remove(e);
		emps.remove(emp2);
		emps.forEach(emp -> System.out.println(emp));
		
		//emps.contains(emp2)
		/*
		 * 2 ham quan trong la equals vaf hasdcode
		 * bai list co 2 ham lien quan den equals la contain va remove
		 * */
	}

	private static List<Employee> getAll() {
		List<Employee> emps = new ArrayList<>();
		Employee emp1 = new Employee(1, "Le Na", 70, Title.Dev);
		Employee emp2 = new Employee(13, "Hoang Teo", 20, Title.President);
		Employee emp3 = new Employee(22, "Van Nam", 30, Title.Dev);
		Employee emp4 = new Employee(9, "Ngoc Thanh", 19, Title.Assistant);
		Employee emp5 = new Employee(7, "Hoang Ka", 92, Title.Dev);
		// fixed-size
		// return Arrays.asList(emp1, emp2, emp3, emp4, emp5);

		emps.add(emp1);
		emps.add(emp2);
		emps.add(emp3);
		emps.add(emp4);
		emps.add(emp5);
		return emps;
	}
	private static Employee searchId(List<Employee> emps, int id) {
		for (Employee employee : emps) {
			if (employee.getId()==id) {
				return employee;
			}
		}
		return null;
	}

}
