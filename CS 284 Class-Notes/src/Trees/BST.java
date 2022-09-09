package Trees;

public class BST <E extends Comparable <E>> extends Btree <E> {

	BST(){
		super();
	}
	
	BST(E data){
	super (data);
	}
	
	BST(E data, BST<E> left, BST<E> right){
		super(data, left,right);
	}
	
	
	/**
	 * 
	 * @param current
	 * @return Returns the largest element in a non-empty binary tree (not necessarily a BST)
	 */
	public E max() {
		return max(root);
	}
	private E max(Node<E>current) {
		E maximum = current.data;
		if (current.left != null) {
			E lmax = max(current.left);
			if (lmax.compareTo(maximum) > 0) {
				maximum = lmax;
			}
		}
		if (current.right != null) {
			E rmax = max(current.right);
			if (rmax.compareTo(maximum) > 0) {
				maximum = rmax;
			}
		}
		return maximum;
	}

	/**
	 * 
	 * @param current
	 * @return Returns the smallest element in a non empty binary tree (not necessarily a BST)
	 */
	public E min() {
		return min(root);
	}
	
	private E min(Node<E>current) {
		E minimum = current.data;
		if (current.left != null) {
			E lmin = min(current.left);
			if (lmin.compareTo(minimum) < 0) {
				minimum = lmin;
			}
		}
		if (current.right != null) {
			E rmin = max(current.right);
			if (rmin.compareTo(minimum) < 0) {
				minimum = rmin;
			}
		}
		return minimum;
	}
	
	private Boolean isBst(Node <E> current) {
		if (current == null) {
			return true;
		}
		if (current.data.compareTo(max(current.left)) < 0 ||
				current.data.compareTo(min(current.right)) > 0) {
			return false;
		}
		return isBst(current.left) && isBst(current.right);
	} 
	
	public Boolean isBst() {	
		return isBst(root);	
	}
	
	/////////////////////////////////////////////////////////////
	
	/*
	 * private E getMaxAndRemove(Node <E> current) { while (current.right.right !=
	 * null) { current = current.right; } E temp = current.right.data; current.right
	 * = current.right.left; return temp; }
	 */
	
	public E getMaxAndRemoveMax() {
		return getMaxAndRemoveMax(root);
	}
	
	private E getMaxAndRemoveMax(Node<E> current) {
		if (current.right.right == null) {
			E temp = current.right.data;
			current.right = current.right.left;
			return temp;
		}
		else {
			return getMaxAndRemoveMax(current.right);
		}
	}
	private Node <E> remove(E item, Node <E> current){
		if(current == null) {
			throw new IllegalArgumentException("remove: item not in tree");
		}
		int i  = item.compareTo(current.data);
		if (i<0) {
			current.left = remove(item,current.left);
			return current;
		}
		if (i>0) {
			current.right = remove(item,current.right);
			return current;
		} 
		//found the node to be removed
		//analyze different cases!
	
			//no children
		if (current.left == null && current.right== null) {
				return null;
			}
			//one child
		if(current.left == null) {
				return current.right;
			}
		if (current.right == null) {
				return current.left;
			}
			//two children
		if (current.left.right == null) {
				current.left.right = current.right;
				return current.left;
			}
		current.data = getMaxAndRemoveMax(current.left);
		return current;
}
	public void remove(E item) {
		root = remove(item,root);
		size--;
	}

	
	private Node<E> add(E item, Node <E> current){
		if (current == null) {
			return new Node<>(item);
		}
		int i = current.data.compareTo(item);
		if (i == 0) {
			throw new IllegalStateException("add: duplicate key");
		}
		if(i < 0) {
			current.right = add(item, current.right);
			return current;
		}
		else {
			current.left = add(item, current.left);
			return current;
		}
		
	}
	

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BST <Integer> t1 = new BST<> (7, new BST<>(), new BST <>());
		BST<Integer> t2 = new BST<> (33, new BST<>(27, new BST<>(), new BST<>()), new BST<>(44, new BST<>(), new BST<>()));
		BST<Integer> t3 = new BST<> (23,t1,t2);
		t3.add(55, null);
		System.out.println(t3);
	}

}
