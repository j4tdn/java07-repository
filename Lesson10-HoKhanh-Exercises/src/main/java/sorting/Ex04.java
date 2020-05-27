package sorting;

import java.util.Comparator;
import static java.util.Comparator.comparing;

import java.util.Arrays;

public class Ex04 {
	public static void main(String[] args) {
		Student[] students = mock();
		Comparator<Student> comparator = comparing(Student::getName).thenComparing(comparing(Student::getAge));
		Arrays.sort(students,comparator);
		Arrays.stream(students).forEach(student->System.out.println(student));
	}
	private static Student[] mock() {
		return new Student[] {
				new Student("sv1","ho khanh",3),
				new Student("sv7","dang dinh hoang",5),
				new Student("sv30","phan thanh trung",8),
				new Student("sv41","hoang van khanh",9),
				new Student("sv22","vo viet trung",8),
				new Student("sv11","hoang van kha",10),
				new Student("sv4","duong chi manh",8),
				new Student("sv5","vo viet bac",11),
		};
	}
}
