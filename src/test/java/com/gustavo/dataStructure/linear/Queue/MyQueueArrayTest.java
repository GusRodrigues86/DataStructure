/*
   Description of this class
   
   Revision History
  		Gustavo, 2019.12.23: Created
 */
package com.gustavo.dataStructure.linear.Queue;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.gustavo.dataStructure.Linear.Sequential.Queue.MyQueue;
import com.gustavo.dataStructure.Linear.Sequential.Queue.MyQueueArray;

/**
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

	@Override
	public E invalidElement() {
		return (E) "Invalid";
	}

	@Test
	public void enqueueMoreThan16ReturnFalse() {
		MyQueue<E> queue = createQueue();
		elementsToTest().forEach(e -> queue.enqueue(e));
		@SuppressWarnings("unchecked")
		List<E> extra = (List<E>) Arrays.asList("Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen",
				"Sixteen");
		extra.forEach(e -> queue.enqueue(e));
		E e = (E) "Oops";
		// act
		boolean result = queue.enqueue(e);
		// assert
		assertFalse(result, "Cannot add more than 16 elements");
	}

}
