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
	public void setup() {
		this.list = emptyList();
	}

	@AfterEach
	public void dispose() {
		this.list = null;
	}

	/*
	 * testing observers
	 */
	// size
	@Test
	public void testEmptyListHasSizeZero() {
		// Assemble
		int expected = 0;
		// Act
		int actual = list.size();
		// Assert
		assertEquals(actual, expected);
	}

	@Test
	public void testEmptyListIsEmpty() {
		// Act
		boolean actual = list.isEmpty();
		// Assert
		assertTrue(actual);
	}
	// contains

	@Test
	public void testContainsReturnFalseOnAnEmptyList() {
		// act
		boolean actual = list.contains("Test");
		//
		assertFalse(actual);
	}

	@Test
	public void testContainsReturnFalseIfNotOnList() {
		// assemble
		Arrays.asList("Test", "Another Test", "Another One", "One More").forEach((e) -> list.add(e));
		// act
		boolean actual = list.contains("Not on list");
		// assemble
		assertFalse(actual);
	}

	@Test
	public void testContainsReturnTrueIfOnTheList() {
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
	public void testClearReturnsAnEmptyList() {
		// assemble
		// Arrays.asList("Test", "Another Test", "Another One", "One More").forEach((e) -> list.add(e));
		// act
		list.clear();
		// assemble
		assertTrue(list.isEmpty());
	}

	// testing add
	@Test
	public void testAddElementReturnTrueAndIncreaseSize() {
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
	public void testAddNullReturnsFalseExceptionAndSizeRemains() {
		assertFalse(list.add(null));
		assertTrue(list.isEmpty());
		assertEquals(0, list.size());
	}

	@Test
	public void testAddMoreThanOneElement() {
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
	public void testRemoveFromEmptyReturnFalseAndSizeRemainsZero() {
		// act
		boolean actual = list.remove("a");
		int size = list.size();
		// assert
		assertFalse(actual);
		assertEquals(0, size);
		assertTrue(list.isEmpty());
	}

	@Test
	public void testRemoveInvalidElementReturnsFalse() {
		// assemble
		Arrays.asList("Test", "Another Test", "One More").forEach((e) -> list.add(e));
		int originalSize = list.size();
		// act
		boolean actual = list.remove("FakeCon");
		// assert
		// act
		int finalSize = list.size();
		// assert
		assertFalse(actual);
		assertEquals(originalSize, finalSize);

	}

	@Test
	public void testRemoveNullReturnFalseAndSizeRemains() {
		assertThrows(NullPointerException.class, () -> list.remove(null));
		assertTrue(list.isEmpty());
		assertEquals(0, list.size());
	}

	@Test
	public void testRemoveElementReturnTrueAndSizeDecrease() {
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
	public void testElementRetrival() {
		// assemble
		Arrays.asList("Test", "Another Test", "Another One", "One More").forEach((e) -> list.add(e));
		// Act
		String actual = list.get(3);
		// Assert
		assertEquals("Test", actual);
	}

	@Test
	public void testElementRetrivalFromEmptyListThrowsIndexOutOfBounds() {
		// assert
		assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
	}

	@Test
	public void testElementRetrivalWithInvalidIndexThrowsIndexOutOfBounds() {
		Arrays.asList("Test", "Another Test", "Another One", "One More").forEach((e) -> list.add(e));
		// assert
		assertThrows(IndexOutOfBoundsException.class, () -> list.get(10));
	}

	// first
	@Test
	public void testFirstOnAnEmptyListReturnNull() {
		// act
		String actual = list.first();
		// assert
		assertNull(actual);
	}

	@Test
	public void testFirstItemIsTheLastInserted() {
		// assemble
		Arrays.asList("Test", "Another Test", "Another One", "One More").forEach((e) -> list.add(e));

		// act
		String actual = list.first();
		// assert
		assertEquals("One More", actual);

	}

	// last
	@Test
	public void testLastOnAnEmptyListReturnNull() {
		// act
		String actual = list.last();
		// assert
		assertNull(actual);
	}

	@Test
	public void testLastIsTheFirstInserted() {
		// assemble
		Arrays.asList("Test", "Another Test", "Another One", "One More").forEach((e) -> list.add(e));

		// act
		String actual = list.last();
		// assert
		assertEquals("Test", actual);
	}
}
