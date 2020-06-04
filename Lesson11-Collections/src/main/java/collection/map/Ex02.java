package collection.map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bean.Employee;
import common.Title;

public class Ex02 {
	public static void main(String[] args) {
		List<Employee> emps = new ArrayList<>();
		Employee l1 = new Employee(1, "Le Na", 70, Title.Dev);
		Employee e1 = new Employee(13, "Hoang Teo", 20, Title.President);
		Employee e2 = new Employee(22, "Van Nam", 30, Title.Dev);
		Employee e3 = new Employee(9, "Ngoc Thanh", 19, Title.Assistant);

		Employee l2 = new Employee(1, "Le Na", 70, Title.Dev);
		Employee e4 = new Employee(45, "Hoang Anh", 54, Title.President);
		Employee e5 = new Employee(46, "Van A", 32, Title.Dev);
		Employee e6 = new Employee(47, "Ngoc Tinh", 32, Title.Assistant);

		Map<Employee, List<Employee>> empMap = new HashMap<>();

		empMap.put(l1, Arrays.asList(l1, e1, e2, e3));
		empMap.put(l2, Arrays.asList(l2, e4, e5, e6));

		System.out.println("size :" + empMap.size());
		System.out.println(l1);
	}
}
