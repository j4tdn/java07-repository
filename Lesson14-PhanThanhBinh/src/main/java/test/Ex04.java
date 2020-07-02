package test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import beans.Student;

public class Ex04 {
	public static void main(String[] args) throws IOException {
		List<Student> students = getAll("student.txt");
		List<Student> preScore = getPredicate(students, a -> a.getScore() > 8);
		List<Student> preGender = getPredicate(students, a -> a.getGender().equals("Nu"));
		List<Student> sortGender = sort(students, Comparator.comparing(Student::getGender).thenComparing(Student::getScore).reversed());
		
	}
	
	private static List<Student> getAll(String pathname) throws IOException {
		File file = new File(pathname);
		List<String> lines = Files.readAllLines(file.toPath());
		List<Student> students = lines.stream()
				.map(new Function<String, Student>() {

					@Override
					public Student apply(String t) {
						String[] attributes = t.split(", ");
						Student student = new Student(attributes[0], attributes[1], Float.parseFloat(attributes[2]), attributes[3]);
						return student;
					}
				}).collect(Collectors.toList());
		return students;
	}
	
	private static  List<Student> getPredicate(List<Student> students, Predicate<Student> predicate) {
		List<Student> rs = new ArrayList<>();
		rs = students.stream().filter(s -> predicate.test(s)).collect(Collectors.toList());
		
		return rs;
	}
	
	private static List<Student> sort(List<Student> students, Comparator<Student> comparator) {
		List<Student> rs = new ArrayList<>();
		rs = students.stream()
				.sorted(comparator)
				.collect(Collectors.toList());
		return rs;
	}
}
