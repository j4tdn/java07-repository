package date1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

import beans.Student;

public class Ex03 {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		menu();
	}
	
	private static void menu() {
		int choose = 0;
		List<Student> students = new ArrayList<>();
		do {
			System.out.println("==============MENU==============");
			System.out.println("1.Invalid");
			System.out.println("2.Show data");
			System.out.println("3.Sort by average");
			System.out.println("4.Sort by fullname");
			System.out.println("5.Add student");
			System.out.println("6.Delete student");
			System.out.println("Enter...");
			choose = Integer.parseInt(sc.nextLine());
			switch (choose) {
			case 1:
				students = invalid();
				break;
			case 2:
				showData(students);
				break;
			case 3:
				sort(students, Comparator.comparing(Student::getAverage));
				break;
			case 4:
				Comparator<Student> compartorName = new Comparator<Student>() {

					@Override
					public int compare(Student o1, Student o2) {
						String[] fullnames1 = o1.getFullname().split("\\s");
						String[] fullnames2 = o2.getFullname().split("\\s");
						String name1 = fullnames1[fullnames1.length - 1];
						String name2 = fullnames2[fullnames1.length - 1];
						return name1.compareTo(name2);
					}
				};
				
				Comparator<Student> compartorSurname = new Comparator<Student>() {

					@Override
					public int compare(Student o1, Student o2) {
						String[] fullnames1 = o1.getFullname().split("\\s");
						String[] fullnames2 = o2.getFullname().split("\\s");
						String surname1 = fullnames1[0];
						String surname2 = fullnames2[0];
						return surname1.compareTo(surname2);
					}
				};
				
				Comparator<Student> compartorMiddlename = new Comparator<Student>() {

					@Override
					public int compare(Student o1, Student o2) {
						String[] fullnames1 = o1.getFullname().split("\\s");
						String[] fullnames2 = o2.getFullname().split("\\s");
						String middleName1 = getMiddleName(fullnames1);
						String middleName2 = getMiddleName(fullnames2);
						return middleName1.compareTo(middleName2);
					}

					private String getMiddleName(String[] fullnames) {
						String rs = "";
						for (int i = 1; i < fullnames.length - 1; i++) {
							rs += fullnames[i] + " ";
						}
						return rs.trim();
					}
		
				};
				
				Comparator<Student> comparator = 
						compartorName
						.thenComparing(compartorSurname)
						.thenComparing(compartorMiddlename);
				sort(students, comparator);
				break;
			case 5:
				invalid();
				break;
			case 6:
				delStudent(students);
				break;
			default:
				break;
			}
		} while (choose != 0);
	}

	private static boolean delStudent(List<Student> students) {
		System.out.println("Enter id delete: ");
		String id = sc.nextLine();
		return students.removeIf(s -> id.equals(s.getId()));
	}

	private static void sort(List<Student> students, Comparator<Student> comparator) {
		students.sort(comparator);
	}

	private static void showData(List<Student> students) {
		students.forEach(System.out::println);
	}

	private static List<Student> invalid() {
		List<Student> students = new ArrayList<>();
		System.out.println("Enter number's student: ");
		int number = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < number; i++) {
			Student student = createData();
			while (students.contains(student)) {
				System.out.println("Id false! Enter again...");
				student = createData();
			}
			students.add(student);
		}
		
		//mockdata
//		Student s1 = new Student("sv01", "Phan Thanh Binh", 8.2f);
//		Student s2 = new Student("sv02", "Phan Dinh Binh", 9.0f);
//		Student s3 = new Student("sv03", "Nguyen Dinh Hoang", 8.1f);
//		Student s4 = new Student("sv04", "Nguyen Que An", 7.5f);
//		Student s5 = new Student("sv05", "Vo Song Giang", 6.5f);
//		Student s6 = new Student("sv06", "Phan Thanh Duong", 7.2f);
//		students.add(s1);
//		students.add(s2);
//		students.add(s3);
//		students.add(s4);
//		students.add(s5);
//		students.add(s6);
		return students;
	}

	private static Student createData() {
		System.out.println("Enter id: ");
		String id = sc.nextLine();
		System.out.println("Enter fullname: ");
		String fullname = sc.nextLine();
		System.out.println("Enter average: ");
		float average = Float.parseFloat(sc.nextLine());
		Student student = new Student(id, fullname, average);
		return student;
	}
}
