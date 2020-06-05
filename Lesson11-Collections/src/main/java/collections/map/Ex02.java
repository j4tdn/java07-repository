package collections.map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Been.Employee;
import commom.Tetle;

public class Ex02 {
	public static void main(String[] args) {
		Employee l1 = new Employee(1,"le na ", 70 , Tetle.Dev);
		Employee e1 = new Employee(13, "Hoang Teo", 20, Tetle.President);
		Employee e2 = new Employee(22, "Van Nam", 30, Tetle.Dev);
		Employee e3 = new Employee(9, "Ngoc Thanh", 19, Tetle.Assistant);

		Employee l2 = new Employee(1, "Le Na", 70, Tetle.Dev);
		Employee e4 = new Employee(47, "Pham Phu", 20, Tetle.President);
		Employee e5 = new Employee(48, "Quoc Tuan", 30, Tetle.Dev);
		Employee e6 = new Employee(7, "Hoang Ka", 92, Tetle.Dev);

		Map<Employee, List<Employee>> empMap =  new HashMap<>();
		empMap.put(l1, Arrays.asList(l1,e1,e2,e3));
		empMap.put(l2, Arrays.asList(l1,e1,e2,e3));
		
		System.out.println("size: " + empMap.size());
	}
}
