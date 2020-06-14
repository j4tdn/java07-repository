package definition;

public class Ex01LocalVariables {
	public static void main(String[] args) {
		Runnable runnable = run(100);
		runnable.run();
	}

	private static Runnable run(int time) {
		// local variables
		int distance = 100;
		return () -> {
			String student = "Admin";
			System.out.println(student + " ran " + distance + "m in " + time + "s");
		};
		/*Runnable r = new Runnable() {
			@Override
			public void run() {
				String student = "Admin";
				System.out.println(student + " ran " + distance + "m in " + time + "s");
			}
		};*/
	}
}