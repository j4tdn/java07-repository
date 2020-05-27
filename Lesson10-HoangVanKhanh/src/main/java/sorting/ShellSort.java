package sorting;

public class ShellSort {
	public static int shellSort(int[] arr) {
		for (int g = arr.length / 2; g > 0; g /= 2) {
			for (int i = g; i < arr.length; i++) {
				int tmp = arr[i];
				int j;
				for ( j = i; j >= g && arr[j - g] > tmp; j -= g) {

					arr[j]=arr[j-g];
					
				}
				arr[j]=tmp;
			}
		}
		return 0;

	}
	

}
