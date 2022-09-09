package Trees;

import java.util.ArrayList;

public class Btree <E> {
	
	public static class Node<F>{
		// data fields
		protected F data;
		protected Node<F> left;
		protected Node<F> right;
		
		public Node(F data, Node<F> left, Node<F> right) {
			super();
			this.data = data;
			this.left = left;
			this.right = right;
		}

		public Node(F data) {
			super();
			this.data = data;
		}
		
		public Boolean is_leaf() {
			return left==null && right==null;
		}

	}
	
	// data fields!
	
	protected Node<E> root;
	protected int size;

	public Btree() {
		super();
		root = null;
		size = 0;
	}
	
	Btree(E data){
		root = new Node<>(data);
		size = 1;
	}

	Btree(E data, Btree<E> left, Btree<E> right){
		root = new Node<> (data, left.root, right.root);
		size = 1 + left.size + right.size;
	}

	
	// methods (some through recursion)!
	
	public int noOfLeaves() {
		return noOfLeaves(root);
	}
	private int noOfLeaves(Node <E> current) {
		if (current == null) {
			return 0;
		}
		if (current.left == null && current.right == null) {
			return 1;
		}
		else {
			return noOfLeaves(current.left) + noOfLeaves(current.right);
		}	
	}
	
	private ArrayList<E> level_helper(int l,Node<E> current){
		ArrayList<E> result = new ArrayList<>();
		if(current ==null) {
			return new ArrayList<>();
		}
		if (l ==1) {
			result.add(current.data);
			return result;
		}
		result.addAll(level_helper(l-1,current.left));
		result.addAll(level_helper(l-1,current.right));
		return result;
	}
	
	public ArrayList<E> level(int l){
		if (l < 0) {
			throw new IllegalArgumentException("level: negative argument");
		}
		return level_helper(l,root);
	}
	
	private int height(Node<E> current) {
		if (current == null) {
			return 0;
		}
		else {
			return 1 + Math.max(height(current.left), height(current.right));
		}
	}
	
	public int height() {
		return height(root);
	}
	
	
	public boolean Complete(){	
		return isComplete_helper(root,0,size);
	}
	
	private boolean isComplete_helper(Node <E> current, int index, int count) {
		if(current == null) {
			return true;
		}
		if (index >= count) {
			return false;
		}
		else {
			return isComplete_helper(current.left,index *2 + 1, count) &&
					isComplete_helper(current.right,index *2 + 2, count);
		}
	}
	
	
	/*
	 * public boolean isFull() { return isFull_helper(root); }
	 * 
	 * private boolean isFull_helper(Node <E> current) { if(current == null) {
	 * return true; } if(!(!current.is_leaf() && (current.left == null ||
	 * current.right == null))) { && isFull(current.right);
	 * 
	 * }
	 * 
	 * }
	 */
	
	public boolean isBalanced() {
		return isBalanced_helper(root);
	}
	
	private boolean isBalanced_helper(Node<E> current) {
		if (current == null) {
			return true;
		}
		int leftH = height(current);
		int rightH = height(current);
		if (Math.abs(leftH - rightH) <= 1
				&& isBalanced_helper(current.left)
				&& isBalanced_helper(current.right)) {
			return true;
		}
		return false;
	}
	
	public boolean isPerfect() {
		return (int) Math.pow(2,  this.height()-1) == size;
	}
	
	
	/*
	 * private ArrayList<E> inorder(Node<E> current) { ArrayList<E> r = new
	 * ArrayList<>(); if (current == null) { return r; }
	 * 
	 * } public ArrayList<E> inorder(){ return inorder(root); }
	 * 
	 */
	
	// toString method!
	private String toString(Node<E> current, int level) {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < level; i++) {
		s.append("-");
		}
		if (current == null) {
			return "null\n";
		}
		else {
			s.append(current.data.toString()+ "\n");
			s.append(toString(current.left,level+1));
			s.append(toString(current.right,level+1));
		}
		return s.toString();
	}
	
	public String toString() {
		return toString(root,0);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Btree <Integer> t1 = new Btree<> (12);
		Btree<Integer> t2 = new Btree<> (33, new Btree<>(27), new Btree<>());
		Btree<Integer> t3 = new Btree<> (23,t1,t2);
		System.out.println(t3);
	}

}
