package sorting;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {

	
	public static <T extends Comparable<T>> void sort (T[] table) {
		
	}
	
	private static <T extends Comparable <T>> void quicksort(T[] table, int first, int last) {
		
	}
	
	private static <T extends Comparable <T>> int partition(T[] table, int first, int last) {
		return 0;
	}
	
	public static void main(String[] args) {
		Random rd = new Random();
		rd.setSeed(4232021);
		int arrLen = 20;
		Integer[] arr = new Integer[arrLen];

		for (int i = 0; i < arrLen; i++) {
			int next = rd.nextInt(100);
			arr[i] = next;

		}

		sort(arr);

		System.out.println(Arrays.toString(arr));

	}

}
