package com.gustavo.algorithms.sorting.countInversions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Gustavo
 *
 */
public class InversionSolution {

	public static void main(String[] args) {
		try (Scanner s = new Scanner(new File("src/main/resources/IntegerArray.txt"))) {
			int[] arr = new int[100000];
			int i = 0;
			while (s.hasNext()) {
				arr[i++] = s.nextInt();
			}
						
			CountingInversion ci = new CountingInversion();
			
			long inversions = ci.inversion(arr);
			System.out.println(inversions);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
