package definition;

import beans.Apple;

public class Ex01LocalVariable {
	
	private static boolean isFinshed = true;

	public static void main(String[] args) {
		Runnable runnable = run(100);
		runnable.run();
	}

	//P30
	// final cac bien o stack khong thay doi duoc dia chi, nhung thay doi duoc gia tri
	private static Runnable run(int time) {
		//local variable
		int distance = 700;
		Apple apple = new Apple();
		return ()-> {
			isFinshed = false;
			apple.setColor("Green");
			String student = "Adam";
			System.out.println(student + " ran " + distance + "(m) in " + time );
		};
	}

}
