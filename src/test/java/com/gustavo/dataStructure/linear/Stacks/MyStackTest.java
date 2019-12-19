package com.gustavo.dataStructure.linear.Stacks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.gustavo.dataStructure.Linear.MyList;
import com.gustavo.dataStructure.Linear.Sequential.MySingleLinkedList;
import com.gustavo.dataStructure.Linear.Sequential.Stacks.MyStack;
import com.gustavo.dataStructure.linear.MyListTest;

/**
 * @author Gustavo
 *
 */
public class MyStackTest extends MyListTest {
	public MyStack<String> stack = new MyStack<>();
	
	@Override
	public MyList<String> emptyList() {
		stack = new MyStack<>();
		return new MyStack<>();
	}
	
	@Test
	public void testPush() {
		// assemble
		String expected = "[c, b, a]";
		String a, b, c, actual;
		boolean success;
		// act
		a= "a";
		success = stack.push(a); 
		assertTrue(success);

		b= "b";
		success = stack.push(b);
		assertTrue(success);

		c= "c";
		success = stack.push(c);
		assertTrue(success);
		
		// act
		actual = stack.toString();
		
		// assert
		assertEquals(expected, actual);
	}
	
	@Test
	public void testPushNullReturnFalse() {
		assertFalse(stack.push(null));
	}
	
	@Test
	public void testPeek() {
		// assemble
		String expected = "c";
		String c, actual;
		boolean success;
		c= "c";

		// act
		success = stack.push(c);
		actual = stack.peek();
		
		// assert
		assertEquals(expected, actual);
		assertTrue(success);
	}
	
	@Test
	public void testPeekEmptyListReturnNull() {
		assertNull(stack.peek());
	}
	
	@Override @Test
	public void testRemoveInvalidElementReturnsFalse() {
		assertFalse(stack.pop());
	}
	
	@Test
	public void testPopEmptyStackReturnsFalse() {
		assertFalse(stack.pop());
	}
	
	@Test
	public void testPopElements() {
		// assemble
		Arrays.asList("a","b","c","d").forEach((s) -> stack.add(s));
		String expected = "[c, b, a]";
		boolean actual;		
		// act
		actual = stack.pop();
		
		// assert
		assertTrue(actual);
		assertEquals(expected, stack.toString());
	}
}
