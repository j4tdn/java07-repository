package bt1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Bt04 {
	public static void main(String[] args) {
		List<Student> student = new ArrayList<>();
		System.out.println("Danh sach sinh vien");
		students(student);
		student.forEach(System.out::println);
		System.out.println("==================================");
		System.out.println("xao tron danh sach sinh vien");
		Collections.shuffle(student);
		student.forEach(System.out::println);
		System.out.println("===================================");
		random(student,student.size());
		
		
		
		
		
		
		

	}
	private static void students(List<Student> student) {
		student.add(new Student("sv1", "khanh", 6));
		student.add(new Student("sv2", "noi", 5));
		student.add(new Student("sv3", "hoang", 2));
		student.add(new Student("sv4", "hung", 8));
		student.add(new Student("sv5", "nam", 10));
	}
	private static void random(List<Student> student, int count) {
		Random rd = new Random();
		int index=rd.nextInt(count);
		System.out.println(student.get(index).getName());
	}

}
