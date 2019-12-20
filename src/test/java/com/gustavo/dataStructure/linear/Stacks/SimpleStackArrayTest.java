
package com.gustavo.dataStructure.linear.Stacks;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

import com.gustavo.dataStructure.Linear.Sequential.Stacks.SimpleStack;
import com.gustavo.dataStructure.Linear.Sequential.Stacks.StackArray;

/**
 * @author Gustavo
 *
 */
public class SimpleStackArrayTest extends SimpleStackTest {

	@Override
	public SimpleStack<String> emptyInstance() {
		return new StackArray<>();
	}
	
	@Test
	public void pushElementToFullStackReturnFalse() {
		// assemble
		veryLargeStack();
		// act
		boolean actual = stack.push("last");
		// assert
		assertFalse(actual, actual + " should be false");
	}
}
