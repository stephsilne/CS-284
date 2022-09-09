package hw5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/**
 * 
 * @author Stephaan Silne
 * @Class CS 284: Data Structures
 * @Assignment Homework 5: Anagrams
 * @Date May 9, 2021
 * @Pledge "I pledge my honor that I have abided by the Stevens Honor System"
 * 
 */
public class Anagrams {
	final Integer[] primes =  
			{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 
			31, 37, 41, 43, 47, 53, 59, 61, 67, 
			71, 73, 79, 83, 89, 97, 101};
	Map<Character,Integer> letterTable;
	Map<Long,ArrayList<String>> anagramTable;

	/**
	 * buildLetterTable: builds a hashtable whose keys are all letters in the alphabet and whose
	 * values are the corresponding primes numbers that will represent those letters for further methods
	 * to utilize.
	 */
	public void buildLetterTable() {
		letterTable = new HashMap<Character,Integer>();
		char [] alpha = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		for (int i = 0; i < 26; i++) {
			letterTable.put(alpha[i], primes[i]);
		}
		
	}

	Anagrams() {
		buildLetterTable();
		anagramTable = new HashMap<Long,ArrayList<String>>();
	}
	
	/**
	 * Within: checks if the given string is within the anagramTable.
	 * @param hashtable : The given anagramTable with long keys and arraylist of anagrams as values.
	 * @param s: The string that will given to see if it is already in the anagramTable.
	 * @return: Returns true if the given string s is in the anagram table by checking the arraylist value
	 * for the corresponding key that matches the hashcode of the string; returns false otherwise.
	 */
	private boolean within (Map<Long, ArrayList<String>> hashtable, String s) {
		boolean contains = false;
		long code = myHashCode(s);
		if (hashtable.containsKey(code)) {
			ArrayList<String> value = hashtable.get(code);
			if(value.contains(s)) {
				contains = true;
			}
		}
		return contains;
	}
	
	/**
	 * AddWord: adds the string s to the anagramTable by calculating the hashcode of the string; adding
	 * it to the corresponding value arraylist if the hashcode is a key within the anagramTable or creates a 
	 * new key and corresponding arraylist as a value in the hashtable.
	 * @param s: The string s that is a word that will be added to the anagramTable.
	 */
	public void addWord(String s) {
		  if (s == null) {
			  throw new IllegalArgumentException("addWord: must be given a string");
		  }
		  else if (within(anagramTable,s)) {
			  throw new IllegalArgumentException("addWord: duplicate value");
		  }
		  long hashcode = myHashCode(s);
		  ArrayList<String> list;
		  if (anagramTable.containsKey(hashcode)) {
			  list = anagramTable.get(hashcode);
			  list.add(s);
			  anagramTable.replace(hashcode, list);
		  }
		  else {
			  list = new ArrayList<>();
			  list.add(s);
			  anagramTable.put(hashcode, list);
		  }
	}
	
	/**
	 * myHashCode: returns the hashcode for the given string s.
	 * @param s: String s that is a word to which the hashcode will be returned.
	 * @return Returns the hashcode for the word given by assigning a prime number to each character of 
	 * the string and multiplying each together in order to form a unique prime factorization for each word 
	 * and anagram of that word.
	 */
	public long myHashCode(String s) {
		 if (s == null) {
			 throw new IllegalArgumentException("myHashCode: must be given a string");
		 }
		 long key = 1;
		 int index = 0;
		 while (index < s.length()) {
			 char letter = s.charAt(index);
			 key = key * letterTable.get(letter);
			 index++;
		 }
		 return key;
	}
	
	public void processFile(String s) throws IOException {
		FileInputStream fstream = new FileInputStream(s);
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		String strLine;
		while ((strLine = br.readLine()) != null)   {
		  this.addWord(strLine);
		}
		br.close();
	}
	
	/**
	 * findMxSize: helper function that finds the maximum arraylist value in the anagramTable in terms of size.
	 * @param hashtable: The given anagramTable.
	 * @return: returns an integer that will be the maximum size of an array of anagrams in the hashtable, by 
	 * iterating through each array in the set of hashtable and finding the maximum size.
	 */
	private int findMxSize(Map<Long, ArrayList<String>> hashtable) {
		int max = 0;
		for (ArrayList<String> value: hashtable.values()) {
			if (value.size() > max) {
				max = value.size();
			}
		}
		return max;
	}
	
	/**
	 * getMaxEntries: Finds the entries in the anagramTable that have the most amount of anagrams.
	 * @return Returns an arraylist of entries of the anagramTable whose arraylist value has the same size as the 
	 * maximum size given by the helper function findMxSize.
	 */
	public ArrayList<Map.Entry<Long,ArrayList<String>>> getMaxEntries() {
		int maxSize = findMxSize(anagramTable);
		ArrayList<Map.Entry<Long, ArrayList<String>>> MxNtries = new ArrayList<Map.Entry<Long, ArrayList<String>>>();
		for (Map.Entry<Long, ArrayList<String>> entry: anagramTable.entrySet()) {
			if (entry.getValue().size() == maxSize) {
				MxNtries.add(entry);
			}
		}
		return MxNtries;
	}
	
	
	public static void main(String[] args) {
		Anagrams a = new Anagrams();

		final long startTime = System.nanoTime();    
		try {
			a.processFile("words_alpha.txt");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		ArrayList<Map.Entry<Long,ArrayList<String>>> maxEntries = a.getMaxEntries();
		final long estimatedTime = System.nanoTime() - startTime;
		final double seconds = ((double) estimatedTime/1000000000);
		System.out.println("Time: "+ seconds);
		System.out.println("List of max anagrams: "+ maxEntries);
		
		
	}
}

