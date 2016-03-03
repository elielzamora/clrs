package gettingStarted;

public class InsertionSort {
	private static int[] array = {5,2,4,6,1,3};
	public static void main(String ... args){
		System.out.println("before sorting:");
		printArray(array);
		insertionSort(array);
		System.out.println("after sorting:");
		printArray(array);
	}
	/**
	 * Loop Invarient: A[0..i-1] are always sorted
	 * initialization: sub array of length 1 is sorted
	 * maintainence: as the ith element is inserted into the 
	 * left sub array it inserts into it's correcly sorted order 
	 * termination: when i == A.len all elements have been
	 * passed into the left subarray and thus sorted
	 * @param A
	 */
	public static void insertionSort(int[] A){
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
	public static void printArray(int[] A){
		for(int i: A){
			System.out.println(i);
		}
	}
}
