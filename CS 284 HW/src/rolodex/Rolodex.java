package rolodex;

import java.util.ArrayList;

/**
 * 
 * @author Stephaan Silne
 * @class CS 284: Data Structures
 * @assignment Homework 3: Rolodex
 * @date 03/21/2021
 * @Pledge "I pledge my honor that I have abided by the Stevens Honor System"
 */

public class Rolodex {
	private Entry cursor;
	private final Entry[] index;
	
	
	// Constructor
	Rolodex() {
		char [] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
		index = new Entry [26];
		int i = 1;
		int counter = 0;
		index[0] = new Separator(null, null, alphabet[0]);
		index[0].prev = index[0];
		index[0].next = index[0];
		index[25] = new Separator(null, null, alphabet[25]);
		index[25].prev = index[0];
		
		//don't change this.
		index[25].next = index[0];
		//don't change this.
		index[0].prev = index[25];
		
		index[0].next = index[25];
		while(i < index.length-1) {
			index[i] = new Separator(null, null, alphabet[i]);
			index[i].prev = index[i-1];
			index[i].next = index[index.length-1];
			index[counter].next = index[i];
			index[index.length-1].prev = index[i];
			counter++;
			i++;
		}
		
	}
	
	public int position (char c) {
		char [] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
		String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int i = 0;
		int j = 0;
		while (i < 26) {
			if (c != alphabet[i]) {
				i++;
			}else {
				j = s.indexOf(c);
				break;
			}
		}
		return j;	
		
	}
	
	
	public Boolean contains(String name) {
		name = UpChecker(name);
	  Entry current = index[position(name.charAt(0))];
	  current = current.next;
	  while (!current.isSeparator()) {
		  if (current.getName().equals(name)) {
			  return true;
		  }
		else {
			current = current.next;
			  }
		  }
	  	return false;
	  }
	
	public int size() {
		int counter = 0;
		Entry current = index[0];
		while (current != index[25]) {
			if (!current.next.isSeparator()) {
				counter ++;
				current = current.next;
			}
			else {
				current = current.next;
			}
		}
		return counter;
		}

	public ArrayList<String> lookup(String name) {
		name = UpChecker(name);
		ArrayList <String> s = new ArrayList<String>();
		if (contains(name)!= true) {
			throw new IllegalArgumentException("lookup: name not found");
		}
		else {
			Entry current = index[position(name.charAt(0))];
			current = current.next;
			while (!current.isSeparator()) {
				if (current.getName().equals(name)) {
					s.add(((Card) current).getCell());
					current = current.next;
				}
				else {
					current = current.next;
				}
			}
			return s;
		}
	}

	public String toString() {
		Entry current = index[0];
		StringBuilder b = new StringBuilder();
		while (current.next!=index[0]) {
			b.append(current.toString()+"\n");
			current=current.next;
		}
		b.append(current.toString()+"\n");		
		return b.toString();
	}

	public String UpChecker(String name) {
		char [] arr = name.toCharArray();
		int cnt = 0;
		for (int i = 0; i < arr.length; i++) {
			if(Character.isUpperCase(arr[i])) {
				cnt++;
			}
		}
		if (cnt == 1 && Character.isUpperCase(arr[0])) {
			return name;
		}
		else {
			name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
			return name;
		}
	}

	
	public void addCard(String name, String cell) {
		name = UpChecker(name);
		Entry current = index[position(name.charAt(0))];
		current = current.next;
		while (!current.isSeparator()) {
			if (current.getName().equals(name) && ((Card) current).getCell().equals(cell)) {
				throw new IllegalArgumentException("addCard: duplicate entry");
			}
			else {
				current = current.next;
			}
		}
		Entry newcurrent = index[position(name.charAt(0))];
		newcurrent = newcurrent.next;
		while(!newcurrent.isSeparator() && newcurrent.getName().compareTo(name) < 0) {
			newcurrent = newcurrent.next;
		}
		Card c = new Card (null, null, name, cell);
		c.next = newcurrent;
		c.prev = newcurrent.prev;
		newcurrent.prev.next = c;
		newcurrent.prev = c;

	}

	public void removeCard(String name, String cell) {
		name = UpChecker(name);
		if (contains(name) == false) {
			throw new IllegalArgumentException("removeCard: name does not exist");
		}
		Entry current = index[position(name.charAt(0))];
		current = current.next;
		boolean val = false;
		while (!current.isSeparator()) {
			if (current.getName().equals(name) && ((Card) current).getCell().equals(cell)) {
				current.prev.next = current.next;
				current.next.prev = current.prev;
				val = true;
				break;
			}
			else {
				current = current.next;
			}
		}
		if (contains(name) == true && val == false) {
			throw new IllegalArgumentException("removeCard: cell for that name does not exist");
		}
		
		
	}
	
	public void removeAllCards(String name) {
		name = UpChecker(name);
		if (contains(name) == false) {
			throw new IllegalArgumentException("removeAllCards: name does not exist");
		}
		Entry current = index[position(name.charAt(0))];
		current = current.next;
		Entry next;
		while (!current.isSeparator()) {
			if (current.getName().equals(name)) {
				next = current.next;
				current.prev.next = current.next;
				current.next.prev = current.prev;
				current = next;
			}
			else {
				current = current.next;
			}
		}
		

	}

	// Cursor operations

	public void initializeCursor() {
		Entry current = index[0];
		   cursor = current;

	}

	public void nextSeparator() {
		Entry current = cursor;
		if (!current.isSeparator()) {
			while (!current.isSeparator()) {
				current = current.next;
			}
			cursor = current;
		}
		else if (current.next.isSeparator()) {
			cursor = current.next;
		}
		else {
			current = current.next;
			while (!current.isSeparator()) {
				current = current.next;
			}
			cursor = current;
			}
		}

	public void nextEntry() {
		cursor = cursor.next;

	}

	public String currentEntryToString() {
		StringBuilder s = new StringBuilder();
		s.append(cursor.toString()+"\n");
		return s.toString();

	}



	public static void main(String[] args) {

		Rolodex r = new Rolodex();

		System.out.println(r);

		r.addCard("Chloe", "123");
		r.addCard("Chad", "23");
		r.addCard("Cris", "3");
		r.addCard("Cris", "4");
		r.addCard("Cris", "5");
		//		r.addCard("Cris", "4");
		r.addCard("Maddie", "23");

		System.out.println(r);

		System.out.println(r.contains("Albert"));

		r.removeAllCards("Cris");

		System.out.println(r);

		r.removeAllCards("Chad");
		r.removeAllCards("Chloe");
		r.addCard("Chloe", "123");
		r.addCard("Chad", "23");
		r.addCard("Cris", "3");
		System.out.println(r);

	}
}


