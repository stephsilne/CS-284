package hw4;

import java.util.Random;
import java.util.Stack;

/**
 * 
 * @author Stephaan Silne
 * @Class CS 284: Data Structures
 * @Assignment Homework 4: Treaps
 * @Date April 27, 2021
 * @Pledge "I pledge my honor that I have abided by the Stevens Honor System"
 * 
 */

public class Treap<E extends Comparable<E>> {

	private static class Node <E>{

		// Data fields:
		public E data;
		public int priority;
		public Node<E> left;
		public Node<E> right;

		//Constructor:
		public Node(E data, int priority) {
			if (data == null) {
				throw new IllegalArgumentException("no data given");
			}
			this.data = data;
			this.priority = priority;
			this.left =null;
			this.right = null;
		}

		/**
		 * Rotate Right : rotates a treap subtree in the right direction
		 * @return This method returns the pivot node that takes the position of the parent node that it was "swapped" with.
		 */
		public Node <E> rotateRight(){
			Node<E> pivot = this.left;
			Node<E> tempNode = pivot.right;
			pivot.right = this;
			this.left = tempNode;
			return pivot;
		}
		/**
		 * Rotate Right : rotates a treap subtree in the right direction
		 * @return This method returns the pivot node that takes the position of the parent node that it was "swapped" with.
		 */
		public Node <E> rotateLeft(){
			Node<E> pivot = this.right;
			Node<E> tempNode = pivot.left;
			pivot.left = this;
			this.right = tempNode;
			return pivot;
		}
	}

	// Data fields:
	private Random priorityGenerator;
	private Node<E> root;

	//Constructors:
	public Treap() {
		root = null;
		priorityGenerator = new Random();
	}

	public Treap (long seed) {
		root = null;
		priorityGenerator = new Random(seed);
	}

	/**
	 * 
	 * @param key: The key that is assigned to the node to which will be added to the treap.
	 * @return returns the helper recursive function that will add the node with the given key to the subtree with a random priority.
	 */
	public boolean add(E key) {
		if (key == null) {
			throw new IllegalArgumentException("add: must be given a valid key");
		}
		int val = priorityGenerator.nextInt();
		return add(key,val);

	}

	/**
	 * 
	 * @param stack: A stack data structure that holds all nodes that the current pointer passed when attempting to use the add method.
	 * @param node: The node that was given to which will be added to the treap.
	 * @return : Returns true upon maintaining the heap structure of the treap;
	 * rotating the subtrees accordingly if certain priorities are larger or smaller and linking the grandparents that are
	 * within the stack to the node that will replace the parent node once added.
	 */
	private boolean reheap(Stack<Node<E>> stack, Node<E> node) {
		while (!stack.isEmpty()) {
			Node<E> parent = stack.pop();
			if (node.priority > parent.priority){
				if (parent.right == node) {
					parent.rotateLeft();
				} 
				else {
					parent.rotateRight();
				}
				if (!stack.isEmpty() && parent == stack.peek().left) {
					stack.peek().left = node;
				}
				else if (!stack.isEmpty() && parent == stack.peek().right) {
					stack.peek().right = node;
				}
				else { 
					root = node;
				}
			}
		}
		return true;
	}
	/**
	 * 
	 * @param key: A given key that belongs to the node that will be added to the treap.
	 * @param priority: A given priority value that belongs to the node that will be added to the treap.
	 * @return: Returns false if the given node is already in the tree but true if added. Adds by placing all nodes passed
	 * by the current pointer in a stack as the node traverses to the appropriate position, then is added to the left or right depending
	 * on BST property and then 'reheaped' to maintain heap architecture.
	 */
	public boolean add(E key, int priority) {
		if (key == null) {
			throw new IllegalArgumentException("add: must give a valid key and priority to compute");
		}
		Node <E> TreapNode = new Node<E> (key, priority);
		Stack<Node<E>> st = new Stack<Node<E>>();
		if (root == null) {
			root = TreapNode;
			return true;
		}
		Node <E> pointer = root;
		while (pointer != null) {
			st.push(pointer);
			int i = key.compareTo(pointer.data);
			if (i < 0) {
				pointer = pointer.left;
			}
			else if (i > 0) {
				pointer = pointer.right;
			}
			else {
				return false;
			}
		}
		int j = key.compareTo(st.peek().data);
		if (j < 0) {
			st.peek().left = TreapNode;
		}
		else {
			st.peek().right = TreapNode;
		}
		return reheap(st, TreapNode);
	}
    
	/**
	 * 
	 * @param key: A given key that belongs to the node that will be deleted from the treap.
	 * @param node: The node (root) to which deletion will start with and traverse down to find the designated node.
	 * @return: Returns the node that will be deleted. Uses recursion until the node if found then when found, it will traverse
	 * down treap further, rotate the subtree, or 'nullify' the node depending on the amount of children.
	 */
    private Node <E> delete(E key, Node<E> node){
    	if (node == null) {
    		return node;
    	}
    	else {
    		int i = key.compareTo(node.data);
    		if (i > 0) {
    			node.right = delete(key, node.right);
    		}
    		else if(i < 0) {
    			node.left = delete(key,node.left);
    		}
    		else {
    			if (node.right == null && node.left != null) {
    				node = node.left;
    			}
    			else if(node.left == null && node.right != null) {
    				node = node.right;
    			}
    			else if (node.right == null && node.left == null) {
    				node = null;
    			}
    			else {
    				int lp = node.left.priority;
    				int rp = node.right.priority;
    				if (lp < rp) {
    					node = node.rotateLeft();
    					node.left = delete(key, node.left);
    				}
    				else if(lp > rp) {
    					node = node.rotateRight();
    					node.right = delete(key, node.right);
    				
    				}
    			}
    			
    		}
    		
    	}
    	return node;
    }
    /**
     * 
     * @param key: The given key of the node that will be deleted.
     * @return: Returns the boolean true if the node that was in the treap was deleted and returned. Returns false if the 
     * node was never in the treap to begin with.
     */
    public boolean delete(E key) {
    	if (key == null) {
    		throw new IllegalArgumentException("delete: a valid key must be given");
    	}
    	else if(this.find(key) == false) {
    		return false;
    	}
    	else {
        	root = delete(key, root);
        	return (root != null);
        	}
    }
    
    /**
     * 
     * @param node: the node (root) that the helper function will start with when trying to find the node of the given key recursively.
     * @param key: the key of the given node that will be searched.
     * @return: Returns true is the node is found in either the left or right subtree, but will return false if found in neither subtree.
     */
	private boolean find(Node<E> node, E key) {
		if (node == null) {	
			return false;
		} 
		else {
			int i = key.compareTo(node.data);
			if (i == 0) {
				return true;
			} 
			else {
				return (find(node.left, key) || find(node.right, key));
			}
		}
	}

	/**
	 * 
	 * @param key: the given key of the node that will be deleted from the treap.
	 * @return: Returns true if found and false if not in the treap.
	 */
	public boolean find(E key) {
		if (key == null) {
			throw new IllegalArgumentException("find: must be given a valid key");
		}
		return find(root, key);
	}

	/**
	 * 
	 * @param current: The current position of where we are in traversing through the treap.
	 * @param level: The depth of the treap.
	 * @return Returns a string that illustrates the framework of the treap throuhg recursive calls.
	 */
	private String toString(Node<E> current, int level) {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < level; i++) {
			s.append("-");
		}
		if (current == null) {
			s.append("null");
		} 
		else {
			s.append("(key = " + current.data +", priority = " + current.priority + ")" );
			s.append("\n");
			s.append(toString(current.left, level+1));
			s.append("\n");
			s.append(toString(current.right, level+1));
		}
		return s.toString();

	}

	/**
	 * The method that will overide the toString method and call the recursive function on the root at a depth of 0.
	 */
	public String toString() {
		return toString(root,0);
	}

	public static void main(String[] args) {
		Treap<Integer> testTree = new Treap <Integer>();
		testTree.add(4,19);
		testTree.add(2,31);
		testTree.add(6,70);
		testTree.add(1,84);
		testTree.add(3,12);
		testTree.add(5,83);
		testTree.add(7,26);
		System.out.println(testTree);
	}

}
