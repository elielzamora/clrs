package heapsort;
import heapsort.NotMaxHeapException;
import heapsort.HeapUnderflowException;
/*priority queue implemented with a fixed max heap*/
public class PriorityQueue {
	private static final int SENTINEL = Integer.MIN_VALUE;
	private int[] heap;
	private int size;
	public PriorityQueue(int[] h){
		this.heap = h;
		this.size = this.heap.length;
		this.build();
	}
	public PriorityQueue(int s){
		this.heap = new int[s];
		this.size = 0;
	}
	public int parent (int i){return (int)((i-1)/2);}
	public int left (int i){return i * 2 + 1;}
	public int right(int i){return (i+1) * 2;}
	public int max() throws HeapUnderflowException {
		if (heap.length != 0) return 0;
		else throw new HeapUnderflowException();}
	public int getParent(int i){return this.get(parent(i));}
	public int getLeft(int i){return this.get(left(i));}
	public int getRight(int i){return this.get(right(i));}
	public int get(int i){return this.heap[i];}
	public int size(){return this.size;}
	public int length(){return this.heap.length;}
	public void increase(int i, int j)
		throws InsertSmallerKeyException{
		if(j < this.get(i))
			throw new InsertSmallerKeyException();
		this.heap[i] = j;
		while(i > 0 && getParent(i) < get(i)){
			swap(i, parent(i));
			i = parent(i);
		}
	}
	public void insert(int i){
		if(size() < length()){
			this.size++;
			this.heap[size()] = SENTINEL;
			try {//should work
				increase(size(), i);
			} catch (InsertSmallerKeyException e){}
		}		
	}
	public void swap(int i, int j){
		int temp = this.get(i);
		this.heap[i] = this.get(j);
		this.heap[j] = temp;
	}
	public void check()throws NotMaxHeapException{
		for(int i = 0; i < this.size(); i++){
			boolean heapProp = true;
			if(left(i) < size() && get(i) < getLeft(i))
				heapProp = false;
			if(right(i) < size() && get(i) < getRight(i))
				heapProp = false;
			if(heapProp) continue;
			throw new NotMaxHeapException(i);
		}
	}
	public void heapify(int i){
		int largest = i;
		if(left(i) < size() && get(i) < getLeft(i)){
			largest = left(i);
		}
		if(right(i) < size() && get(largest) < getRight(i)){
			largest = right(i);
		}
		if(largest != i){
			swap(i, largest);
			heapify(largest);
		}
	}
	public void build(){
		for(int i = (this.size()-1)/ 2; i > -1; i--){
			this.heapify(i);
		}
	}
	public int getMax() throws HeapUnderflowException{
		return this.get(max());
	}
	public int extractMax() throws HeapUnderflowException{
		int max = max();
		swap(max(), size-1);
		heapify(max());
		size--;
		return max;
	}
	
	public static void main(String ... args) throws NotMaxHeapException{
		
	}
}