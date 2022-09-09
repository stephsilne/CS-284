package hw2;
/**
 * 
 * @author Stephaan Silne
 * @class CS 284: Data Structures
 * @assignment Homework 2
 * @date 03/07/2021
 * @Pledge "I pledge my honor that I have abided by the Stevens Honor System"
 */

import java.lang.Math;

public class Complexity {

	/** #1.
	 * a method that had a time complexity of O(n^2)
	 * @param n
	 */
	public static void method1 (int n) {
		for (int i = 1; i <= n ; i ++) {
			for (int j = 1; j <= n; j ++) {
				System.out.println("O(n^2)");
			}
		}
	}
	
	/** #2.
	 * a method that has a time complexity of O(n^3)
	 * @param n
	 */
	public static void method2 (int n) {
		for (int i = 0 ; i < n; i ++) {
			for (int j = 0 ; j < n; j++) {
				for (int k = 0; k < n; k++) {
					System.out.println("O(n^3)");
				}
			}
		}
	}
	

	/** #3.
	 * a method that has a time complexity of O(log n)
	 * @param n
	 */
	public static void method3 (int n) {
		for (int i = 1 ; i < n; i = i * 10) {
			System.out.println("O(log(n))");
		}
	}
	
	
	/**
	 * #4.
	 */
	public static boolean bSearch(int [] a, int x) {
		int end = a.length - 1;
		int start = 0;
		while (start <= end) {
			int mid = (end - start)/ 2 + start;
			if (a[mid] == x) return true;
			else if (a[mid] > x) end = mid -1;
			else start = mid + 1;
		}
		return false;
	}
	
	/**
	 * if length a = 32  --->
	 * 
	 * iteration | start | end
	 * _________________________
	 * 
	 * 1            0       31
	 * 2            16      31
	 * 3            24      31
	 * 4            28      31
	 * 5            30      31
	 * 6            31      31
	 * 7            32      31
	 */
	
	
	/**
	 * if length a = 64 ---->
	 * 
	 * iteration | start | end
	 * ________________________
	 * 
	 *  1           0       63
	 *  2           32      63
	 *  3           48      63
	 *  4           56      63
	 *  5           60      63
	 *  6           62      63
	 *  7           63      63
	 *  8           64      63
	 */
	
	
	/** #5.
	 * What is the relation between the size n of a and the number of iterations?
	 * The size n of the array 'a' becomes halved (n/2) after each iteration.
	 * 
	 *  #6.
	 * What is the time complexity of bSearch?
	 * The time complexity of the method is log_2(n).
	 *
	 */
	
	
	
	
	/** #7.
	 * a method that has a time complexity of O(n log(n))
	 * @param n
	 */
	public static void method4 (int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 1 ; j < n; j = j * 10) {
				System.out.println("O(n * log(n))");
			}
		}
	}
	
	/** #8.
	 * a method that has a time complexity of O(log(log(n)))
	 * @param n
	 */
	public static void method5 (int n) {
		for (double i = 10; i < n; i = Math.pow(i,10)) {
			System.out.println("O(log(log(n))");
		}
	
	}
	/** #9.
	 * a method that has a time complexity of O(2^n)
	 * @param n
	 * @return
	 */
	public static int method6 (int n) {
		if (n == 0) {
			return 1;
		}
		else {
			return method6(n-1) + method6(n-1);
		}
	}
	
	

}

