package com.gustavo.algorithms.sorting;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.gustavo.algorithms.sorting.countInversions.CountingInversion;

/**
 * Test cases to a Counting Inversion in an Array.
 * 
 * @author Gustavo
 *
 */
public class TestCountingInversion {
	private CountingInversion ci;
	
	@BeforeEach
	public void init() {
		ci = new CountingInversion();
	}
	@AfterEach
	public void dispose() {
		ci = null;
	}
	
	@Test
	public void testArraySizeOneHasZeroInversion() {
		// assemble
		int[] array = {1};
		// act
		long count = ci.inversion(array);
		String assertion = "count must be equal to "+1+" but was "+count;
		//
		assertEquals(0, count, assertion);
	}
	
	@Test
	public void testArraySizeTwoWithNoInversion_ShouldReturn0() {
		// assemble
		int[] array = {1,2};
		// act
		long count = ci.inversion(array);
		String assertion = "count must be equal to "+0+" but was "+count;
		// assert
		assertEquals(0, count, assertion);
	}
	
	@Test
	public void testArraySizeTwoShuffled_ShouldReturn1() {
		// assemble
		int[] array = {2,1};
		// act
		long count = ci.inversion(array);
		String assertion = "count must be equal to "+1+" but was "+count;
		// assert
		assertEquals(1, count, assertion);
	}
	
	@Test
	public void testSmallArrayShuffled_ShouldReturn3() {
		// assemble
		int[] array = {3,2,1};
		int expected = 3;
		// act
		long count = ci.inversion(array);
		String assertion = "count must be equal to "+expected+" but was "+count;
		// assert
		assertEquals(expected, count, assertion);
	}
	
	@Test
	public void testArrayShuffled_ShouldReturn3() {
		// assemble
		int[] array = {1,3,5,2,4,6};
		int expected = 3;
		// act
		long count = ci.inversion(array);
		String assertion = "count must be equal to "+expected+" but was "+count;
		// assert
		assertEquals(expected, count, assertion);
	}
	
	@Test
	public void testArrayShuffled_ShouldReturn8() {
		// assemble
		int[] array = {10,3,4,2,5,7,9,11};
		int expected = 8;
		// act
		long count = ci.inversion(array);
		String assertion = "count must be equal to "+expected+" but was "+count;
		// assert
		assertEquals(expected, count, assertion);
	}
	
}
