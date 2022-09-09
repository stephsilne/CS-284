package hw4;

import org.junit.Test;

import junit.framework.TestCase;
/**
 * 
 * @author Stephaan Silne
 * @Class CS 284: Data Structures
 * @Assignment Homework 4: Treaps
 * @Date April 27, 2021
 * @Pledge "I pledge my honor that I have abided by the Stevens Honor System"
 * 
 */
public class TreapTest extends TestCase {
	@Test
	public void testadd(){
		Treap<Integer> treap = new Treap<Integer>();
		assertTrue(treap.add(3,43));
		assertTrue(treap.add(1,15));
		assertTrue(treap.add(11,26));
		assertTrue(treap.add(2,8));
		assertTrue(treap.add(23,45));
		assertTrue(treap.add(4,2));
		System.out.println(treap);
		assertFalse(treap.add(4,2));
		assertFalse(treap.add(1,15));
	}
	@Test
	public void testdelete() {
		Treap<Integer> testTree = new Treap<Integer>();
		testTree.add(4,19);
		testTree.add(2,31);
		testTree.add(6,70);
		testTree.add(1,84);
		testTree.add(3,12);
		testTree.add(5,83);
		testTree.add(7,26);
		System.out.println(testTree);
		assertTrue(testTree.delete(6));
		assertTrue(testTree.delete(2));
		assertTrue(testTree.delete(4));
		assertFalse(testTree.delete(11));
		assertFalse(testTree.delete(39));
		assertFalse(testTree.delete(1000));
		
	}
	@Test
	public void testfind() {
		Treap<Integer> testTree = new Treap<Integer>();
		testTree.add(4,19);
		testTree.add(2,31);
		testTree.add(6,70);
		testTree.add(1,84);
		testTree.add(3,12);
		testTree.add(5,83);
		testTree.add(7,26);
		assertFalse(testTree.find(1000));
		assertFalse(testTree.find(700));
		testTree.add(8,77);
		assertTrue(testTree.find(8));
		assertTrue(testTree.find(6));
		assertTrue(testTree.find(7));
		assertTrue(testTree.find(1));
		
	}
}
