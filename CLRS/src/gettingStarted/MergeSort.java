package gettingStarted;

public class MergeSort {
	/**
	 * array must not contain the sentinel value
	 */
	private static int SENTINEL = Integer.MAX_VALUE; 
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
	 * divide: split array into two sort both halves using mergeSort
	 * conquer: aha! an element of size 1 is sorted
	 * combine: user merge method
	 * @param A
	 */
	public static void mergeSort(int[] A){
		mergeSort(A, 0, A.length-1);
	}
	public static void mergeSort(int[] A, int p, int r){
		if(p < r) {
			int q = (int) Math.floor((p+r)/2);
			mergeSort(A, p, q);
			mergeSort(A, q+1, r);
			merge(A, p, q, r);
		}
	}
	/** */
	public static void merge(int[] A, int p, int q, int r){
		//assert p < q && q <= r;
		System.out.println("p: "+ p + " q: " + q + " r: " + r);
		int l1 = (q-p) + 1;
		int l2 = (r-q);
		int[] a1 = new int[l1+1];
		int[] a2 = new int[l2+1];
		for(int i = 0; i < l1; i++) a1[i] = A[i+p];
		for(int i = 0; i < l2; i++) a2[i] = A[i+q+1];
		a1[l1] = SENTINEL;
		a2[l2] = SENTINEL;
		System.out.println("merging:");
		printArray(a1);
		System.out.println("with:");
		printArray(a2);
		int i = 0, j = 0;
		for(int k = p; k <= r; k++){
			if(a1[i] <= a2[j]){
				A[k] = a1[i];
				i++;
			}else{
				A[k] = a2[j];
				j++;
			}
		}
	}
	public static void printArray(int[] A){
		for(int i: A){
			System.out.println(i);
		}
	}
}
