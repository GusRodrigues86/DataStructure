package com.gustavo.dataStructure;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import com.gustavo.dataStructure.Linear.Sequential.MySinglyLinkedList;

/**
 * @author Gustavo
 *
 */
public class MySinglyLinkedListTest extends MyListTest {
	private MySinglyLinkedList<String> list = new MySinglyLinkedList<>();
	
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
