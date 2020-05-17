package sorting;

import java.util.Arrays;
import java.util.Comparator;
import static java.util.Comparator.comparing;
import beans.Student;

public class Ex02 {
	public static void main(String[] args) {
		Student[] students = mock();
		
//		Comparator<Student> idComparator = (s1, s2) -> s1.getId().compareTo(s2.getId()); 
//		Comparator<Student> avgComparator = (s1, s2) -> Double.compare(s1.getAvg(), s2.getAvg());
		
		//method reference
	//	Comparator<Student> idComparator = Comparator.comparing(student -> student.getId());
		Comparator<Student> comparator = comparing(Student::getId).thenComparing(comparing(Student::getAvg));
		
		//comparator, comparable
		Arrays.sort(students, comparator);
		
		Arrays.stream(students).forEach(student -> System.out.println(student));
	}
	
	private static Student[] mock() {
		return new Student[] {
			new Student("sv01", "Tran Nguyen B", 6.8, true),
			new Student("sv03", "Le Van B", 9.2, true),
			new Student("sv05", "Le Thi C", 6.8, false),
			new Student("sv01", "Phan Thanh Ngan", 7.8, true),
			new Student("sv01", "Phan Quang Nhu Anh", 3.8, false) 
		};
	}
}
