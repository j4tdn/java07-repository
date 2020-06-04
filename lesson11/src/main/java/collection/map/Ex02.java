package collection.map;

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
	Employee e1 = new Employee(13, "Hoang Teo", 20, Title.President);
	Employee e2 = new Employee(22, "Van Nam", 30, Title.Dev);
	Employee e3 = new Employee(9, "Ngoc Thanh", 19, Title.Assistant);
	
	Employee l2 = new Employee(1, "Le Nam", 70, Title.Dev);
	Employee e4 = new Employee(44, "Hoang Ga", 20, Title.President);
	Employee e5 = new Employee(45, "Khanh Oc", 30, Title.Dev);
	Employee e6 = new Employee(90, "Thanh Trung", 19, Title.Assistant);
	
	Map<Employee,List<Employee>> emMap=new HashMap<>();
	emMap.put(l1, Arrays.asList(l1,e1,e2,e3,e4));
	emMap.put(l2, Arrays.asList(l2,e4,e5,e6));
	System.out.println("size: "+emMap.size());
}
}
