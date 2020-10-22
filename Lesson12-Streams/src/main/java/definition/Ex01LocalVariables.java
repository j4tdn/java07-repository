package definition;

import beans.Apple;

public class Ex01LocalVariables {
	
	private static boolean isFinished = true;
	
	public static void main(String[] args) {
		Runnable runnable = run(100);
		runnable.run();
	}
	
	private static Runnable run(int time) {
		// local variable
		final int distance = 700;
		final Apple apple = new Apple();
		
		Runnable r = new Runnable() {
			
			@Override
			public void run() {
				// distance = 800;
				isFinished = false;
				apple.setColor("Green");
				String student = "Adam";
				System.out.println(student + " ran " + distance + "(m) in " + time );
			}
		};
		
		// distance = 100;
		
		return r;
		
	}
}
