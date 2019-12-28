package com.gustavo.dataStructure.linear.Stacks;

import com.gustavo.dataStructure.Linear.Sequential.Stacks.SimpleStack;
import com.gustavo.dataStructure.Linear.Sequential.Stacks.StackDefaultList;

/**
 * Test suite for the Stack using Java Util Linked List.
 * 
 * @author Gustavo
 *
 */
public class StackDefaultListTest extends SimpleStackTest {

	@Override
	public SimpleStack<String> emptyInstance() {
		return new StackDefaultList<>();
	}

}
