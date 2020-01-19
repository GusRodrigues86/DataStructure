package com.gustavo.algorithms.sorting;

/**
 * Counting inversion solution.
 * 
 * <p>
 * It will receive an Array and measure how unsorted the solution is.
 * </p>
 * 
 * @author Gustavo
 *
 */
public class CountingInversion {
	
	/**
	 * Count how many inversions one array of integers has.
	 * an inversion is when the i < j and a[i] > a[j]
	 * @param arr the array to evaluate
	 * @return the total of inversions in the array
	 */
	public static int inversion(int[] arr) {
		if (arr.length == 1) {
			return 1;
		}
			return 0;
	}
}
