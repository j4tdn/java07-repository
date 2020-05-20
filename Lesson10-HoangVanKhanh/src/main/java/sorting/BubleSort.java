package sorting;

public class BubleSort {
	public static void bubleSort(int[] Arr) {
		for(int i=0;i<Arr.length-1;i++) {
			for(int j=0;j<Arr.length-i-1;j++) {
				if(Arr[j]>Arr[j+1]) {
					int tmp=Arr[j];
					Arr[j]=Arr[j+1];
					Arr[j+1]=tmp;
							
				}
			}
		}
	}

}
