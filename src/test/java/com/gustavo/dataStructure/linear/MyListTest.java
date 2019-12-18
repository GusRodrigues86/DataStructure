package com.gustavo.dataStructure.linear;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.gustavo.dataStructure.Linear.MyList;


/**
 * @author Gustavo
 *
 */
public abstract class MyListTest {
	public MyList<String> list;
	
	public abstract MyList<String> emptyList();

	@BeforeEach
	void setup() {
		this.list = emptyList();
	}

	@AfterEach
	void dispose() {
		this.list = null;
	}

	/*
	 * testing observers
	 */
	// size
	@Test
	void testEmptyListHasSizeZero() {
		// Assemble
		int expected = 0;
		// Act
		int actual = list.size();
		// Assert
		assertEquals(actual, expected);
	}

	@Test
	void testEmptyListIsEmpty() {
		// Act
		boolean actual = list.isEmpty();
		// Assert
		assertTrue(actual);
	}
	// contains

	@Test
	void testContainsReturnFalseOnAnEmptyList() {
		// act
		boolean actual = list.contains("Test");
		//
		assertFalse(actual);
	}

	@Test
	void testContainsReturnFalseIfNotOnList() {
		// assemble
		Arrays.asList("Test", "Another Test", "Another One", "One More").forEach((e) -> list.add(e));
		// act
		boolean actual = list.contains("Not on list");
		// assemble
		assertFalse(actual);
	}

	@Test
	void testContainsReturnTrueIfOnTheList() {
		// assemble
		Arrays.asList("Test", "Another Test", "Another One", "One More").forEach((e) -> list.add(e));
		// act
		boolean actual = list.contains("Test");
		// assemble
		assertTrue(actual);
	}

	/*
	 * testing mutators
	 */
	// testing clear
	@Test
	void testClearReturnsAnEmptyList() {
		// assemble
		// Arrays.asList("Test", "Another Test", "Another One", "One More").forEach((e) -> list.add(e));
		// act
		list.clear();
		// assemble
		assertTrue(list.isEmpty());
	}

	// testing add
	@Test
	void testAddElementReturnTrueAndIncreaseSize() {
		// Assemble
		String element = "Test Node";
		int initialSize = list.size();

		// Act
		boolean actual = list.add(element);
		int finalSize = list.size();
		boolean notEmpty = list.isEmpty();
		// Assert
		assertTrue(actual);
		assertTrue(initialSize < finalSize);
		assertEquals(finalSize, 1);
		assertFalse(notEmpty);
	}

	@Test
	void testAddNullReturnsFalseExceptionAndSizeRemains() {
		assertFalse(list.add(null));
		assertTrue(list.isEmpty());
		assertEquals(0, list.size());
	}

	@Test
	void testAddMoreThanOneElement() {
		// Assemble
		String element = "Test";
		String element2 = "Another Test";
		int expectedSize = 2;

		// act
		boolean actual = list.add(element);
		int actualSize = list.size();
		boolean actual2 = list.add(element2);
		actualSize = list.size();
		// Assert
		assertTrue(actual, "item insertion failed");
		assertTrue(actual2, "item insertion failed");
		assertEquals(expectedSize, actualSize);

	}

	// remove
	@Test
	void testRemoveFromEmptyReturnFalseAndSizeRemainsZero() {
		// act
		boolean actual = list.remove("a");
		int size = list.size();
		// assert
		assertFalse(actual);
		assertEquals(0, size);
		assertTrue(list.isEmpty());
	}

	@Test
	void testRemoveInvalidElementReturnsFalse() {
		// assemble
		Arrays.asList("Test", "Another Test", "One More").forEach((e) -> list.add(e));
		int originalSize = list.size();
		// act
		boolean actual = list.remove(" ");
		// assert
		// act
		int finalSize = list.size();
		// assert
		assertFalse(actual);
		assertEquals(originalSize, finalSize);

	}

	@Test
	void testRemoveNullReturnFalseAndSizeRemains() {
		assertThrows(NullPointerException.class, () -> list.remove(null));
		assertTrue(list.isEmpty());
		assertEquals(0, list.size());
	}

	@Test
	void testRemoveElementReturnTrueAndSizeDecrease() {
		// assemble
		Arrays.asList("Test", "Another Test", "One More").forEach((e) -> list.add(e));
		String element = "One More";
		int originalSize = list.size();

		// act
		boolean isSucessful = list.remove(element);
		int finalSize = list.size();

		// assert
		assertTrue(isSucessful);
		assertEquals(2, finalSize);
		assertNotEquals(originalSize, finalSize);
	}

	/*
	 * testing producers
	 */
	// get
	@Test
	void testElementRetrival() {
		// assemble
		Arrays.asList("Test", "Another Test", "Another One", "One More").forEach((e) -> list.add(e));
		// Act
		String actual = list.get(3);
		// Assert
		assertEquals("Test", actual);
	}

	@Test
	void testElementRetrivalFromEmptyListThrowsIndexOutOfBounds() {
		// assert
		assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
	}

	@Test
	void testElementRetrivalWithInvalidIndexThrowsIndexOutOfBounds() {
		Arrays.asList("Test", "Another Test", "Another One", "One More").forEach((e) -> list.add(e));
		// assert
		assertThrows(IndexOutOfBoundsException.class, () -> list.get(10));
	}

	// first
	@Test
	void testFirstOnAnEmptyListReturnNull() {
		// act
		String actual = list.first();
		// assert
		assertNull(actual);
	}

	@Test
	void testFirstItemIsTheLastInserted() {
		// assemble
		Arrays.asList("Test", "Another Test", "Another One", "One More").forEach((e) -> list.add(e));

		// act
		String actual = list.first();
		// assert
		assertEquals("One More", actual);

	}

	// last
	@Test
	void testLastOnAnEmptyListReturnNull() {
		// act
		String actual = list.last();
		// assert
		assertNull(actual);
	}

	@Test
	void testLastIsTheFirstInserted() {
		// assemble
		Arrays.asList("Test", "Another Test", "Another One", "One More").forEach((e) -> list.add(e));

		// act
		String actual = list.last();
		// assert
		assertEquals("Test", actual);
	}
}
