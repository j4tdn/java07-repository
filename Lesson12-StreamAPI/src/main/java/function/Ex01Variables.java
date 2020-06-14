package function;

public class Ex01Variables {
	private static boolean isFinish = true;

	public static void main(String[] args) {
		Runnable runnable = run(100);
		runnable.run(); // hàm run() trong run()
	}

	private static Runnable run(int time) {
		// local variable
		int distance = 700;
		Runnable r = new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				// distance = 100;
				isFinish = false;
				String student = "Adam";
				System.out.println(student + " ran " + distance + " (m) in " + time);
			}
		};
		return r;
	}
}
