package com.gustavo.dataStructure.Linear.Sequential.Queue;

/**
 * Implementation of a Queue DS. A Queue operates on First-in-first-out. The
 * queue offers specialized methods to operate over.
 * 
 * <ul>
 * <li>enqueue - add element to the queue</li>
 * <li>dequeue - remove element from the queue</li>
 * <li>peek - observes the element in the list</li>
 * <li>contains - checks if element is on the list</li>
 * <li>remove - remove element from the queue</li>
 * <li>isEmpty - checks if the queue is empty</li>
 * </ul>
 * 
 * @author Gustavo
 *
 */
public interface MyQueue<E> {
	/**
	 * Add element to the Queue
	 * 
	 * @param e to be added
	 * @return true if and only if the Queue was changed because of the insertion
	 * @throws NullPointerException if the element is null.
	 */
	boolean enqueue(E e);

	/**
	 * Removes and return the first element of the Queue.
	 * 
	 * @return the first element of the Queue, or null if empty.
	 */
	E dequeue();

	/**
	 * Returns the first element of the Queue, but does not remove from it.
	 * 
	 * @return the first element of the Queue, or null if empty.
	 */
	E peek();

	/**
	 * Checks if element is present in the Queue
	 * 
	 * @param e element to be checked
	 * @return true if and only if the supplied element is on the Queue
	 * @throws NullPointerException if the supplied element is null.
	 */
	boolean contains(E e);

	/**
	 * Remove element from the Queue if present.
	 * 
	 * @param e element to be removed.
	 * @return true if and only if the Queue was changed because of the removal.
	 * @throws NullPointerException if supplied element is null.
	 */
	boolean remove(E e);

	/**
	 * Checks if the Queue is empty.
	 * 
	 * @return true if and only if the stack is empty.
	 */
	boolean isEmpty();
	
	/**
	 * The size of the Queue
	 * @return the size of the Queue
	 */
	int size();
	
	/**
	 * Clear the Queue
	 */
	void clear();
	
}
