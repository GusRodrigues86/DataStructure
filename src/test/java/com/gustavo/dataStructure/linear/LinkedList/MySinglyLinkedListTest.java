package com.gustavo.dataStructure.linear.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import com.gustavo.dataStructure.Linear.MyList;
import com.gustavo.dataStructure.Linear.Sequential.MySingleLinkedList;
import com.gustavo.dataStructure.linear.MyListTest;

/**
 * @author Gustavo
 *
 */
public class MySinglyLinkedListTest extends MyListTest {
	
	@Override
	public MyList<String> emptyList() {
		return new MySingleLinkedList<>();
	}
	
	@Test
	void testToStringOnEmptyList() {
		// Assemble
		String expected = "[]";
		// act
		String actual = list.toString();
		// assert
		assertEquals(expected, actual);
	}
	
	@Test
	void testToStringOnList() {
		// Assemble
		Arrays.asList("list","a","is","This").forEach(e -> list.add(e));
		String expected = "[This, is, a, list]";
		// act
		String actual = list.toString();
		// assert
		assertEquals(expected, actual);
	}

}
