/*
   Description of this class
   
   Revision History
  		Gustavo, 2019.12.12: Created
 */
package com.gustavo.dataStructure.Linear.Sequential;

import java.security.DrbgParameters.NextBytes;

import com.gustavo.dataStructure.Linear.MyList;
import com.sun.jdi.InvalidTypeException;

/**
 * A singly linked list
 * 
 * @author Gustavo
 *
 */
public class MyLinkedList<E> implements MyList<E> {
	private int size = 0;
	private Node<E> first;

	// Abstract function
	// AF(x) = Node != null AND size >= 0
	// Rep Invariant
	// size == 0 ? first == emptyNode : first != emptyNode &&
	// size > 0 ? first != emptyNode

	/**
	 * Constructs an empty Single Linked List
	 */
	public MyLinkedList() {
		this.first = new EmptyNode<E>();
		checkRep();
	}

	private void checkRep() {
		if (size == 0 && !first.isLast()) {
			throw new RuntimeException("Invalid list");
		}
		if (size > 1 && first.isLast()) {
			throw new RuntimeException("Invalid list");
		}
	}

	@Override
	public boolean add(E e) {
		if (e != null) {
			// if size == 0, starts with the head.
			if (size == 0) {
				addFirstElement(e);
				return true;
			} else {
				// if size > 1 and add not defined not defined, always append to the end.
				addToTheTail(e);
				return true;
			}
		}
		return false;
	}

	private boolean addFirstElement(E e) {
		checkRep();
		if (e != null) {
			Node<E> oldNode = this.first; // copy of actual first node.
			this.first = new Node<>(e, oldNode); // actual first node becomes the next.
			size++;
			return true;
		}
		throw new NullPointerException();
	}

	private boolean addToTheTail(E e) {
		// best case O(1), worst case, O(n).
		if (e != null) {
			// empty list, starts on head.
			if (this.isEmpty()) {
				addFirstElement(e);
			}
			
			Node<E> nextNode = this.first.next;
			// next node until last node.
			while(!nextNode.isLast()) {
				nextNode = nextNode.next;
			}
			Node<E> newTailNode = new Node<E>(e, new EmptyNode<E>());
			nextNode = newTailNode;
			size++;
			return true;
		}
		return false;
	}

	@Override
	public boolean remove(E e) {
		// TODO Auto-generated method stub
		throw new RuntimeException("Not implemented");
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		throw new RuntimeException("Not implemented");
	}

	@Override
	public int size() {
		checkRep();
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		checkRep();
		return (this.size == 0 && first.isEmpty()) ? true : false;
	}

	@Override
	public boolean contains(E e) {
		// TODO Auto-generated method stub
		throw new RuntimeException("Not implemented");
	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		throw new RuntimeException("Not implemented");
	}

	/**
	 * A node holds the item and the next item.
	 * <p>
	 * A null node is an empty node. The last node has null as next.
	 * <p>
	 * A node is mutable. In case the item is empty and knows the next node, this is
	 * an invalid state. If the next item is not null, then it type must be the same
	 * as the item.
	 * 
	 * @author Gustavo
	 *
	 * @param <E> The type of the node.
	 */
	private static class Node<E> {
		E item;
		Node<E> next;
		// AF
		// Rep Invariant
		// item == null -> next == null
		// item != null -> (next == null) ? valid : next.type == item.type;

		/**
		 * Construct a Node that knows the next element.
		 * @param item to be inserted
		 * @param next the next element of the list.
		 */
		public Node(E item, Node<E> next) {
			this.item = item;
			this.next = next;
			checkRep();
		}

		private void checkRep() {
			if (item == null) {
				if (next != null)
					throw new NullPointerException("invalid node");
			} else {
				if (!next.isLast()) {
					throw new RuntimeException("Invalid node");
				}
				// do nothing
			}
		}

		public boolean isEmpty() {
			checkRep();
			return (item == null && next == null) ? true : false;
		}

		public boolean isLast() {
			checkRep();
			return (next == null) ? true : false;
		}

		@Override
		public String toString() {
			checkRep();
			return (isEmpty()) ? "Empty node" : this.item.toString();
		}

	}

	private static class EmptyNode<E> extends Node<E> {

		public EmptyNode() {
			super(null, null);
		}

	}

}
