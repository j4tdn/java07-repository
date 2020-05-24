package collections.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Been.Employee;
import commom.Tetle;

public class Employee_View {
	public static void main(String[] args) {
		List<Employee> emps = getEmployees();
		Employee newEmp = new Employee(26, "Hai Sau", 80, Tetle.Dev);
		Employee emp2 = new Employee(13, "Hoang Teo", 20,  Tetle.President);
		emps.add(newEmp);
		emps.add(emps.size()/2 + 1,newEmp);
		emps.forEach(emp -> System.out.println(emp));
		
//		Employee empByid = getEmp(emps, 7);
//		System.out.println("EmpById:"+ empByid);
		
		System.out.println("==========================");
		emps.removeIf(emp -> emp.getAge() > 65);
		emps.remove(newEmp);
		
		emps.forEach(emp -> System.out.println(emp));
		
		System.out.println("==========================");
		emps.remove(emp2);
	}

	private static List<Employee> getEmployees(){
		List<Employee> emps = new ArrayList<>();
		Employee emp1 = new Employee(1, "Le Na", 70, Tetle.Dev);
		Employee emp2 = new Employee(13, "Hoang Teo", 20,  Tetle.President);
		Employee emp3 = new Employee(22, "Van Nam", 30, Tetle.Dev);
		Employee emp4 = new Employee(9, "Ngoc Thanh", 19, Tetle.Assistant);
		Employee emp5 = new Employee(7, "Hoang Ka", 92, Tetle.Dev);
	   //emps.add(emp1);emps.add(emp2);emps.add(emp3);emps.add(emp4);emps.add(emp5);
		// fix size return Arrays.asList(emp1,emp2,emp3,emp4,emp5);
		emps.add(emp1);
		emps.add(emp2);
		emps.add(emp3);
		emps.add(emp4);
		emps.add(emp5);
		return emps;
	}
	
//	private static Employee getEmp(List<Employee> emps, int id) {
//		for(Employee emp : emps) {
//			if(emp.getId() == id) {
//				return Em;
//			}
//			return null;
//		}
//	}
}
