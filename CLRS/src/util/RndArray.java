package util;

public class RndArray {
	public RndArray(){
		
	}
	public static int[] create(int size, int max){
		int[] array = new int[size];
		for(int i = 0; i < size; i ++){
			array[i] = (int)(Math.random()* max);
		}
		return array;
	}
	public static int[] create(int size){
		return create(size, 100);
	}
	/**
	 * unit test
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a = create(10, 10);
		for(int i : a){
			System.out.println(i);
		}
	}

}
