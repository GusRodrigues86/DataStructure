/*
   Description of this class
   
   Revision History
  		Gustavo, 2019.12.19: Created
 */
package com.gustavo.dataStructure.linear.Stacks;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.gustavo.dataStructure.Linear.Sequential.Stacks.SimpleStack;

/**
 * Test cases for stack
 * @author Gustavo
 *
 */
public abstract class SimpleStackTest {
	public SimpleStack<String> stack = emptyInstance();
	
	public abstract SimpleStack<String> emptyInstance();
	
	/*
	 * Test cases for push
	 */
	@Test
	public void pushElementReturnTrue() {
		// assemble
		String element = "hello";
		// act
		boolean actual = stack.push(element);
		
		// assert
		assertTrue(actual);
	}
	
	@Test
	public void pushElementIncreaseSizeByOne() {
		// TODO implement test
		fail();
	}
	
	@Test
	public void pushElementShouldPeekTheSameElement() {
		// TODO implement test
		fail();
	}
	/*
	 * Test cases for peek
	 */
	@Test
	public void peekShouldReturnLastInsertedElement() {
		// TODO implement test
		fail();
	}
	
	@Test
	public void peekShouldThrowInvalidStackIfEmpty() {
		// TODO implement test
		fail();
	}
	
	@Test
	public void peekShouldNotChangeStackSize() {
		// TODO implement test
		fail();
	}
	
	/*
	 * Test cases for pop
	 */
	@Test
	public void popShouldReturnTheLastElementInserted() {
		// TODO implement test
		fail();
	}
	
	@Test
	public void popShouldThrowInvalidStackIfStackIsEmpty() {
		// TODO implement test
		fail();
	}
	
	@Test
	public void popShouldReduceStackSizeByOne() {
		// TODO implement test
		fail();
	}
	
	/*
	 * Test cases for size
	 */
	@Test
	public void sizeShouldBeZeroOnEmptyStack() {
		// TODO implement test
		fail();
	}
	
	@Test
	public void sizeShouldIncreaseWithElementAddition() {
		// TODO implement test
		fail();
	}
	
	@Test
	public void sizeShouldDecreaseWithelementBeingPoped() {
		// TODO implement test
		fail();
	}
	
	/*
	 * Test cases for clear
	 */
	@Test
	public void clearShouldReduceSizeToZero() {
		// TODO implement test
		fail();
	}
	
	@Test
	public void clearAndPeekAfterShouldThrowInvalidStack() {
		// TODO implement test
		fail();
	}
	
	/*
	 * Test cases for isEmpty
	 */
	
	@Test
	public void isEmptyShouldTrueOnEmptyStack() {
		// TODO implement test
		fail();
	}
	
	@Test
	public void isEmptyShouldReturnFalseOnANonEmptyStack() {
		// TODO implement test
		fail();
	}
	
	@Test
	public void isEmptyShouldReturnTrueAfterClear() {
		// TODO implement test
		fail();
	}
}
