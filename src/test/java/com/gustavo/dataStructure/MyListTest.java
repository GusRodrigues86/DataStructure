package com.gustavo.dataStructure;

import static org.hamcrest.core.Is.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.gustavo.dataStructure.Linear.MyList;
import com.gustavo.dataStructure.Linear.Sequential.MySinglyLinkedList;

/**
 * @author Gustavo
 *
 */
public abstract class MyListTest {
	private MyList<String> list;

	@BeforeEach
	void setup() {
		this.list = new MySinglyLinkedList<>();
	}

	@AfterEach
	void dispose() {
		this.list = null;
	}

	// testing observers
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

	// testing mutators
	// testing addition
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
	void testRemoveInvalidElementReturnFalseAndSizeRemainsTheSame() {
		// act
		boolean actual = list.remove(" ");
		int size = list.size();
		// assert
		assertFalse(actual);
		assertEquals(0, size);
		assertTrue(list.isEmpty());
	}

	@Test
	void testRemoveNullThrowsExceptionAndSizeRemains() {
		assertFalse(list.remove(null));
		assertTrue(list.isEmpty());
		assertEquals(0, list.size());
	}

	@Test
	void testRemoveElementReturnTrueAndSizeDecrease() {
		String element = "Test";
		String element2 = "Another Test";
	}
}
