package com.gustavo.algorithms.sorting.countInversions;

import java.util.Arrays;

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

	private int counter = 0;

	/**
	 * Count how many inversions one array of integers has. an inversion is when the
	 * i < j and a[i] > a[j]
	 * 
	 * @param arr the array to evaluate
	 * @return the total of inversions in the array
	 */
	public int inversion(int[] arr) {
		return sortAndCount(arr);
	}

	/**
	 * count all the inversions of the supplied array
	 * 
	 * @param arr
	 * @return
	 */
	private int sortAndCount(int[] arr) {

		// compare permuted array and the actual.
		// count offers O(n log n)
		int n = arr.length;
		if (n == 1) {
			return 0;
		}

		sort(arr);
		
		return counter;
	}

	/**
	 * Permutes the supplied array such as a[i] <= a[i+1]
	 * 
	 * @param arr The array that will be sorted
	 * @return The permuted array such as a[i] <= a[i+1]
	 */
	private int[] sort(int arr[]) {
		int n = arr.length;

		if (n == 1) { // base case
			return arr;
		}
		// divide
		int[] arrL = Arrays.copyOfRange(arr, 0, (n / 2));
		int[] arrR = Arrays.copyOfRange(arr, (n / 2), (n));
		// and conquer
		return merge(sort(arrL), sort(arrR));
	}

	
	/**
	 * Merge two arrays, sorting values that the resulting array is the permuted
	 * version of both arrays such as a[i] <= a[i+1].
	 * 
	 * @param left
	 * @param right
	 * @return Merges both arrays into a permuted version of both arrays such as
	 *         a[i] <= a[i+1]
	 */
	private int[] merge(int[] left, int[] right) {
		int[] merged = new int[(left.length + right.length)];

		// l -> arrL index and r -> arrR index
		int l = 0, r = 0;
		for (int i = 0; i < merged.length; i++) {

			if (l >= left.length) {
				merged[i] = right[r++];
			} 
			else if (r >= right.length) {
				merged[i] = left[l++];
			}
			else if (left[l] >= right[r]) {
				// The total inversions will always be left.length - l
				counter += (left.length - l);
				merged[i] = right[r++];
			}
			else if (left[l] < right[r]) {
				merged[i] = left[l++];
			}
		}

		return merged;
	}
}
