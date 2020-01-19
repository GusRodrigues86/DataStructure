package com.gustavo.algorithms.sorting;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Random;

import org.junit.jupiter.api.Test;
import static com.gustavo.algorithms.sorting.MyMergeSort.*; 
/**
 * Test cases for Sorting integer arrays.
 * 
 * @author Gustavo
 *
 */
public class TestSort {
	
	private int[] veryLargeArray = largeArray();
	
	private static int[] largeArray() {
		int[] array = new int[1000000];
		for (int i = 0; i < array.length; i++) {
			array[i] = new Random().nextInt(2500000);
		}
		return array;
	}
	
	@Test
	public void testArrayOfOneElement() {
		// assemble
		int[] array = {1};
		// act
		int[] answer = sort(array); 
		// assert
		assertEquals(1, answer.length);
		assertEquals(1, answer[0]);
	}
	@Test
	public void testArrayOfTwoElement() {
		// assemble
		int[] array = {2,1};
		// act
		int[] answer = sort(array); 
		// assert
		assertEquals(2, answer.length);
		assertEquals(1, answer[0]);
		assertTrue(answer[0] < answer[1], "first element must be less than the second, but was: " + answer[0] + " and " + answer[1]);
	}
	@Test
	public void testArrayOfThreeElement() {
		// assemble
		int[] array = {2,1,4};
		// act
		int[] answer = sort(array); 
		// assert
		assertEquals(3, answer.length);
		assertEquals(1, answer[0]);
		for (int i = 1; i < array.length; i++) {
			int before = answer[i-1];
			int after = answer[i];
			String assertion = before + " must be <= than " + after;
			assertTrue(before < after, assertion);			
		}
	}
	
	@Test
	public void testArrayOf50Element() {
		// assemble
		int[] array = new int[50];
		for (int i = 0; i < array.length; i++) {
			array[i] = new Random().nextInt(2500);
		}
		// act
		int[] answer = sort(array); 
		// assert
		
		for (int i = 1; i < array.length; i++) {
			int before = answer[i-1];
			int after = answer[i];
			String assertion = before + " must be <= than " + after;
			assertTrue(before <= after, assertion);			
		}
	}
	
	@Test
	public void testArrayOf50000Element() {
		// assemble
		int[] array = new int[50000];
		for (int i = 0; i < array.length; i++) {
			array[i] = new Random().nextInt(250000);
		}
		// act
		int[] answer = sort(array); 
		// assert
		
		for (int i = 1; i < array.length; i++) {
			int before = answer[i-1];
			int after = answer[i];
			String assertion = before + " must be <= than " + after;
			assertTrue(before <= after, assertion);			
		}
	}
	
	@Test
	public void testArrayOfAMillionElement() {
		
		// act
		int[] answer = sort(veryLargeArray); 
		// assert
		
		for (int i = 1; i < veryLargeArray.length; i++) {
			int before = answer[i-1];
			int after = answer[i];
			String assertion = before + " must be <= than " + after;
			assertTrue(before <= after, assertion);			
		}
	}
}
