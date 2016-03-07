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
		subdata = maxSubarray(array,0, array.length-1);
		System.out.println("l: " + subdata[0]);
		System.out.println("r: " + subdata[1]);
		System.out.println("max: " + subdata[2]);
		printSubArray(array, subdata[0], subdata[1]);
		subdata = linear(array);
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
	public static int[] maxSubarray(int[] A, int l, int r){
		if(l==r) return new int[]{l, r, A[l]};
		else{
			int m = (l + r)/2;
			int[] left = maxSubarray(A,l, m);
			int[] right = maxSubarray(A,m+1, r);
			int[] mid = maxSubarray(A, l, m, r);
			if(left[2] >= right[2] && left[2] >= mid[2])
				return left;
			else if(right[2] >= left[2] && right[2] >= mid[2])
				return right;
			else
				return mid;
		}
	}
	public static int[] maxSubarray(int[] A, int l, int m, int r){
		int sum = 0, leftSum = SENTINEL, rightSum = SENTINEL;
		int leftMax = 0, rightMax = 0;
		for(int i = m; i >= l; i--){
			sum += A[i];
			if(sum > leftSum){
				leftSum = sum;
				leftMax = i;
			}
		}
		sum = 0;
		for(int i = m+1; i <= r; i ++){
			sum += A[i];
			if(sum> rightSum){
				rightSum = sum;
				rightMax = i;
			}
		}
		return new int[]{leftMax, rightMax, leftSum+rightSum};
	}
	/**
	 * linear solution to maximum subarray
	 * @param A
	 * @return
	 */
	public static int[] linear(int[] A){
		int max = SENTINEL, 
			maxR = 0,
			maxL = 0,
			sum = 0,
			l = 0,
			r = 0;
		for(int i = 0; i < A.length; i++){
			sum += A[i];
			if(sum > max){
				max = sum;
				r = i;
				maxL = l;
				maxR = r;
			}else if(sum < 0){
				sum = 0;
				l = i + 1;
				r = i + 1;
			}
		}
		return new int[]{maxL, maxR, max};
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
