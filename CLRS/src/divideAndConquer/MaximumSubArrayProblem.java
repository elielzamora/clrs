package divideAndConquer;

public class MaximumSubArrayProblem {
	public static final int SENTINEL = Integer.MIN_VALUE;
	/** array represents change in prices
	 *  and the maximum sub-array of the change in prices
	 *  represents the greatest profit achievable in
	 *  the stock market example.
	 * */
	public static final int[] array = 
		{13, -3, -25, 20, -3, -16, -23, 18,
		 20, -7, 12, -5, -22, 15, -4, 7};
	
	public static void main(String[] args) {
		System.out.println("Max Sub Array");
		printArray(array);
		int[] subdata = bruteForce(array);
		System.out.println("l: " + subdata[0]);
		System.out.println("r: " + subdata[1]);
		System.out.println("max: " + subdata[2]);
		printSubArray(array, subdata[0], subdata[1]);
		
	}
	public static int[] bruteForce(int[] A){
		int n = A.length, sum = 0, l = 0, r = 0,
				max = SENTINEL;
		for(int i = 0; i < n; i++){
			for(int j = i; j < n; j++){
				sum += A[j];
				if(sum >= max){
					l = i;
					r = j;
					max = sum;
				}
			}
			sum = 0;
		}
		return new int[]{l, r, max};
	}
	public static void printArray(int[] array){
		for(int i : array){
			System.out.println(i);
		}
	}
	public static void printSubArray(int[] array, int a, int b){
		for(int i = a; i <= b; i++) System.out.println(array[i]);
	}
}
