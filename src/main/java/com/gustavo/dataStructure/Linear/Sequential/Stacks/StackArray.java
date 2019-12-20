package com.gustavo.dataStructure.Linear.Sequential.Stacks;

import java.util.EmptyStackException;

/**
 * This is an implementation of a Stack, a last-in-first-out structure using
 * array.
 * 
 * The array can hold up to 5000 elements.
 * 
 * The array will always iterate back from the tail to provide the LIFO
 * operation
 * 
 * {@link SimpleStack}
 * 
 * @author Gustavo
 *
 */
public class StackArray<E> implements SimpleStack<E> {
	private int size = 0;
	private static final int CAPACITY = 5000;
	private E[] array;

	// AF(array) = array != null && (size <= 5000 && size >= 0)
	// Rep Invariant
	// array.length == 5000 && 0 <= size() <= 5000

	// array is wrapped in the StackArray and no external calls can alter the array.

	/**
	 * Constructs a new StackArray
	 */
	@SuppressWarnings("unchecked")
	public StackArray() {
		array = (E[]) new Object[CAPACITY];
		checkRep();
	}

	private void checkRep() {
		if (array == null) {
			throw new RuntimeException("Stack is invalid");
		}
		if (size < 0 || size > 5000) {
			throw new RuntimeException("Stack is invalid");
		}
	}

	@Override
	public boolean push(E e) {
		if (e == null) {
			throw new NullPointerException();
		}
		if (size == 5000) {
			return false;
		}
		final E element = e; // prevent external mutation.
		array[size] = element;
		size++;
		checkRep();
		return true;
	}

	@Override
	public E peek() {
		checkRep();
		if (size == 0) {
			throw new EmptyStackException();
		}
		final E element = array[size-1];
		return element;
	}

	@Override
	public E pop() {
		checkRep();
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		final E element = array[size-1];
		array[size-1] = null;
		size--;
		checkRep();
		return element;
	}

	@Override
	public int size() {
		checkRep();
		return this.size;
	}

	@Override
	public void clear() {
		array = (E[]) new Object[CAPACITY]; // Reinitializes the Stack
		size = 0;
		checkRep();
	}

	@Override
	public boolean isEmpty() {
		checkRep();
		return (size == 0 && array[0] == null);
	}

}
