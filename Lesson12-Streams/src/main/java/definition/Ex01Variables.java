package definition;

import bean.Apple;

public class Ex01Variables {

	private static boolean isFinished = false;

	public static void main(String[] args) {
		Runnable runnable = run(100);
		runnable.run();
	}

	private static Runnable run(int time) {
		// local variable
		int distance = 700;
		final Apple apple = new Apple();
		Runnable r = new Runnable() {

			@Override
			public void run() {
				// distance=800;
				isFinished = true;
				apple.setColor("blue");
				String student = "adam";
				System.out.println(student + " ran " + distance + " in " + time);
			}
		};
		return r;
	}
}
