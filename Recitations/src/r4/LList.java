package r4;

public class LList <E extends Comparable <E> >{

	private static class Node <F>{
		private F data;
		private Node<F> next;
		
		public Node( F data, Node<F> next) {
			super();
			this.data = data;
			this.next = next;
		}
		
		public Node(F data) {
			super();
			this.data = data;
			this.next = null;
		}
		
	}
	
	private Node<E> head;
	private int size;
	
	LList(){
		head = null;
		size  = 0;
	}	
	
	public E addFirst(E item) {
		head = new Node<E> (item, head);
		size ++ ;
		return item;
	}
	
	public E add(E item, int index) {
		if (index < 0 || index > size) {
			throw new IllegalArgumentException();
		}
		
		if (index == 0) {
			return addFirst(item);
		}
		Node <E> current = head;
		for (int i = 0; i < index -1 ; i++) {
			current = current.next;
		}
		current.next = new Node <E> (item,current.next);
		size ++;
		return item;
	}
	
	public E removeFirst() {
		if(head == null) {
			throw new IllegalStateException("The list is empty");
		}
		E temp = head.data;
		head = head.next;
		size --;
		return temp;
	}
	
	public E getAt (int index) {
		if (index < 0 || index > size) {
			throw new IllegalArgumentException();
		}
		Node <E> current = head;
		for (int i = 0; i < index -1 ; i++) {
			current = current.next;
		}
		return current.data;
	}
	
	public void remove(int index) {
		if (index < 0 || index > size) {
			throw new IllegalArgumentException();
		}
		if (index == 0) {
			removeFirst();
		}
		else {
			Node <E> current = head;
			for (int i = 0; i < index -1 ; i++) {
				current = current.next;
			}
			current.next = current.next.next;
			
		}
	}
	
	/**
	 * Determines whether item belongs to the linked list
	 * @param item The item we are searching for
	 * @return
	 */
	
	public Boolean mem(E item) {
		Node<E> current = head;
		while (current != null && !current.data.equals(item)) {
			current = current.next;
		}
		return current !=null;
	}
	
	
	/**
	 * Returns a copy of the recipient list
	 */
	public LList <E> clone(){
		LList<E> result = new LList<>();
		Node<E> current = head;
		for (int i = 0; i < size; i++) {
			result.add(current.data, i);
			current = current.next;
		}
		return result;
		
	}
	public LList<E> clone3(){
		LList<E> result = new LList<>();
		Node<E> current = head;
		Node<E> newCurrent = new Node <E> (null);
		while(current != null) {
			newCurrent.next = new Node<E>(current.data);
			current = current.next;
			newCurrent = newCurrent.next;
		}
		return result;
	}
	/**
	 * Drops the suffix of the recipient list, from index+1 and onwards
	 * @param index
	 */
	public void drop(int count) {
		if(count <= 0) {
			return;
		}
		// count >0 and the list is not empty
		else {
			int n = 0;
			while (head != null && n < count) {
				removeFirst();
				n++;
			}
		}
		
	}
	
	/**
	 * Drops the prefix of the recipient list, from index 0 up to index count
	 * @param count
	 */
	public void take(int count) {
		if(count <= 0 || head == null) {
			head = null;
			size = 0;
		} 
		else {
			// count > 0 and the list is not empty
			Node <E> current = head;
			int n = 1;
			while (current.next != null && n < count) {
				current = current.next;
				n++;
			}
			current.next = null;
			size = n;
		}
		
	}
	
	public boolean member(E item, Node<E> localHead) {
		Node<E> current = localHead;

		while (current!=null && !item.equals(current.data)) {
		current = current.next;
		}

		return current!=null;
		}

		public Boolean hasDuplicates() {

		Node<E> current = head;

		while (current!=null && !member(current.data,current.next)) {
		current=current.next;
		}

		return current!=null;
		}
	
	
	public boolean isSorted() {
		if (size <= 1) {
			return true;
		}
		Node <E> current = head;
		while (current.next != null) {
			if (current.data.compareTo(current.next.data) > 0) {
				return false;
			}
			current = current.next;
		}
		return true;
	}
	
	public boolean isSorted1() {
		Node <E> current = head;
		int n = 1;
		while(current.next != null) {
			if (current.data.compareTo(current.next.data) == -1) {
				current = current.next;
				n ++;
			}
			else {
				break;
			}
		}
		return n == size;
	}
	
	public E addSorted(E item) {
		if (size == 0 || item.compareTo(head.data) < 0) {
			return addFirst(item);
		}
		Node <E> current = head;
		while (current.next != null) {
			if(current.data.compareTo(item) < 0 && current.next.data.compareTo(item) >= 0){
				current.next = new Node<E> (item,current.next);
				size++;
				return item;
			}
			current = current.next;
		}
		current.next = new Node <E> (item, current.next);
		size++;
		return item;
	}
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		Node<E> current = head;
		s.append("[");
		while (current != null) {
			s.append(current.data.toString() + ",");
			current = current.next;
		}
		s.append("]");
		return s.toString();
}


public static void main (String[] args) {
	LList <Integer> l = new LList<> ();
	
	l.addFirst(10);
	l.addFirst(60);
	l.addFirst(100);
	
	System.out.println(l);
	
	l.isSorted();
	
	System.out.println(l.isSorted());
	
	LList <Integer> l2 = new LList<> ();
	
	l2.addFirst(100);
	l2.addFirst(85);
	l2.addFirst(8);
	
	System.out.println(l2);
	System.out.println(l2.isSorted());
}

}