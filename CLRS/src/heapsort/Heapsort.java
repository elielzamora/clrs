package heapsort;

public class Heapsort {
	public static int[] array = {3, 6, 4, 7, 1, 2, 5, 8};
	public static void main(String ... args)
			throws HeapUnderflowException, NotMaxHeapException{
		Heap heap = new Heap (array);
		heap.sort();
		for(int i = 0; i < heap.length(); i++){
			System.out.println(heap.get(i));
		}
	}
}
