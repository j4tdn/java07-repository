package definition;

import beans.Apple;

public class Ex01LocalVariables {
	
	private static boolean isFinish = true;
	
	public static void main(String[] args) {
		Runnable runnable = run(100);
		runnable.run();
	}

	private static Runnable run(int time) {
		// local variable
		final int distance = 700;
		final Apple apple = new Apple();

		return () -> {
			isFinish = false;
			apple.setColor("green");
			String student = "Long";
			System.out.println(student + " ran " + distance + "(m) in " + time + "(s)");
		};
	}
}
