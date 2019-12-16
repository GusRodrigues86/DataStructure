/*
   Description of this class
   
   Revision History
  		Gustavo, 2019.12.14: Created
 */
package com.gustavo.dataStructure;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.gustavo.dataStructure.Linear.MyList;
import com.gustavo.dataStructure.Linear.Sequential.MyCircularlyLinkedList;
import com.gustavo.dataStructure.Linear.Sequential.MySingleLinkedList;

/**
 * @author Gustavo
 *
 */
public class MyCircularlyLinkedListTest extends MyListTest {

	private MyCircularlyLinkedList<String> cList = new MyCircularlyLinkedList<>();
	
	@Override
	public MyList<String> emptyList() {
		return new MyCircularlyLinkedList<>();
	}

	@AfterEach
	void discard() {
		list = null;
		list = null;
	}

	// start from a list
	@Test
	void testConvertingAMySinglyLinkedListIntoMyCircularlyList() {
		MyList<String> otherList = new MySingleLinkedList<>();
		Arrays.asList("Test", "Test case", "Another", "Other").forEach(e -> otherList.add(e));
		int oSize = otherList.size();
		// act
		list = new MyCircularlyLinkedList<>(otherList);
		int cSize = list.size();
		// assert
		assertEquals(oSize, cSize);
	}

	// rotate test cases
	@Test
	void testRotateReturnsFalseOnAEmptyList() {
		// act
		boolean actual = cList.rotate();
		// assert
		assertFalse(actual);
		assertEquals(0, cList.size());
	}

	@Test
	void testRotateTailBecomesHead() {
		// assemble
		Arrays.asList("Test", "Test case", "Another", "Other").forEach(e -> cList.add(e));

		/* [Other, Another, Test case, Test] */
		String oldHead = cList.first(); // Other
		String oldSecond = cList.get(1); // Another
		String oldThird = cList.get(2); // Test case
		String oldTail = cList.last(); // Test

		// act
		boolean rotated = cList.rotate();
		/* [Test, Other, Another, Test case] */
		String head = cList.first(); // Test
		String second = cList.get(1); // Other
		String third = cList.get(2); // Another
		String tail = cList.last(); // Test case
		// assert
		assertTrue(rotated);

		assertEquals(oldHead, second);
		assertEquals(oldSecond, third);
		assertEquals(oldThird, tail);
		assertEquals(oldTail, head);

	}

	@Test
	void testRotateLoop() {
		// assemble
		Arrays.asList("Test", "Test case", "Another", "Other").forEach(e -> cList.add(e));
		/* [Other, Another, Test case, Test] */
		String oldHead = cList.first(); // Other
		String oldSecond = cList.get(1); // Another
		String oldThird = cList.get(2); // Test case
		String oldTail = cList.last(); // Test

		// act
		cList.rotate();
		cList.rotate();
		cList.rotate();
		cList.rotate(); // barrel roll done.
		/* [Test, Other, Another, Test case] */
		String head = cList.first(); // Test
		String second = cList.get(1); // Other
		String third = cList.get(2); // Another
		String tail = cList.last(); // Test case
		
		// assert
		assertEquals(oldHead, head);
		assertEquals(oldSecond, second);
		assertEquals(oldThird, third);
		assertEquals(oldTail, tail);
	}



}
