package definition;

public class LocalVariables {

	public static void main(String[] args) {
		Runnable runnable = run(100);
		runnable.run();
	}
	
	private static Runnable run(int time) {
		int distance = 100;
		return () -> {
			String student = "Adam";
			System.out.println(student + " ran " + distance + "(m) in " + time);
		};
	}
}
