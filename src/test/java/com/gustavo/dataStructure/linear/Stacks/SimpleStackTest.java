/*
   Description of this class
   
   Revision History
  		Gustavo, 2019.12.19: Created
 */
package com.gustavo.dataStructure.linear.Stacks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.EmptyStackException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.gustavo.dataStructure.Linear.Sequential.Stacks.SimpleStack;

/**
 * Test cases for stacks that implements SimpleStack
 * 
 * @author Gustavo
 *
 */
public abstract class SimpleStackTest {
	public SimpleStack<String> stack;

	public abstract SimpleStack<String> emptyInstance();

	@BeforeEach
	public void init() {
		stack = emptyInstance();
	}

	@AfterEach
	public void dispose() {
		stack = null;
	}

	public void veryLargeStack() {
		for (int i = 0; i < 5000; i++) {
			stack.push(Integer.valueOf(i).toString());
		}
	}

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
		// assemble
		String element = "hello";
		int previous = stack.size();
		// act
		stack.push(element);
		int actual = stack.size();
		// assert
		assertTrue(actual > previous, "Previous (" + previous + " should be greather than (" + actual + ")");
	}

	@Test
	public void pushElementShouldPeekTheSameElement() {
		// Assemble
		String expected = "test";
		stack.push(expected);
		// Act
		String actual = stack.peek();
		// Assert
		assertTrue(expected.equals(actual), expected + " should be equal to " + actual);
	}

	/*
	 * Test cases for peek
	 */
	@Test
	public void peekShouldReturnLastInsertedElement() {
		// Assemble
		String expected = "test";
		stack.push(expected);
		// act
		String actual = stack.peek();
		// assert
		assertEquals(expected, actual, expected + " should be equals to " + actual);
	}

	@Test
	public void peekShouldThrowEmptyStackExceptionIfEmpty() {
		assertThrows(EmptyStackException.class, () -> stack.peek(), "Stack should thow EmptyStackException if empty");
	}

	@Test
	public void peekShouldNotChangeStackSize() {
		// Assemble
		stack.push("Test");
		int beforePeek = stack.size();
		// act
		stack.peek();
		int afterPeek = stack.size();
		// assert
		assertEquals(beforePeek, afterPeek, beforePeek + " should be equals to " + afterPeek);
	}

	/*
	 * Test cases for pop
	 */
	@Test
	public void popShouldReturnTheLastElementInserted() {
		// Assemble
		String expected = "Test";
		stack.push(expected);
		// act
		String actual = stack.pop();
		// assert
		assertEquals(expected, actual, expected + " must be equals to " + actual);
	}

	@Test
	public void popShouldThrowInvalidStackIfStackIsEmpty() {
		assertThrows(EmptyStackException.class, () -> stack.pop(), "Stack should thow EmptyStackException if empty");
	}

	@Test
	public void popShouldReduceStackSizeByOne() {
		// Assemble
		int expected = 0;
		stack.push("Test");
		// act
		stack.pop();
		int actual = stack.size();
		// assert
		assertTrue(actual == expected, "size " + expected + " is equal to size " + actual);
	}

	/*
	 * Test cases for size
	 */
	@Test
	public void sizeShouldBeZeroOnEmptyStack() {
		// act
		int actual = stack.size();
		// assert
		assertTrue(actual == 0, "actual size must be 0, but was " + actual);
	}

	@Test
	public void sizeShouldIncreaseWithElementAddition() {
		int before = stack.size();
		stack.push("Test");
		// act
		int actual = stack.size();
		// assert
		assertTrue(actual > before,
				"Size need to increase by 1 after push. It was " + before + " and increased to " + actual);
	}

	@Test
	public void sizeShouldDecreaseWithelementBeingPoped() {
		stack.push("Test");
		int before = stack.size();
		// act
		stack.pop();
		int actual = stack.size();
		// assert
		assertTrue(actual < before,
				"Size need to decrease by 1 after push. It was " + before + " and decreased to " + actual);
	}

	/*
	 * Test cases for clear
	 */
	@Test
	public void clearShouldReduceSizeToZero() {
		// assemble
		stack.push("Test");
		int before = stack.size();
		// act
		stack.clear();
		int actual = stack.size();
		assertTrue(actual < before, "Size need to decrease to 0 after clear. But decreased to " + actual);
		assertTrue(actual == 0, "Size need to decrease to 0 after clear. But decreased to " + actual);
	}

	@Test
	public void clearAndPeekAfterShouldThrowEmptyStackException() {
		stack.push("Test");
		// act
		stack.clear();
		assertThrows(EmptyStackException.class, () -> stack.pop(), "Stack should thow EmptyStackException if empty");
	}

	/*
	 * Test cases for isEmpty
	 */

	@Test
	public void isEmptyShouldTrueOnEmptyStack() {
		assertTrue(stack.isEmpty(), "Empty stack must return true always.");
	}

	@Test
	public void isEmptyShouldReturnFalseOnANonEmptyStack() {
		stack.push("Test");
		// act
		boolean actual = stack.isEmpty();
		// assert
		assertFalse(actual, "Stack must return false always when size > 0.");
	}

	@Test
	public void isEmptyShouldReturnTrueAfterClear() {
		stack.push("Test");
		// act
		boolean actual = stack.isEmpty();
		// assert
		assertFalse(actual, "Stack must return false always when size > 0.");
		// act
		stack.clear();
		actual = stack.isEmpty();
		// assert
		assertTrue(actual, "Empty stack must return true always.");

	}

	/*
	 * ToString Tests
	 */

	@Test
	public void testEmptyToString() {
		// assemble
		String expected = "[]";
		// act
		String actual = stack.toString();
		// assemble
		assertEquals(expected, actual);
	}

	@Test
	public void testToString() {
		// assemble
		String expected = "[World, Hello]";
		stack.push("Hello");
		stack.push("World");
		// act
		String actual = stack.toString();
		// assemble
		assertEquals(expected, actual);
	}

	@Test
	public void testLargeStackToString() {
		// assemble
		String expected = "[?, Today, Doing, You, Are, How, World, Hello]";
		Arrays.asList("Hello", "World", "How", "Are", "You", "Doing", "Today", "?").forEach(e -> stack.push(e));

		// act
		String actual = stack.toString();
		// assemble
		assertEquals(expected, actual);
	}
}
