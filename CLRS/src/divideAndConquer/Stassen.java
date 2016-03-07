package divideAndConquer;

public class Stassen {
	/**
	 * 
	 * @param args
	 */
	public static final int[][] matA = {
			{1, 2, 3, -5},
			{4, 5, 6, -7},
			{7, 8, 9, -12},
			{2,7, 8, -1}
	};
	public static final int[][] matB = {
			{1, 2, 3, -3},
			{4, 5, 6, -6},
			{7, 8, 9, -23},
			{7, 8, 6, -7}
	};

	public static void main(String[] args) {
		
	}
	public static int[][] squareMatrixMultiply
							(int[][] A, int[][] B){
		assert A.length == A[0].length;
		assert B.length == B[0].length;
		int n = A.length;
		int[][] C = new int [n][n];
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				for(int k = 0; k < n; k++){
					C[i][j] += A[i][k] * B[k][j];
				}
			}
		}
		return C;
	}
	public static int[][] squareMatrixMultiplyRecursive(
			int[][] A, int[][] B){
		assert A.length == A[0].length;
		assert B.length == B[0].length;
		assert A.length % 2 == 0;
		int n = A.length;
		if(n == 1){
			return new int[][]{{A[0][0]*B[0][0]}};
		}else{
			//int[]
			return new int[][]{{}};
		}
	}
	public static int[][] stassen(int[][] A, int[][] B){
		return null;
	}

}
