package com.gustavo.dataStructure;

import static org.hamcrest.core.Is.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.gustavo.dataStructure.Linear.MyList;
import com.gustavo.dataStructure.Linear.Sequential.MyLinkedList;

/**
 * @author Gustavo
 *
 */
public abstract class MyListTest {
	private MyList<?> list;
	// testing observers
	
	@BeforeEach
	void setup() {
		this.list = new MyLinkedList<>();
	}

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
		
		fail();
	}
	
	@Test
	void testAddInvalidElementReturnFalseAndSizeRemains() {
		fail();
	}
	
	@Test
	void testAddNullThrowsExceptionAndSizeRemains() {
		fail();
	}
	// remove
	@Test
	void testRemoveFromEmptyReturnFalseAndSizeRemainsZero() {
		fail();
	}
	
	@Test
	void testRemoveInvalidElementReturnFalseAndSizeRemainsTheSame() {
		fail();
	}
	
	@Test
	void testRemoveNullThrowsExceptionAndSizeRemains() {
		fail();
	}
	
	@Test
	void testRemoveElementReturnTrueAndSizeDecrease() {
		fail();
	}
}
