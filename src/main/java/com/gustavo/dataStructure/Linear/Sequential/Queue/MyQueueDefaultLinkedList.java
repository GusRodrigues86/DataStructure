package com.gustavo.dataStructure.Linear.Sequential.Queue;

import java.util.LinkedList;

/**
 * Implementation of a Queue using the LinkedList to manage the queue.
 * This queue is not size limited.
 * 
 * @author Gustavo
 *
 */
public class MyQueueDefaultLinkedList<E> implements MyQueue<E> {
	
	private LinkedList<E> queue;
	private int size;
	// AF(Queue) = !null
	// RepInvariance = queue.size == size
	
	/**
	 * Constructs a new queue 
	 */
	public MyQueueDefaultLinkedList() {
		this.queue = new LinkedList<>();
		this.size = 0;
		checkRep();
	}
	
	public void checkRep() {
		if (queue == null) {
			throw new RuntimeException("Invalid Queue.");
		}
		if (queue.size() != size) {
			throw new RuntimeException("Invalid Queue.");
		}
	}
	
	@Override
	public boolean enqueue(E e) {
		checkRep();
		if (e == null ) {
			throw new NullPointerException();
		}
		final E copy = e;
		queue.addFirst(copy);
		size++;
		checkRep();
		return true;
	}

	@Override
	public E dequeue() {
		if (isEmpty()) {
			return null;			
		}
		final E copy = queue.getLast();
		queue.removeLast();
		size--;
		checkRep();
		return copy;
	}

	@Override
	public E peek() {
		if (isEmpty()) {
			return null;			
		}
		final E copy = queue.getLast();
		return copy;
	}

	@Override
	public boolean contains(E e) {
		if (e == null ) {
			throw new NullPointerException();
		}
		if (isEmpty()) {
			return false;
		}
		E copy = null;
		// O(n)
		for (E item : queue) {
			if (item.equals(e) ) {
				copy = item;
				break;
			}
		}
		
		return (copy != null) ? true : false;
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

	@Override
	public void clear() {
		this.queue = new LinkedList<>();
		this.size = 0;
		checkRep();
	}

}
