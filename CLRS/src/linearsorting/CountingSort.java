package linearsorting;

import util.RndArray;

public class CountingSort {
	public static int[] array = RndArray.create(10, 100);
	//public static int[] array = new int[]{5, 3, 7, 8};
	public static int max(int[] A){
		int max = Integer.MIN_VALUE;//- infinity
		for(int i : A){
			if(i > max) max = i;
		}
		return max;
	}
	
	/**
	 * valid where the elements of a are from [0 - max)
	 * @param A
	 * @param max
	 * @throws Exception 
	 */
	public static void countingSort(int[] A, int max)
			throws Exception{
		int[] aux = new int[max];
		for(int i = 0; i < A.length; i++){
			if(A[i] < max && A[i] >= 0){
				aux[A[i]]++;
			}else{
				throw new Exception();
			}
		}
		int i = 0, j = 0;
		while(i < A.length){
			while(aux[j] > 0){
				A[i] = j;
				aux[j]--;
				i++;
			}
			j++;
		}
	}
	public static void countingSort(int[] A)
			throws Exception{
		countingSort(A, max(A));
	}
	/*
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args)
			throws Exception {
		System.out.println("before:");
		for(int i : array){
			System.out.println(i);
		}
		System.out.println("after:");
		countingSort(array);
		for(int i : array){
			System.out.println(i);
		}
	}

}
