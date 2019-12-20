package com.gustavo.dataStructure.Linear.Sequential.Stacks;

import java.util.EmptyStackException;

/**
 * Stacks support simple operations:
 * <ul>
 * <li>push: element to the stack</li>
 * <li>peek: retrieve but not removal of the first element of the stack (last
 * inserted)</li>
 * <li>pop: Retrieval and removal of the first element from the stack (last
 * inserted)</li>
 * <li>size: how many items in the array</li>
 * </ul>
 * 
 * @author Gustavo
 *
 */
public interface SimpleStack<E> {

	/**
	 * Adds element to the top of the stack.
	 * 
	 * @param e element to be added.
	 * @return true if and only if the stack was changed because of the insertion
	 * @throws NullPointerException if element is null.
	 */
	boolean push(E e);

	/**
	 * Retrieves but does not remove item of the stack.
	 * 
	 * @return the first element on the stack (last to be inserted) or null, if
	 *         empty.
	 * @throws EmptyStackException if this stack is empty.
	 */
	E peek();

	/**
	 * Removes the top element of the stack
	 * 
	 * @return the last inserted element of the stack.
	 * @throws EmptyStackException if this stack is empty.
	 */
	E pop();

	/**
	 * The size of the stack.
	 * 
	 * @return the size of the stack or 0 if the stack is empty.
	 */
	int size();
	
	/**
	 * Clears the stack
	 */
	void clear();
	
	/**
	 * Checks if the stack is empty.
	 * @return true if and only if the stack is empty.
	 */
	boolean isEmpty();
}
