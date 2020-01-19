package com.gustavo.algorithms.sorting;

/**
 * Implementation of merge-sort for some primitive types array.
 * 
 * The overload of the sort method is required due to the generic constraint for
 * primitive types in Java.
 * 
 * @author Gustavo
 *
 */
public class MyMergeSort {

	/**
	 * Sorts an integer array in ascending order
	 * 
	 * @param array to be sorted
	 * @return the permuted array in ascending order
	 */
	public static int[] sort(int[] arr) {
		int n = arr.length;

		// base case
		if (n == 1) {
			return arr;
		}

		int[] arrL = new int[n / 2];
		// populates the array
		for (int i = 0; i < arrL.length; i++) {
			arrL[i] = arr[i];
		}

		int[] arrR = new int[n - (n / 2)]; // Accommodates odd sized arrays
		// populates the array
		for (int i = 0; i < arrR.length; i++) {
			arrR[i] = arr[i + (n / 2)];
		}

		return merge(sort(arrL), sort(arrR));
	}

	/**
	 * Merges two arrays in sorted manner
	 * 
	 * @param arrL first array to be merged
	 * @param arrR second array to be merged
	 * @return the merged array in ascending sorting manner
	 */
	private static int[] merge(int[] arrL, int[] arrR) {

		int[] merged = new int[arrL.length + arrR.length];
		// l -> arrL index and r -> arrR index
		int l = 0, r = 0;
		for (int i = 0; i < merged.length; i++) {

			if (l >= arrL.length) {
				merged[i] = arrR[r];
				r++;
			} else if (r >= arrR.length) {
				merged[i] = arrL[l];
				l++;
			} else if (arrL[l] <= arrR[r]) {
				merged[i] = arrL[l];
				l++;
			}
			// if (arrR[r] <= arrL[l]
			else {
				merged[i] = arrR[r];
				r++;
			}
		}
		return merged;
	}

	/**
	 * Sorts a long array in ascending order
	 * 
	 * @param array to be sorted
	 * @return the permuted array in ascending order
	 */
	public static long[] sort(long[] arr) {
		int n = arr.length;

		// base case
		if (n == 1) {
			return arr;
		}

		long[] arrL = new long[n / 2];
		// populates the array
		for (int i = 0; i < arrL.length; i++) {
			arrL[i] = arr[i];
		}

		long[] arrR = new long[n - (n / 2)]; // Accommodates odd sized arrays
		// populates the array
		for (int i = 0; i < arrR.length; i++) {
			arrR[i] = arr[i + (n / 2)];
		}

		return merge(sort(arrL), sort(arrR));
	}

	/**
	 * Merges two arrays in sorted manner
	 * 
	 * @param arrL first array to be merged
	 * @param arrR second array to be merged
	 * @return the merged array in ascending sorting manner
	 */
	private static long[] merge(long[] arrL, long[] arrR) {

		long[] merged = new long[arrL.length + arrR.length];
		// l -> arrL index and r -> arrR index
		int l = 0, r = 0;
		for (int i = 0; i < merged.length; i++) {

			if (l >= arrL.length) {
				merged[i] = arrR[r];
				r++;
			} else if (r >= arrR.length) {
				merged[i] = arrL[l];
				l++;
			} else if (arrL[l] <= arrR[r]) {
				merged[i] = arrL[l];
				l++;
			}
			// if (arrR[r] <= arrL[l]
			else {
				merged[i] = arrR[r];
				r++;
			}
		}
		return merged;
	}

	/**
	 * Sorts a double array in ascending order
	 * 
	 * @param array to be sorted
	 * @return the permuted array in ascending order
	 */
	public static double[] sort(double[] arr) {
		int n = arr.length;

		// base case
		if (n == 1) {
			return arr;
		}

		double[] arrL = new double[n / 2];
		// populates the array
		for (int i = 0; i < arrL.length; i++) {
			arrL[i] = arr[i];
		}

		double[] arrR = new double[n - (n / 2)]; // Accommodates odd sized arrays
		// populates the array
		for (int i = 0; i < arrR.length; i++) {
			arrR[i] = arr[i + (n / 2)];
		}

		return merge(sort(arrL), sort(arrR));
	}

	/**
	 * Merges two arrays in sorted manner
	 * 
	 * @param arrL first array to be merged
	 * @param arrR second array to be merged
	 * @return the merged array in ascending sorting manner
	 */
	private static double[] merge(double[] arrL, double[] arrR) {

		double[] merged = new double[arrL.length + arrR.length];
		// l -> arrL index and r -> arrR index
		int l = 0, r = 0;
		for (int i = 0; i < merged.length; i++) {

			if (l >= arrL.length) {
				merged[i] = arrR[r];
				r++;
			} else if (r >= arrR.length) {
				merged[i] = arrL[l];
				l++;
			} else if (arrL[l] <= arrR[r]) {
				merged[i] = arrL[l];
				l++;
			}
			// if (arrR[r] <= arrL[l]
			else {
				merged[i] = arrR[r];
				r++;
			}
		}
		return merged;
	}
}
