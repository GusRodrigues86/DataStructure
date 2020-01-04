package com.gustavo.dataStructure.Linear.Sequential.Queue;

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
	private int capacity;

	// AF(queue, headIndex) = queue != null && headIndex >= 0

	// Rep Invariance
	// queue.length >= 16 && queue != null
	// headIndex >= 0 && headIndex < capacity
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
		this.capacity = capacity;
		checkRep();
	}

	private void checkRep() {
		// queue.length >= 16
		// headIndex >= 0 && headIndex < capacity
		// size < queue.length && size >= 0
		if (queue.length < 16) {
			throw new RuntimeException("Invalid queue");
		}

		if (!(headIndex < queue.length && headIndex >= 0)) {
			throw new RuntimeException("Invalid queue");
		}

		if (size > queue.length || size < 0) {
			throw new RuntimeException("Invalid queue");
		}
	}
	
	/**
	 * Resizes an array to the double of the current capacity
	 */
	@SuppressWarnings("unchecked")
	private void increaseArrayCapacity() {
		final E[] copy = queue;
		final int newCapacity;
		// prevents size overflow
		if (capacity > (Integer.MAX_VALUE / 2)) {
			newCapacity = Integer.MAX_VALUE;
		} else {
			newCapacity = capacity * 2;			
		}
		
		E[] newQueue = (E[]) new Object[newCapacity];
		for (int i = 0; i < copy.length; i++) {
			newQueue[i] = copy[i];
		}
		
		this.queue = newQueue;
	}
	
	/**
	 * Resizes an array to the half of the current capacity
	 */
	@SuppressWarnings("unchecked")
	private void reduceArrayCapacity() {
		final E[] copy = queue;
		final int newCapacity;
		// min size is 16
		if ((capacity / 2) < 16) {
			newCapacity = 16;
		} else {
			newCapacity = capacity / 2;			
		}
		E[] newQueue = (E[]) new Object[newCapacity];
		for (int i = 0; i < newQueue.length; i++) {
			newQueue[i] = copy[i];
		}

		this.queue = newQueue;
		
	}

	@Override
	public boolean enqueue(E e) {
		if (e == null) {
			throw new NullPointerException();
		}
		// array resize
		if (size == queue.length) {
			increaseArrayCapacity();
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
		// array resize
		if ((capacity - 1) < (capacity / 2)) {
			reduceArrayCapacity();
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
