package com.gustavo.dataStructure.nonlinear;

import java.util.Arrays;

/**
 * A SimpleGraphSolution is a N-ary Tree.
 * <p>
 * The Graph uses array to to provide
 * </p>
 * 
 * @author Gustavo
 *
 */
public class SimpleGraphSolution {
	/**
	 * Holds information of where in the grid the data was placed
	 */
	private int[] arr;
	/**
	 * Holds the information of how distance one node is away from the data
	 */
	private int[] distance;
	/**
	 * the amount of rows in the grid
	 */
	private final int row;
	/**
	 * the amount of columns per row in the grid
	 */
	private final int column;

	/**
	 * Creates a solution for grid n*m
	 * 
	 * @param row    n
	 * @param column m
	 */
	SimpleGraphSolution(int row, int column) {
		int n = row * column;
		this.arr = new int[n];
		this.distance = new int[n];
		this.row = row;
		this.column = column;
	}

	/**
	 * Assign data to the n-th position and mark the distance for the adjacent data
	 * 
	 * @param n to be marked as data
	 * @return true if and only if the data was successfully assigned to the graph.
	 * @throws IndexOutOfBoundsException if n < graph size.
	 */
	public boolean assignData(int n) {
		if (n > arr.length) {
			throw new IndexOutOfBoundsException();
		}
		arr[n] = 1;
		addDistance(n);
		return true;
	}

	/**
	 * Change the distance of every neighbor of n
	 * 
	 * @param n
	 */
	private void addDistance(int n) {
		// neighbors are top, bottom, front and
		int rowOfN = n / column;
		int colOfN = n % column;

		changeColumnsDistanceFrom(n, colOfN);
		changeRowDistanceFrom(n, rowOfN);

	}

	/**
	 * @param n
	 * @param rowOfN
	 */
	private void changeRowDistanceFrom(int n, int rowOfN) {
		int prevRow = rowOfN - 1;
		int nextRow = rowOfN + 1;
		int prevN = n - column;
		int nextN = n + column;

		// prevRow >= 0
		if (prevRow >= 0 && row > 1) {
			// change previous rows.
			if (arr[prevN] == 0) { // it holds data
				distance[prevN] = 1;
			}
		}
		
		if (nextRow >= (row - 1) && nextN >= (row * column)) {
			return;
		}

		if (row > 1) {
			// change nextRow as well
			if (arr[nextN] == 0) {
				distance[nextN] = 1;
			}
		}
	}

	/**
	 * @param n
	 * @param colOfN
	 */
	private void changeColumnsDistanceFrom(int n, int colOfN) {
		// first element of the grid
		if (colOfN == 0) { // grid x,0
			if (arr[n + 1] != 1) {
				distance[n + 1] = 1;
			}

		}
		// last element of the grid
		else if (colOfN == (column - 1)) { // grid x,0
			if (arr[n - 1] != 1) {
				distance[n - 1] = 1;
			}

		}
		// remaining operation
		else if (colOfN > 0 && colOfN < column ) {
			// before
			if (arr[n - 1] != 1) {
				distance[n - 1] = 1;
			}

			// after
			if (arr[n + 1] != 1) {
				distance[n + 1] = 1;
			}
		}
	}

	public String distanceMap() {
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		for (int i = 0; i < distance.length; i++) {
			if (i + 1 == distance.length) {
				sb.append(distance[i]);
			} else {
				sb.append(distance[i] + ", ");
			}

		}
		sb.append("]");
		return sb.toString();
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		for (int i = 0; i < arr.length; i++) {
			if (i + 1 == arr.length) {
				sb.append(arr[i]);
			} else {
				sb.append(arr[i] + ", ");
			}

		}
		sb.append("]");
		return sb.toString();
	}

}
