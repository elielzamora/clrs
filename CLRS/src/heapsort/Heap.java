package heapsort;
/**
 * a MAX heap using array-bases implementation
 * 
 * @author Eli
 *
 */
public class Heap {
	private int[] heap;
	public Heap(int[] h){
		this.heap = h;
		this.buildHeap();
	}
	public Heap(int s){
		this(new int[s]);
	}
	public int parent (int i){return (int)(i/2);}
	public int left (int i){return i * 2;}
	public int right(int i){return i * 2 + 1;}
	public int getParent(int i){return this.heap[parent(i)];}
	public int getLeft(int i){return this.heap[left(i)];}
	public int getRight(int i){return this.heap[right(i)];}
	public int get(int i){return this.heap[i];}
	public int size(){return heap.length;}
	public void swap(int i, int j){
		int temp = this.get(i);
		this.heap[i] = j;
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
		for(int i = this.size()/ 2; i > -1; i--){
			this.heapify(i);
		}
	}
	public int max() throws heapUnderflowException{
		if(this.size() > 0)
			return this.get(0);
		else throw new heapUnderflowException();
	}
	public int extractMax(){
		return 0;
	}
	/**
	 * apply heapsort to this heap
	 */
	public void sort(){
		
	}
	public static void main(String ... args){
		Heap heap = new Heap(new int[]{8,3, 9, 2, 3});
		heap.buildHeap();// redundant
		for(int i = 0; i < heap.size(); i++){
			System.out.println(heap.get(i));
		}
		//int[] sorted = heap.sort();
		//for(int i : sorted) System.out.println(i);
	}
}
class heapUnderflowException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
}