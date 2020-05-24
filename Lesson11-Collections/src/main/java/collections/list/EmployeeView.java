package collections.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import beans.Employee;
import common.Title;

public class EmployeeView {

	public static void main(String[] args) {
		List<Employee> emps = getEmployees();

		Employee newEmp = new Employee(26, "PhanBinh", 21, Title.Dev);
		Employee newEmp1 = new Employee(26, "ThaoPhuong", 21, Title.Dev);
		emps.add(newEmp);
		emps.add(emps.size() / 2, newEmp1);
		emps.forEach(emp -> System.out.println(emp));
		System.out.println("-----------------");
		Employee empById = getEmpById(emps, 7);
		System.out.println("EmpById: " + empById);
		System.out.println("-----------------");
		emps.removeIf(emp -> emp.getAge() > 65);
		Employee emp2 = new Employee(13, "Hoang Teo", 20, Title.President);
		emps.remove(emp2);
		emps.forEach(emp -> System.out.println(emp));
		System.out.println("-----------------");
		setNameById(emps, 22);
		emps.forEach(emp -> System.out.println(emp));
	}

	private static List<Employee> getEmployees() {
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
//		return Arrays.asList(emp1, emp2, emp3, emp4, emp5); //fixed size
		return emps;
	}

	private static Employee getEmpById(List<Employee> emps, int id) {
		for (Employee emp : emps) {
			if (emp.getId() == id) {
				return emp;
			}
		}
		return null;
	}
	
	private static List<Employee> setNameById(List<Employee> emps, int id) {
		for (int i = 0; i < emps.size(); i++) {
			if (emps.get(i).getId() == id) {
				emps.get(i).setFullname("Chi Pheo");
			}
		}
		return emps;
	}
}
