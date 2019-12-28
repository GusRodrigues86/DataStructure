package com.gustavo.dataStructure.linear.Queue;

import java.util.Arrays;
import java.util.List;

import com.gustavo.dataStructure.Linear.Sequential.Queue.MyQueue;
import com.gustavo.dataStructure.Linear.Sequential.Queue.MyQueueDefaultLinkedList;

/**
 * @author Gustavo
 *
 */
public class MyQueueDefaultLinkedListTest<E> implements MyQueueTests<E> {

	@Override
	public MyQueue<E> createQueue() {
		return new MyQueueDefaultLinkedList<>();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<E> elementsToTest() {
		return (List<E>) Arrays.asList("Test", "Case", "Hello", "World", "End");
	}

	@SuppressWarnings("unchecked")
	@Override
	public E invalidElement() {
		return (E) "Invalid";
	}

}
