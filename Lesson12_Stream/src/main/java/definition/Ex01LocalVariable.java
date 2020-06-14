package definition;

import beans.Apple;

public class Ex01LocalVariable {
	private static boolean is=true;
	
	public static void main(String[] args) {
		Runnable runnable = run(100);
		runnable.run();
	}

	private static Runnable run(int time) {
		//local variable:mặc định final Java8
		int distance = 700;
		Apple apple=new Apple();
		return () -> {
			is=false;//ko final nên có thể thay đổi
			apple.setColor("Green");
			System.out.println(apple.getColor());
			String student = "Adam";
			System.out.println(student + "ran" + distance + "(m) in" + time);
		};

	}
}
