import java.util.Scanner;

class SelectionSort{
	public static void sort(int[] array){
		int i = 0, j = 0, n, min, index = 0;
		n = array.length;
		for(i = 0; i < n; i++){
			min = array[i];
			for(j = i; j < n; j++)
			{
				if(array[j] < min){
					min = array[j];
					index = j;
				}
			}
			int tmp;
			tmp = array[i];
			array[i] = array[index];
			array[index] = tmp;
		}
	}
	
	public static void printArray(int[] array){
		System.out.print("The sorted array is : ");
		for(int i = 0; i < array.length; i++){
			System.out.print(" " + array[i]);
		}
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int input, n, i = 0;
		System.out.println("Give the length of the array");
		n = sc.nextInt();
			
		int[] array = new int[n];
		for(i = 0; i < n; i++){
			System.out.println("Give the " + i + " th element : ");
			array[i] = sc.nextInt();
		}
		sort(array);
		printArray(array);
	}
}