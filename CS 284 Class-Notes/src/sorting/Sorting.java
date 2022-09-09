package sorting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class Sorting {
	
	public static void merge (int[] a , int[] b, int[] c) {
		int ia = 0;
		int ib = 0;
		int ic = 0;
		// if a and b are sorted then c will be sorted!
		// merge while there are elements remaining in a and b
		while (ia < a.length && ib < b.length) {
			if (a[ia] < b[ib]) {
				c[ic] = a[ia];
				ia++;
			}
			else {
				c[ic] = b[ib];
				ib++;
			}
			ic++;
		}
		// copy what is left of a, if there is anything left at all
		while (ia < a.length) {
			c[ic] = a[ia];
			ic++;
			ia++;
		}
		// copy what is left of b, if there is anything left at all
		while (ib < b.length) {
			c[ic] = b[ib];
			ic++;
			ib++;
		}
	}
	
	
	public static void bubble_sort (int[] arr) {
		int pass = 1;
		boolean exchanges = false;
		int n = arr.length;
		do {
			exchanges = false;
			for (int i = 0; i < n-pass; i++) {
				if (arr[i] > arr[i+1]) {
					int temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp;
					exchanges = true;
				}
			}
		}while(exchanges);
	}

	public static void insertion_sort(int [] arr) {
		int n = arr.length;
		for (int nextPos = 1; nextPos <= n-1; nextPos++) {
			int nextVal = arr[nextPos];
			
			while (nextPos > 0 && arr[nextPos - 1] > nextVal) {
				arr[nextPos] = arr[nextPos-1];
				nextPos--;
			}
			arr[nextPos] = nextVal;
		}
	}
	
	public static void selection_sort(int [] arr) {
		int n = arr.length;
		for (int fill = 0; fill <= n-2; fill++) {
			int posMin = fill;
			for (int next = fill+1; next <= n-1; next++) {
				if (arr[next] < arr[posMin]) {
					posMin = next;
				}
			}
			int temp = arr[fill];
			arr[fill] = arr[posMin];
			arr[posMin] = temp;
		}
	}
	
	public static Set<Integer> makeSet(int n, int max){
		Random r = new Random();
		Set<Integer> result = new HashSet<Integer>();
		while (result.size() < n) {
			result.add(r.nextInt(max));
		}
		return result;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * int [] a = {50,60,90,30}; int [] b = {45,20,80,15,33}; int [] c = new int[9];
		 * 
		 * merge(a,b,c);
		 * 
		 * System.out.println(Arrays.toString(a));
		 * System.out.println(Arrays.toString(b)); // the following should print: // 45
		 * 20 50 60 80 15 33 90 30 System.out.println(Arrays.toString(c));
		 * 
		 * 
		 * Random rd = new Random(); rd.setSeed(4162021); int arrLen = 20; int[] arr0 =
		 * new int[arrLen]; int[] arr1 = new int[arrLen]; int[] arr2 = new int[arrLen];
		 * int[] arr3 = new int[arrLen]; for (int i = 0; i < arrLen; i++) { int next =
		 * rd.nextInt(100); arr0[i] = next; arr1[i] = next; arr2[i] = next; arr3[i] =
		 * next;
		 * 
		 * }
		 * 
		 * Sorting.selection_sort(arr1); Sorting.bubble_sort(arr2);
		 * Sorting.insertion_sort(arr3);
		 * 
		 * System.out.println(Arrays.toString(arr0));
		 * System.out.println(Arrays.toString(arr1));
		 * System.out.println(Arrays.toString(arr2));
		 * System.out.println(Arrays.toString(arr3));
		 */
		Set<Integer> s = makeSet(20,10);
		for (Integer i:s) {
			System.out.println(i);
		}
		Map<Integer,String> m = new HashMap<Integer,String>();
		m.put(1,"hello");
		m.put(2, "hey");
		m.put(7, "howdy");
		System.out.println(m.get(20));
			
	}

	

}
