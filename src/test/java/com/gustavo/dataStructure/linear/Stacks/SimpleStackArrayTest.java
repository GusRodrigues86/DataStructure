
package com.gustavo.dataStructure.linear.Stacks;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import com.gustavo.dataStructure.Linear.Sequential.Stacks.SimpleStack;
import com.gustavo.dataStructure.Linear.Sequential.Stacks.StackArray;

/**
 * @author Gustavo
 *
 */
public class SimpleStackArrayTest extends SimpleStackTest {

	@Override
	public SimpleStack<String> emptyInstance() {
		return new StackArray<>();
	}
	
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
		Arrays.asList("Hello","World","How","Are","You","Doing","Today","?")
			.forEach(e -> stack.push(e));
		
		// act
		String actual = stack.toString();
		// assemble
		assertEquals(expected, actual);
	}
}
