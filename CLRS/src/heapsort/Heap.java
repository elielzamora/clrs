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
		
	}
	public void heapSort(){
		
	}
}
