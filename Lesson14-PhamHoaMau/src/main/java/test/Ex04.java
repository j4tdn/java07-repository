package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Ex04 {
	public static void main(String[] args) throws IOException {
					
		BufferedReader br = null;
		List<student> students = new ArrayList<>();
		
		br = new BufferedReader(new FileReader("student.txt"));
		String textInALine= "";

		while (textInALine != null) {
			textInALine = br.readLine();
			if(textInALine != null) {
				String[] student = textInALine.split(", ");
				students.add(new student(student[0], student[1], Double.parseDouble(student[2]), student[3]));
			}
		}
		System.out.println("Filter By Point");
		List<student> filterPoint = new ArrayList<>();
		filterPoint = filterPoint(students);
		show(filterPoint);
		System.out.println("Filter By Gender");
		List<student> filterGender = new ArrayList<>();
		filterGender = filterGender(students);
		show(filterGender);
		System.out.println("Filter By Gender");
		sortStudent(students);
		
		
		
		br.close();
	}

	private static void sortStudent(List<student> students) {
		students.stream().sorted((o1,o2) -> o1.getGender().compareTo(o2.getGender()));
	}

	private static List<student> filterGender(List<student> students) {
		List<student> filterGender = new ArrayList<>();
		for (student student : students) {
			if("Nu".equals(student.getGender())) {
				filterGender.add(student);
			}
		}
		return filterGender;
	}

	private static void show(List<student> point) {
		for (student student : point) {
			System.out.println(student + " ");
		}
	}

	private static List<student> filterPoint(List<student> students) {
		List<student> point = new ArrayList<>();
		for (student student : students) {
			if(student.getPoint() > 8.0) {
				point.add(student);
			}
		}
		return point;
	}
}
