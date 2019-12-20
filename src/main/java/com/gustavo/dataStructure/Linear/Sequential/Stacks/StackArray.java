package com.gustavo.dataStructure.Linear.Sequential.Stacks;

/**
 * This is an implementation of a Stack, a last-in-first-out structure using
 * array.
 * 
 * The array can hold up to 5000 elements.
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

	// AF(array) =
	// Rep Invariant array.length == size
	// array.length >= 0 && < 5000: size - 1 != null && size + 1 == null
	// array.length == 0 if array[0] == null
	// array.length == 5000 if array[5000] != null
	
	// array is wrapped in the StackArray and no external calls can alter the array. 

	/**
	 * Constructs a new StackArray
	 */
	@SuppressWarnings("unchecked")
	public StackArray() {
		array = (E[]) new Object[CAPACITY];
	}

	@Override
	public boolean push(E e) {
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
