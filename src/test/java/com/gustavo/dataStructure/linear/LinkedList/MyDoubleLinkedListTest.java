/*
   Description of this class
   
   Revision History
  		Gustavo, 2019.12.14: Created
 */
package com.gustavo.dataStructure.linear.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import com.gustavo.dataStructure.Linear.MyList;
import com.gustavo.dataStructure.Linear.Sequential.MyDoubleLinkedList;
import com.gustavo.dataStructure.linear.MyListTest;

/**
 * @author Gustavo
 *
 */
public class MyDoubleLinkedListTest extends MyListTest {

	private MyDoubleLinkedList<String> dllist;

	@Override
	public MyList<String> emptyList() {
		this.dllist = new MyDoubleLinkedList<String>();
		return new MyDoubleLinkedList<>();
	}

	@Test
	public void test_RemoveValidItemNotOnTheList() {
		// Assemble
		Arrays.asList("Test", "Another Test", "One More").forEach((e) -> list.add(e));

		// Act
		boolean actual = list.remove("Fake");
		// Assert
		assertFalse(actual, "Remove item that is not on the list must return false");
	}
	
	@Test
	public void test_addLastNullWillReturnFalse() {
		// act
		boolean actual = dllist.addLast(null);
		assertFalse(actual, "Add null returns false always");
	}

	@Test
	public void test_addLastWillAlwaysAppendAtTheTailOfTheList() {
		// assemble
		String expected = "[It, wont, be, in, reverse]";
		Arrays.asList("It", "wont", "be", "in", "reverse").forEach(e -> dllist.addLast(e));
		// act
		String actual = dllist.toString();
		// assert
		assertEquals(expected, actual, "To string must match");
	}

	@Test
	public void test_RemoveFirstMustRemoveFirstItemAlways() {
		// assemble
		Arrays.asList("It", "wont", "be", "in", "reverse").forEach(e -> dllist.addLast(e));
		String expected = "[wont, be, in, reverse]";
		// act
		dllist.removeFirst();
		String actual = dllist.toString();
		// assert
		assertEquals(expected, actual, "To string must match");
	}

	@Test
	public void test_removeFirstMustRemoveFirstOnSmallList() {
		// assemble
		Arrays.asList("in", "reverse").forEach(e -> dllist.addLast(e));
		String expected = "[reverse]";
		// act
		dllist.removeFirst();
		String actual = dllist.toString();
		// assert
		assertEquals(expected, actual, "To string must match");
	}
	
	@Test
	public void test_removeFirstTurnSizeOneIntoEmptyList() {
		dllist.addLast("reverse");
		// act
		dllist.removeFirst();
		// assert
		assertTrue(dllist.isEmpty(), "After removal of all items list must be empty");
	}

	@Test
	public void test_removeFirstMustReturnFalseOnEmptyList() {
		boolean actual = dllist.removeFirst();
		// assert
		assertFalse(actual, "Must be false when removing from empty list");
	}
	
	@Test
	public void test_removeLastMustReturnFalseOnEmptyList() {
		boolean actual = dllist.removeLast();
		// assert
		assertFalse(actual, "Must be false when removing from empty list");
	}
	
	@Test
	public void test_removeLastTurnSizeOneIntoEmptyList() {
		dllist.addLast("reverse");
		// act
		dllist.removeLast();
		// assert
		assertTrue(dllist.isEmpty(), "After removal of all items list must be empty");
	}
	
	@Test
	public void test_RemoveLastMustRemoveLastItemAlways() {
		// assemble
		Arrays.asList("It", "wont", "be", "in", "reverse").forEach(e -> dllist.addLast(e));
		String expected = "[It, wont, be, in]";
		// act
		dllist.removeLast();
		String actual = dllist.toString();
		// assert
		assertEquals(expected, actual, "To string must match");
	}
	
	@Test
	public void test_removeLastMustRemoveLastOnSmallList() {
		// assemble
		Arrays.asList("in", "reverse").forEach(e -> dllist.addLast(e));
		String expected = "[in]";
		// act
		dllist.removeLast();
		String actual = dllist.toString();
		// assert
		assertEquals(expected, actual, "To string must match");
	}
}
