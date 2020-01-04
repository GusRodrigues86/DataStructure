package com.gustavo.dataStructure.linear.Queue;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.gustavo.dataStructure.Linear.Sequential.Queue.MyQueue;
import com.gustavo.dataStructure.Linear.Sequential.Queue.MyQueueArray;

/**
 * Test implementation specific for the array version of the queue
 * 
 * @author Gustavo
 *
 */
public class MyQueueArrayTest<E> implements MyQueueTests<E> {

	@Override
	public MyQueue<E> createQueue() {
		return new MyQueueArray<>();
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

	@SuppressWarnings("unchecked")
	@Test
	public void enqueueWillKeppExpanding() {
		MyQueue<E> queue = createQueue();
		elementsToTest().forEach(e -> queue.enqueue(e));
		List<E> extra = (List<E>) Arrays.asList("Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen",
				"Fourteen", "Fifteen", "Sixteen");
		extra.forEach(e -> queue.enqueue(e));
		E e = (E) "Oops";
		// act
		boolean result = queue.enqueue(e);
		// assert
		assertTrue(result, "Must allow more than 16 elements");
	}
}
