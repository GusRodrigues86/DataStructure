package com.gustavo.algorithms.sorting;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import static com.gustavo.algorithms.sorting.MyMergeSort.*; 
/**
 * Test cases for Sorting
 * 
 * @author Gustavo
 *
 */
public class TestSort {
	

	
	@Test
	public void testArrayOfOneElement() {
		// assemble
		Integer[] array = {1};
		// act
		Integer[] answer = (Integer[]) sort(array); // safecast
		// assert
		assertEquals(1, answer.length);
		assertEquals(1, answer[0]);
	}
	
	
}
