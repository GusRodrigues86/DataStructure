package com.gustavo.dataStructure.Linear.Sequential.Stacks;

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
		// TODO Auto-generated method stub
		throw new RuntimeException("Not implemented");
	}

	@Override
	public E peek() {
		// TODO Auto-generated method stub
		throw new RuntimeException("Not implemented");
	}

	@Override
	public E pop() {
		// TODO Auto-generated method stub
		throw new RuntimeException("Not implemented");
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		throw new RuntimeException("Not implemented");
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		throw new RuntimeException("Not implemented");
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		throw new RuntimeException("Not implemented");
	}

}
