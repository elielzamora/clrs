package heapsort;
/**
 * a MAX heap using array-bases implementation
 * 
 * @author Eli
 *
 */
public class Heap {
	private int[] heap;
	private int size;
	public Heap(int[] h){
		this.heap = h;
		this.buildHeap();
	}
	public Heap(int s){
		this(new int[s]);
	}
	public int parent (int i){return (int)((i-1)/2);}
	public int left (int i){return i * 2 + 1;}
	public int right(int i){return (i+1) * 2;}
	public int max() throws heapUnderflowException {
		if (heap.length != 0) return 0;
		else throw new heapUnderflowException();}
	public int getParent(int i){return this.heap[parent(i)];}
	public int getLeft(int i){return this.heap[left(i)];}
	public int getRight(int i){return this.heap[right(i)];}
	public int get(int i){return this.heap[i];}
	public int size(){return this.size;}
	public int length(){return this.heap.length;}
	public void swap(int i, int j){
		int temp = this.get(i);
		this.heap[i] = this.get(j);
		this.heap[j] = temp;
	}
	public void heapify(int i){
		int largest = i;
		if(left(i) < size() && get(i) < getLeft(i)){
			largest = left(i);
		}else if(right(i) < size() && get(i) < getRight(i)){
			largest = right(i);
		}
		if(largest != i){
			swap(i, largest);
			heapify(largest);
		}
	}
	public void buildHeap(){
		this.size = this.heap.length;
		for(int i = this.size()/ 2 + 1; i > -1; i--){
			this.heapify(i);
		}
	}
	public int getMax() throws heapUnderflowException{
		return this.get(max());
	}
	public int extractMax(){
		return 0;
	}
	/**
	 * apply heapsort to this heap
	 * the result is that it is no longer a heap
	 * but it is a sorted array.
	 * @throws heapUnderflowException 
	 */
	public void sort() throws heapUnderflowException{
		while(size() >0){
			System.out.println("max: " + get(max()));
			swap(max(), size() - 1); // swap largest with last element
			this.size--;
			heapify(max());
		}
	}
	public static int[] count(int s, int t){
		assert s < t;
		int[] count = new int[t-s];
		for(int i = s; i < t; i++){
			count[i] = i;
		}
		return count;
	}
	public static void main(String ... args){
		Heap heap = new Heap(new int[]{1, 8, 3, 9, 2, 5, 7});
		heap.buildHeap();// redundant
		for(int i = 0; i < heap.size(); i++){
			System.out.println(heap.get(i));
		}
		try {
			heap.sort();
		} catch (heapUnderflowException e) {
			System.out.println("whoops!");
		}
		System.out.println("printing sorted array");
		for(int i = 0; i < heap.length(); i++){
			System.out.println(heap.get(i));
		}
		
		/*System.out.println("debug");
		for(int i : count(0,5)){
			System.out.println("i:     " + i);
			System.out.println("left:  " + heap.left(i));
			System.out.println("right: " + heap.right(i));
			System.out.println("parent:" +heap.parent(i));
		}*/
		//int[] sorted = heap.sort();
		//for(int i : sorted) System.out.println(i);
	}
}
//** exceptions
@SuppressWarnings("serial")
class heapUnderflowException extends Exception{}