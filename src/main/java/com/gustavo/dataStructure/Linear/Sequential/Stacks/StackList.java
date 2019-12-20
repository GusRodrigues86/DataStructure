package com.gustavo.dataStructure.Linear.Sequential.Stacks;

import java.util.EmptyStackException;

import com.gustavo.dataStructure.Linear.Sequential.MySingleLinkedList;

/**
 * @author Gustavo
 *
 */
public class StackList<E> implements SimpleStack<E> {
	private int size = 0;
	private MySingleLinkedList<E> stack;

	// AF(stack) = stack != null
	// Rep Invariant
	// stack.isEmpty() && this.size == 0;

	// the single linked list is wrapped in the StackList and there are no external
	// calls can alter the list.
	
	/**
	 * Construct an empty Stack List 
	 */
	public StackList() {
		stack = new MySingleLinkedList<>();
		checkRep();
	}
	
	private void checkRep() {
		if (stack.isEmpty() && size != 0) {
			throw new RuntimeException("invalid stack");
		}
		if (!stack.isEmpty() && size == 0) {
			throw new RuntimeException("invalid stack");
		}
	}
	

	@Override
	public boolean push(E e) {
		if (e == null) {
			throw new NullPointerException();
		}
		stack.add(e);
		size++;
		checkRep();
		return true;
	}

	@Override
	public E peek() {
		if (this.isEmpty()) {
			throw new EmptyStackException();
		}
		checkRep();
		final E element = stack.first();
		return element;
	}

	@Override
	public E pop() {
		checkRep();
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		final E element = stack.first();
		stack.remove(element);
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
		stack.clear();
		size = 0;
		checkRep();
	}

	@Override
	public boolean isEmpty() {
		checkRep();
		return (size ==0 && stack.isEmpty());
	}
	
	@Override
	public String toString() {
		return stack.toString();
	}
}
