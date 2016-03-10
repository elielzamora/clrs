package heapsort;

import heapsort.NotMaxHeapException;
import heapsort.HeapUnderflowException;
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
		this.build();
	}
	public Heap(int s){
		this(new int[s]);
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
		this.size = this.heap.length;
		for(int i = (this.size()-1)/ 2; i > -1; i--){
			this.heapify(i);
		}
	}
	public int getMax() throws HeapUnderflowException{
		return this.get(max());
	}
	/*public int extractMax(){
		return 0;
	}*/
	/**
	 * apply heapsort to this heap
	 * the result is that it is no longer a heap
	 * but it is a sorted array.
	 * @throws NotMaxHeapException 
	 * @throws heapUnderflowException 
	 */
	public void sort() throws HeapUnderflowException, NotMaxHeapException{
		this.build();
		while(size() > 0){
			swap(max(), size() - 1); // swap largest with last element
			this.size--;
			heapify(max());
			this.check();//for debugging
		}
	}
	public static int[] randomArray(int size, int max){
		int[] rnd = new int[size];
		for(int i = 0; i < size; i ++){
			rnd[i] = (int)(max * Math.random());
		}
		return rnd;
	}
	public static void main(String ... args) throws NotMaxHeapException{
		//Heap heap = new Heap(new int[]{1, 8, 3, 9, 2, 5, 7});
		//Heap heap = new Heap(randomArray(10, 100));
		Heap heap = new Heap(new int[]{5,13,2,25,7,17,20,8,4});
		//heap.check();
		for(int i = 0; i < heap.size(); i++){
			System.out.println(heap.get(i));}
		try {
			heap.sort();
			System.out.println("printing sorted array");
			for(int i = 0; i < heap.length(); i++){
				System.out.println(heap.get(i));
			}
		} catch (HeapUnderflowException e) {
			System.out.println("whoops!");
		} catch (NotMaxHeapException e){
			System.out.println("was good until: " + e.getMessage());
			for(int i = 0; i < heap.length(); i++){
				System.out.println(heap.get(i));
			}
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
