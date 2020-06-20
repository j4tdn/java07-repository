package definition;

import beans.Apple;

public class Ex01LocalVariables {
	private static boolean isFinish=true; 
	
	public static void main(String[] args) {
		Runnable runnable = run(800);
		runnable.run();
	}

	private static Runnable run(int time) {
		// local variable
		// doi vs kieu nguyen thuy: chi dung dc ma ko the thay doi gia tri
		// doi vs kieu doi tuong: ko the gan sang 1 dia chi khac ma chi co the set lai gia tri
		final int distance = 700;
		final Apple apple=new Apple();
		isFinish=false;
		
		Runnable r=new Runnable() {
			
			@Override
			public void run() {
				apple.setColor("green");
				String student = "Adam";
				System.out.println(student + " ran " + distance + "m in " + time);				
			}
		};
		
		/*
		return () -> {
			String student = "Adam";
			System.out.println(student + " ran " + distance + "m in " + time);
		};
		*/
		
		return r;
	}
}