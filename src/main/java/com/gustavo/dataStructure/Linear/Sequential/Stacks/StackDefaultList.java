package com.gustavo.dataStructure.Linear.Sequential.Stacks;

import java.util.EmptyStackException;
import java.util.LinkedList;

/**
 * This is an implementation of a Stack using the default Java LinkedList
 * implementation. The Java Linked List is a Double LinkedList.
 * 
 * @author Gustavo
 *
 */
public class StackDefaultList<E> implements SimpleStack<E> {
	private int size = 0;
	private LinkedList<E> stack;
	
	// AF(stack) = stack != null
	// Rep Invariant
	// stack.isEmpty() && this.size == 0;
	//
	// The linked list is wrapped in the StackList and there are no external
	// calls can alter the list.
	
	/**
	 * Construct an empty Stack
	 */
	public StackDefaultList() {
		this.stack = new LinkedList<>();
		checkRep();
	}
	
	private void checkRep() {
		if (!stack.isEmpty() && size == 0) {
			throw new RuntimeException("Invalid stack.");
		}
		if (stack.isEmpty() && size != 0) {
			throw new RuntimeException("Invalid stack.");
		}
	}
	
	@Override
	public boolean push(E e) {
		if (e == null ) {
			throw new NullPointerException();
		}
		stack.addFirst(e);
		size++;
		checkRep();
		return true;
	}

	@Override
	public E peek() {
		if (stack.isEmpty()) {
			throw new EmptyStackException();
		}
		checkRep();
		final E e = stack.peekFirst();
		return e;
	}

	@Override
	public E pop() {
		if (stack.isEmpty()) {
			throw new EmptyStackException();
		}
		checkRep();
		final E e = stack.pop();
		size--;
		checkRep();
		return e;
	}

	@Override
	public int size() {
		checkRep();
		return this.size;
	}

	@Override
	public void clear() {
		this.stack = new LinkedList<>();
		this.size = 0;
		checkRep();
	}

	@Override
	public boolean isEmpty() {
		checkRep();
		return (size == 0 && this.stack.isEmpty());
	}
	
	@Override
	public String toString() {
		return stack.toString();
	}
}
