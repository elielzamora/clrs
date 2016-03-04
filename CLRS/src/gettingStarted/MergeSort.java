package gettingStarted;

public class MergeSort {
	private static int[] array = {5,2,4,6,1,3};
	public static void main(String ... args){
		System.out.println("before sorting:");
		printArray(array);
		mergeSort(array);
		System.out.println("after sorting:");
		printArray(array);
	}
	/**
	 * divide and conquer
	 * divide: sort both halves of the array recursivley
	 * conquer: aha! an element of size 1 is sorted
	 * combine: user merge method
	 * @param A
	 */
	public static void mergeSort(int[] A){
		if (A.length < 2) return; //Already sorted
		int j;
		for(int i = 1; i < A.length; i ++){
			j = i;
			while (j > 0 && A[j-1]> A[j]){
				swap(A, j, j-1);
				j--;
			}
		}
	}
	public static void swap(int[] A, int i, int j){
		assert i < A.length && j < A.length; 
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
	public static void merge(int[] A, int p, int q, int r){
		assert i < A.length && j < A.length; 
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
	public static void printArray(int[] A){
		for(int i: A){
			System.out.println(i);
		}
	}
}
