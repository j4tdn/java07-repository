package declaration_allcation;

import beans.Student;

public class Ex01 {
	public static void main(String[] args) {
		//primitive
		//object
		//+String , Integer, Double
		//+Manual object: Student,Employee
		
		
		//first way
		int[] firstNumbers=new int[3];
		firstNumbers[1]=99;
		System.out.println("1st : "+firstNumbers[0]+"-"+firstNumbers[1]+"-"+firstNumbers[2]);
	
		//second way
		int[] secondNumbers={0,98,0};
		System.out.println("2nd : "+secondNumbers[0]+"-"+secondNumbers[1]+"-"+secondNumbers[2]);
	
		for(int i=0;i<firstNumbers.length;i++) {
			System.out.println(i+":"+firstNumbers[i]);
		}
		
		for(int number:secondNumbers) {
			System.out.println("for each :" +number);
		}
		System.out.println("====================");
	
		String[] firstStrings=new String[4];
		firstStrings[0]="   HELLO";
		firstStrings[0]=firstStrings[0].trim();
		System.out.println(firstStrings[0]+"-"+firstStrings[1]+"-"+firstStrings[2]+"-"+firstStrings[3]);
	
		String[] secondStrings= {"A","B","C"};
		System.out.println(secondStrings[0]+"-"+secondStrings[1]+"-"+secondStrings[2]);
		
		Student[] students=new Student[2];
		students[0]=new Student();
		//students[0].setId("102171122");
	    //students[0].setFullname("Le Na");
		System.out.println(students[0]+"-"+students[1]);
	}
}
