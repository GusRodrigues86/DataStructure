package com.gustavo.dataStructure.Linear.Sequential.Stacks;

import com.gustavo.dataStructure.Linear.Sequential.MySingleLinkedList;

/**
 * Implementation of a Stack, a Last-in-first-out (LIFO) structure. After
 * creation, a stack will always be empty.
 * 
 * Add an element is push it to the stack. Both operations will yield the same
 * result. Removal of an element is to pop it from the stack. Operation to
 * traverse the stack will cause exceptions.
 * 
 * This implementation is a simple inheritance exercise.
 * 
 * 
 * @author Gustavo
 *
 */
public class MyStack<E> extends MySingleLinkedList<E> {

	public MyStack() {

	}

	/**
	 * Adds element to the top of the stack.
	 * 
	 * @param e element to be added.
	 * @return true if and only if the stack was changed because of the insertion
	 */
	public boolean push(E e) {
		return super.add(e);
	}

	/**
	 * Removes the top element of the stack
	 * 
	 * @return true if and only if the stack was changed because of the insertion.
	 */
	public boolean pop() {
		if (this.isEmpty()) {
			return false;
		}
		return super.remove(super.first());
	}

	/**
	 * Retrieves but does not remove item of the stack.
	 * 
	 * @return the first element on the stack (last to be inserted).
	 */
	public E peek() {
		return this.first();
	}

	@Override
	public boolean remove(E e) {
		if (e == null) {
			throw new NullPointerException();
		}
		return pop();
	}

}
