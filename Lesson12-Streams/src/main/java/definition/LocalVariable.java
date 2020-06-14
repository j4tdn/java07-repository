package definition;

public class LocalVariable {
	
	private static boolean isFinished = false;
	
	public static void main(String[] args) {
		Runnable runnable = run(100);
		runnable.run();
	}
	
	private static Runnable run(int time) {
		//local variable
		int distance = 700;
		return () -> {
			isFinished = true;
			String student = "Adam";
			System.out.println(student +" ran " + distance + " (m) in " + time);
		};
	}
}
	