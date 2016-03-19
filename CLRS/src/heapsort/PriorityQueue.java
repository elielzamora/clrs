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
	/**
	 * i is index to be changed 
	 * j is the value that the key should change to
	 * @param i
	 * @param j
	 * @throws InsertSmallerKeyException 
	 * @throws HeapOverflowException 
	 * @throws HeapUnderflowException 
	 */
	public void changeKey(int i, int j)
			throws InsertSmallerKeyException, HeapOverflowException, HeapUnderflowException{
		if(i < 0) throw new HeapUnderflowException();
		if(i >= size) throw new HeapOverflowException();
		if(get(i) > j) decrease(i, j);
		else if(get(i) < j) increase(i, j);
		//else nada
	}
	/**
	 * Increase a key in a priority queue by climbing the heap
	 * if it is larger than its parent key
	 * @param i
	 * @param j
	 * @throws InsertSmallerKeyException
	 */
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
	/**
	 * support decrease key operation in a max heap
	 * @param i
	 * @param j
	 */
	public void decrease(int i, int j){
		
	}
	public void insert(int i)throws HeapOverflowException{
		if(size() < length()){
			this.size++;
			this.heap[size()-1] = SENTINEL;
			try {//should work
				increase(size()-1, i);
			} catch (InsertSmallerKeyException e){}
		}else{
			throw new HeapOverflowException();
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
	
	public static void main(String ... args)
			throws NotMaxHeapException, HeapOverflowException{
		PriorityQueue pq = new PriorityQueue(10);
		pq.insert(5);
		pq.insert(20);
		pq.insert(3);
		pq.insert(21);
		pq.insert(14);
		try {
			System.out.println(pq.extractMax());
		} catch (HeapUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i = 0; i < pq.length(); i++){
			System.out.println(pq.get(i));
		}
	}
}