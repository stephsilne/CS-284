package heaps;

import java.util.ArrayList;
import java.util.Random;

public class Heap<E extends Comparable<E>> {
	// data fields
	private ArrayList<E> data;
	
	Heap(int capacity) {
		data = new ArrayList<>(capacity);
	}
	
	private void swap(int a, int b){
		E temp= data.get(a);
		data.set(a, data.get(b));
		data.set(b, temp);
		}
	
	
	public void add(E item) {
		//insert item and get its index
		
		data.add(item);
		int child = data.size()-1;
		int parent = (child - 1)/2;
		
		//if parent < 0 then child is at root
		//swap if parent is in tree and its value is greater than child (new item)
		while(parent >= 0 && data.get(parent).compareTo(item) > 0)
			{
			swap(parent, child);
			child = parent;
			parent = (child-1)/2;
			}
	}
	
	
	public E remove() {
		
		E removed = min();
		//replace root of heap with last item
		data.set(0, data.get(data.size() - 1));
		data.remove(data.size() - 1);
		
		//reheap
		int parent = 0;
		int leftChild;
		int rightChild;
		
		//check if left child is out of tree
		while(true)
			{
			leftChild = (2*parent) + 1;
			rightChild = leftChild + 1;
			if(leftChild > data.size())
				break;
			//left child exists, so swap may be necessary
			
			int minChild = leftChild;
			//if right child exists, compare to left child to see which one is smaller
			if(rightChild < data.size() && data.get(leftChild).compareTo(data.get(rightChild)) > 0)
				minChild = rightChild;
			
			//check if minChild is smaller than parent
			if(data.get(parent).compareTo(data.get(minChild)) > 0)
				{
				//if so, swap to bring larger value down
				swap(parent, minChild);
				parent = minChild;
				}
			else 
				//if not, reheaping is done
				break;
			}
		return removed;
	}
	
	public E min() {
		if (data.size()==0) {
			throw new IllegalStateException("min: heap is empty");
		}
		return data.get(0);
	}
	
	public String toString() {
		return data.toString();
	}
	
	
	public static void main(String[] args) {
		Heap<Integer> h = new Heap<>(50);
		Random r = new Random();
		// add 20 random integers into the heap
		for (int i=0; i<20; i++) {
			h.add(r.nextInt(100));
		}
		System.out.println(h);
		h.remove();
		System.out.println(h);
		
		
		
		
	}
	

}
