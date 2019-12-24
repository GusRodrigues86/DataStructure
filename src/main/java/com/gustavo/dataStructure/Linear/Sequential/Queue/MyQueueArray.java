package com.gustavo.dataStructure.Linear.Sequential.Queue;

import java.util.ArrayList;

/**
 * The MyQueueArray uses a fixed array to hold elements on it. The size of the
 * queue is extreme low -> 16 elements.
 * 
 * @author Gustavo
 *
 */
public class MyQueueArray<E> implements MyQueue<E> {

	private E[] queue;
	private int headIndex;
	private int size;

	// AF(queue, headIndex) = queue != null && headIndex >= 0

	// Rep Invariance
	// queue.length == 16 && queue != null
	// headIndex >= 0 && headIndex < 16
	// size < queue.length && size >= 0

	/**
	 * Constructs a new Queue with max capacity of 16 elements
	 */
	public MyQueueArray() {
		this(16);
	}

	/**
	 * Creates a new Array and reset all parameters.
	 * 
	 * @param capacity the capacity of the new queue array
	 */
	@SuppressWarnings("unchecked")
	private MyQueueArray(int capacity) {
		this.queue = (E[]) new Object[capacity];
		this.headIndex = 0;
		this.size = 0;
		checkRep();
	}

	private void checkRep() {
		// queue.length == 16
		// headIndex >= 0 && headIndex < 16
		// size < queue.length && size >= 0
		if (queue.length != 16) {
			throw new RuntimeException("Invalid queue");
		}

		if (!(headIndex < 16 && headIndex >= 0)) {
			throw new RuntimeException("Invalid queue");
		}

		if (size > queue.length || size < 0) {
			throw new RuntimeException("Invalid queue");
		}
	}

	@Override
	public boolean enqueue(E e) {
		if (e == null) {
			throw new NullPointerException();
		}
		if (size == queue.length) {
			return false;
		}

		final E copy = e;
		int available = (headIndex + size) % this.queue.length;
		queue[available] = copy;
		size++;
		checkRep();
		return true;
	}

	@Override
	public E dequeue() {
		checkRep();
		if (this.isEmpty()) {
			return null;
		}
		final E copy = queue[headIndex];
		queue[headIndex] = null;
		headIndex = (headIndex + 1) % queue.length;
		size--;
		checkRep();
		return copy;

	}

	@Override
	public E peek() {
		if (isEmpty()) {
			return null;
		}
		final E copy = queue[headIndex];
		return copy;
	}

	@Override
	public boolean contains(E e) {
		if (e == null) {
			throw new NullPointerException();
		}
		final E compare = e;
		checkRep();
		for (int i = 0; i < queue.length; i++) {
			E element = queue[i];
			if (compare.equals(element)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean isEmpty() {
		return (size == 0) ? true : false;
	}

	@Override
	public int size() {
		checkRep();
		return this.size;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void clear() {
		this.queue = (E[]) new Object[16];
		this.headIndex = 0;
		this.size = 0;
		checkRep();
	}

}
