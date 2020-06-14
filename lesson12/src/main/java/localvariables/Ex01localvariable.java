package localvariables;

import beans.Apple;

public class Ex01localvariable {
	public static void main(String[] args) {
		Runnable runnable = run(100);
		runnable.run();
	}

	private static Runnable run(int time) {
		int distance = 700;
		final Apple apple=new Apple();
		return () -> {
			String student = "ngu";
			System.out.println(student + " vcl " + distance + " m " + time);
		};
	}
}
