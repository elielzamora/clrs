package heapsort;

public class Heapsort {
	public static int[] array = {3, 4, 7, 1, 2, 5, 8};
	public static void main(String ... args){
		Heap heap = new Heap (array);
		heap.sort();
	}
}
