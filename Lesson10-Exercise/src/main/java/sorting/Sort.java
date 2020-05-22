package sorting;

import java.util.Arrays;

public class Sort {
	public static void main(String[] args) {
		Student student1 = new Student("sv01", "Binh", 21);
		Student student2 = new Student("sv08", "Hoang", 20);
		Student student3 = new Student("sv07", "Binh", 23);
		Student student4 = new Student("sv04", "Nam", 21);
		Student student5 = new Student("sv02", "Phuong", 18);
		Student student6 = new Student("sv09", "An", 24);
		Student[] students = {student1, student2, student3, student4, student5, student6};
		bubleSort(students);
		Arrays.stream(students).forEach(student -> System.out.println(student));
	}
	
	private static void bubleSort(Student[] students) {
		for (int out  = 0; out < students.length; out++) {
			for (int in  = 0; in < students.length - 1; in++) {
				if ( students[in].getName().compareTo(students[in + 1].getName()) > 0) { 
					Student temp = students[in];
					students[in] = students[in + 1];
					students[in + 1] = temp;
				}
			}
		}
	}
}
