package queues;

import stacks.StackSLL;

public class QueueSLL <E> {

	public static class Node <F>{
		private F data;
		private Node <F> next;
		
		
		public Node (F data, Node <F>  next) {
			super ();
			this.data = data;
			this.next = next;
		}
		public Node (F data ) {
			super();
			this.data = data;
		}
		
		
	}
	
	private Node <E> front;
	private Node <E> tail;
	private int size;
	
	QueueSLL(){
		front = null;
		tail = null;
		size = 0;
	}

	public void add(E item) {
		if (front == null) {
			 front = new Node<>(item);
			tail = front;
		}else {
		tail.next  = new Node <>(item);
		}
		size++;	
	}
	
	public E remove () {
		if (front == null) {
			throw new IllegalStateException ("remove: queue is empty");
		}
		E temp = front.data;
		if (front.next == null) {
			front = null;
			tail = null;
		}else {
			front = front.next;
		}
		size--;
		return temp;
	}
	
	
	public E element() {
		if (front == null) {
			throw new IllegalStateException ("element: queue is empty");
		}	
		return front.data;
	}
	
	public Boolean isEmpty() {
		if (front == null) {
			return true;
		}
		return false;
	}
	
	public static int fact(int n) {
		if (n == 0) {
			return 1;
		}
		else {
			return n * fact(n-1);
		}
	}
	
	public static double ffib(int n, double old, double current) {
		if (n == 0) {
			return current;
		}
		else {
			return ffib(n-1, current, old+current);
		}
	}
	
	public static double ffib(int n) {
		return ffib(n,1,1);
	}
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		Node <E> current = front;
		s.append("[front]<-");
		while (current != null) {
			s.append((current.data.toString()) + "<-");
			current = current.next;
		}
		s.append("<- [tail]");
		return s.toString();
	}
	
	public static void main(String [] args) {
		QueueSLL<String> q = new QueueSLL <>();
		
		q.add("one");
		q.add("two");
		q.add("three");
		System.out.println(q);
		System.out.println(fact(3));
		}
}

