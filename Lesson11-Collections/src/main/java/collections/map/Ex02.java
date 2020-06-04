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
		Employee l1 = new Employee(1, "Le Na", 70, Title.Dev);
		Employee e1 = new Employee(13, "Hoang Teo", 20, Title.President);
		Employee e2 = new Employee(22, "Van Nam", 30, Title.Dev);
		Employee e3 = new Employee(9, "Ngoc Thanh", 19, Title.Assistant);
		Employee e4 = new Employee(7, "Hoang Ka", 92, Title.Dev);

		Employee l2 = new Employee(4, "Le Na", 70, Title.Dev);
		Employee e5 = new Employee(11, "Hoang Teo", 20, Title.President);
		Employee e6 = new Employee(2, "Van Nam", 30, Title.Dev);
		Employee e7 = new Employee(19, "Ngoc Thanh", 19, Title.Assistant);
		Employee e8 = new Employee(71, "Hoang Ka", 92, Title.Dev);

		Map<Employee, List<Employee>> empMap = new HashMap<>();
		empMap.put(l1, Arrays.asList(l1, e1, e2, e3, e4));
		empMap.put(l2, Arrays.asList(l1, e5, e6, e7, e8));

		System.out.println("size: " + empMap.size());
	}

}
