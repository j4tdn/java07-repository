package definition_jv8;

public class Ex01LocalVariables {
	
	
	public static void main(String[] args) {
		  Runnable runnable = run(100);
		  runnable.run();
	}

	private static Runnable run(int time) {
		//loca variable biến cục bộ 
		int distan = 700;
		
		return () -> {
			String student = "Adam";
			System.out.println(student + "ran"  + distan+ "(m) in" +time);
		};
	}
	
	
}
