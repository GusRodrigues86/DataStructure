package com.gustavo.dataStructure.linear.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Test;

import com.gustavo.dataStructure.Linear.Sequential.Queue.MyQueue;

/**
 * @author Gustavo
 *
 */
public interface MyQueueTests<E> {
	MyQueue<E> createQueue();

	List<E> elementsToTest();

	E invalidElement();

	/*
	 * isEmpty case
	 */

	@Test
	default void queueStartsEmptyAndSizeZero() {
		MyQueue<E> queue = createQueue();
		assertTrue(queue.isEmpty());
		assertTrue(queue.size() == 0);
	}

	/*
	 * Test case for queue clear()
	 */

	@Test
	default void queueSizeIsZeroAndIsEmptyAfterClear() {
		// assemble
		MyQueue<E> queue = createQueue();
		elementsToTest().forEach(e -> queue.enqueue(e));
		int initialSize = queue.size();
		// act
		queue.clear();
		assertTrue(queue.isEmpty(), "Queue must be empty");
		assertTrue(initialSize > queue.size(), "Queue size before clear must be bigger than the actual size");
		assertTrue(queue.size() == 0, "Queue size must be zero");

	}

	/*
	 * Test case for enqueue
	 */

	@Test
	default void queueSizeChangesAfterInsertion() {
		MyQueue<E> queue = createQueue();
		int initialSize = queue.size();
		elementsToTest().forEach(e -> {
			assertTrue(queue.enqueue(e), "Must return true when enqueue valid element");
			int currentSize = queue.size();
			assertTrue(currentSize > initialSize, "Must increase size when enqueue valid element");
			assertFalse(queue.isEmpty(), "Can not be empty after enqueue");
		});
	}

	@Test
	default void queueAcceptedElementAndIncreaseSize() {
		MyQueue<E> queue = createQueue();
		boolean insert = queue.enqueue(elementsToTest().get(0));

		assertFalse(queue.isEmpty(), "Queue must not be empty");
		assertTrue(queue.size() == 1, "Queue size must be 1");
		assertTrue(insert, "Must return true when adding valid element");
	}

	@Test
	default void queueThrowNPEForInsertionOfNull() {
		MyQueue<E> queue = createQueue();
		assertThrows(NullPointerException.class, () -> queue.enqueue(null), "Must throew NPE when enqueuing null.");
		assertTrue(queue.isEmpty(), "Queue must be empty");
		assertTrue(queue.size() == 0, "Queue must have size 0");
	}

	/*
	 * Test case for Dequeue
	 */

	@Test
	default void queueDequeueChangeSize() {
		MyQueue<E> queue = createQueue();
		elementsToTest().forEach(e -> queue.enqueue(e));
		int initialSize = queue.size();

		queue.dequeue();
		int finalSize = queue.size();

		assertFalse(queue.isEmpty());
		assertTrue(finalSize < initialSize,
				"The final size must be less than: " + initialSize + " but was: " + finalSize);
	}

	@Test
	default void queueDequeueReturnFirstElementAdded() {
		MyQueue<E> queue = createQueue();
		E firstElement = elementsToTest().get(0);
		elementsToTest().forEach(e -> queue.enqueue(e));
		// act
		E dequeueElement = queue.dequeue();
		// assert
		assertEquals(firstElement, dequeueElement, firstElement + " must be equal to " + dequeueElement);
	}
	
	@Test
	default void queueDequeueReturnElementsInOrdelyManner() {
		MyQueue<E> queue = createQueue();
		elementsToTest().forEach(e -> queue.enqueue(e));
		int size = queue.size();
		
		// assert
		for(E element : elementsToTest()) {
			E item = queue.dequeue();
			size--;
			assertEquals(item, element, item + " must be equal to "+ element);
			assertEquals(size, queue.size(), "Size must be equal to " + queue.size() + " but was "+ size);
		}

		assertTrue(queue.isEmpty(), "After dumping the queue, list must be empty");
	}

	@Test
	default void queueDequeueReturnNullOnEmptyQueue() {
		MyQueue<E> queue = createQueue();
		assertTrue(queue.isEmpty());
		assertTrue(queue.size() == 0);

		// act
		E result = queue.dequeue();
		assertNull(result, "Must return null");
	}

	/*
	 * Peek
	 */

	@Test
	default void queuePeekOnEmptyQueueReturnsNull() {
		MyQueue<E> queue = createQueue();
		assertNull(queue.peek(), "Must be null");
	}

	@Test
	default void queueInsertionDoesntChangeFirstItem() {
		MyQueue<E> queue = createQueue();
		E e = elementsToTest().get(0);
		elementsToTest().forEach(item -> {
			queue.enqueue(item);
			boolean peek = queue.peek().equals(e);
			assertTrue(peek, "Peek must be equal to true but was " + e);
		});
	}

	/*
	 * Contains test
	 */
	
	@Test
	default void queueContainsThrowNPEIfNullIsSupplied() {
		assertThrows(NullPointerException.class, () -> createQueue().contains(null), "Must throw NPE if searching for null");
	}

	@Test
	default void queueContainsReturnFalseWhenElementIsNotOnTheQueue() {
		MyQueue<E> queue = createQueue();
		elementsToTest().forEach(e -> queue.enqueue(e));
		boolean contains = queue.contains(invalidElement());
		assertFalse(contains, "Queue must not have the element we are searching for");
	}

	@Test
	default void queueContainsReturnTrueWhenElementIsOnTheQueue() {
		MyQueue<E> queue = createQueue();
		elementsToTest().forEach(e -> queue.enqueue(e));
		E toRemove = elementsToTest().get(new Random().nextInt(elementsToTest().size()));
		// act
		boolean remove = queue.contains(toRemove);
		// assert
		assertTrue(remove, "Must return true when the element is on the Queue");
	}

}
