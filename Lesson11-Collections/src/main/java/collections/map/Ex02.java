package collections.map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import beans.Employee;
import common.Title;

public class Ex02 {
	public static void main(String[] args) {
		List<Employee> emps = new ArrayList<>();
		Employee l1 = new Employee(1, "Le Na", 70, Title.Dev);
		Employee emp2 = new Employee(13, "Hoang Teo", 20, Title.President);
		Employee emp3 = new Employee(22, "Van Nam", 30, Title.Dev);
		Employee emp4 = new Employee(9, "Ngoc Thanh", 19, Title.Assistant);
		Employee emp5 = new Employee(7, "Hoang Ka", 92, Title.Dev);
		
		Employee l2 = new Employee(1, "A", 70, Title.Dev);
		Employee emp6 = new Employee(25, "B", 20, Title.President);
		Employee emp7 = new Employee(29, "C", 30, Title.Dev);
		Employee emp8 = new Employee(31, "D", 19, Title.Assistant);
		Employee emp9 = new Employee(28, "E", 92, Title.Dev);
		
		Map<Employee, List<Employee>> empMap = new HashMap<>();
		empMap.put(l1, Arrays.asList(l1, emp2, emp3, emp4, emp5));
		empMap.put(l2, Arrays.asList(l2, emp6, emp7, emp8, emp9));
		
		System.out.println("size: " + empMap.size());
	}
}
