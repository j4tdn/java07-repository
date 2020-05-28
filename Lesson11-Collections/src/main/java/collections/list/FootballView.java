package collections.list;

import java.util.ArrayList;
import java.util.List;

import beans.Employee;
import beans.Football;
import common.cola;

public class FootballView {
	public static void main(String[] args) {
		List<Football> fbs = getFootball();

		fbs.forEach(fb -> System.out.println(fb + " "));
		System.out.println("===================");
		Football fbNum8 = getFbs(fbs, 8);
		System.out.println("Luong so 8:" + fbNum8.getSalary());
		System.out.println("===================");
		int minsalary = minSalary(fbs);
		fbs.removeIf(fb -> fb.getSalary() == minsalary);
		fbs.forEach(fb -> System.out.println(fb + " "));
		System.out.println("===========");
		Football fbName = getName(fbs, "Khanh Noi");
		fbName.setSalary(22446);
		fbs.forEach(fb -> System.out.println(fb + " "));
		

	}

	private static List<Football> getFootball() {
		List<Football> fbs = new ArrayList<>();
		Football fb1 = new Football(1, "Le Na", 7000000, cola.Defender);
		Football fb2 = new Football(6, "Hoang Khanh", 34000000, cola.Goalie);
		Football fb3 = new Football(12, "Van Hiep", 43000000, cola.Striker);
		Football fb4 = new Football(8, "Van Teo", 23000000, cola.Defender);
		Football fb5 = new Football(25, "Khanh Noi", 13000000, cola.Striker);
		fbs.add(fb1);
		fbs.add(fb2);
		fbs.add(fb3);
		fbs.add(fb4);
		fbs.add(fb5);
		return fbs;

	}

	private static int minSalary(List<Football> fbs) {
		Football football = fbs.get(3);
		int min = football.getSalary();
		for (Football fb : fbs) {
			if (fb.getSalary() < min) {
				min = fb.getSalary();
			}
		}
		return min;

	}

	private static Football getFbs(List<Football> fbs, int num) {
		for (Football fb : fbs) {
			if (num == fb.getNumberClothes()) {
				return fb;
			}
		}
		return null;
	}
	private static Football getName(List<Football> fbs,String name) {
		for(Football fb:fbs) {
			if(name==fb.getFullname()) {
				return fb;
			}
		}
		return null;
	}

}
