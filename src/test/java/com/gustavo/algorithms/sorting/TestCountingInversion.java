package com.gustavo.algorithms.sorting;

import static com.gustavo.algorithms.sorting.CountingInversion.inversion;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Test cases to a Counting Inversion in an Array.
 * 
 * @author Gustavo
 *
 */
public class TestCountingInversion {
	@Test
	public void testArraySizeOneHasZeroInversion() {
		// assemble
		int[] array = {1};
		// act
		int count = inversion(array);
		String assertion = "count must be equal to "+1+" but was "+count;
		//
		assertEquals(1, count, assertion);
	}
}
