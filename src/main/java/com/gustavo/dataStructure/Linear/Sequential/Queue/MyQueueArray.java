package com.gustavo.dataStructure.Linear.Sequential.Queue;

/**
 * The MyQueueArray uses a fixed array to hold elements on it.
 * The size of the queue is extreme low -> 16 elements.
 * 
 * @author Gustavo
 *
 */
public class MyQueueArray<E> implements MyQueue<E> {
	
	private E[] queue;
	private int headIndex;
	private int tailIndex;
	private int size;
	
	// AF(queue, head, tailIndex) =
	// queue != null
	// headIndex >= 0 && tailIndex >= 0
	
	// Rep Invariance 
	// queue.length == 16 && queue != null
	// headIndex >= 0 && headIndex < 16
	// tailIndex >= 0 && tailIndex < 16
	// size < queue.length && size >= 0
	
	/**
	 * Constructs a new Queue with max capacity of 16 elements
	 */
	public MyQueueArray() {
		this(16);
	}
	
	@SuppressWarnings("unchecked")
	private MyQueueArray(int capacity) {
		this.queue = (E[]) new Object[capacity];
		this.tailIndex = 0;
		this.headIndex = 0;
		this.size = 0;
		checkRep();
	}
	
	private void checkRep() {
		// queue.length == 16
		// headIndex >= 0 && headIndex < 16
		// tailIndex >= 0 && tailIndex < 16
		// size < queue.length && size >= 0
		if (queue.length != 16) {
			throw new RuntimeException("Invalid queue");
		}
		
		if (!(headIndex < 16 && headIndex >= 0) || 
			!(tailIndex < 16 && tailIndex >= 0)) {
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
		// TODO Auto-generated method stub
		throw new RuntimeException("Not implemented");
	}

	@Override
	public E dequeue() {
		// TODO Auto-generated method stub
		throw new RuntimeException("Not implemented");
	}

	@Override
	public E peek() {
		// TODO Auto-generated method stub
		throw new RuntimeException("Not implemented");
	}

	@Override
	public boolean contains(E e) {
		if (e == null) {
			throw new NullPointerException();
		}
		// TODO Auto-generated method stub
		throw new RuntimeException("Not implemented");
	}

	@Override
	public boolean remove(E e) {
		if (e == null) {
			throw new NullPointerException();
		}
		// TODO Auto-generated method stub
		throw new RuntimeException("Not implemented");
	}

	@Override
	public boolean isEmpty() {
		return (tailIndex == headIndex && queue[headIndex] == null) ? true : false;
	}

	@Override
	public int size() {
		checkRep();
		return this.size;
	}

	@Override
	public void clear() {
		this.queue = (E[]) new Object[16];
		this.tailIndex = 0;
		this.headIndex = 0;
		this.size = 0;
		checkRep();
	}

}
