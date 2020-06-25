package bt2;

import java.util.Scanner;

public class Bt01 {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		System.out.println("Nhap n :");
		int n=Integer.parseInt(sc.nextLine());
		tamGiacDoiDinh(n);
		
	}
	private static void tamGiacDoiDinh(int n) {
		int tmp=(2*n)-1;
		for(int i=1;i<=((2*n)-1)/2+1;i++) {
			draw(tmp, i, n);
			tmp--;
		}
		tmp=((2*n)-1)/2+2;
		for(int i=((2*n)-1)/2;i>=1;i--) {
			draw(tmp, i, n);
			tmp++;
		}
		
	}
	private static void draw(int tmp,int i,int n) {
		for(int j=1;j<=(2*n)-1;j++) {
			if(j<=i || j>=tmp) {
				System.out.print(j + " ");
			}
			else System.out.print("  ");
			
		}
		System.out.println();
	}

}
