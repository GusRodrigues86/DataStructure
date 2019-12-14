package com.gustavo.dataStructure.Linear.Sequential;

import com.gustavo.dataStructure.Linear.MyList;

/**
 * A singly linked list
 * 
 * @author Gustavo
 *
 */
public class MySinglyLinkedList<E> implements MyList<E> {
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
	public MySinglyLinkedList() {
		this.first = new EmptyNode<E>();
		checkRep();
	}

	private void checkRep() {
		if (size == 0 && !first.isEmpty()) {
			throw new RuntimeException("Invalid list");
		} else if (size == 1 && !this.first.next.isLast()) {
			throw new RuntimeException("Invalid list");
		} else if (size > 1 && !this.first.isLast()) {
			throw new RuntimeException("Invalid list");
		}
	}

	@Override
	public boolean add(E e) {
		
		return addFirstElement(e);
	}

	private boolean addFirstElement(E e) {
		// O(1) operation at the head.
		checkRep();
		if (e != null) {
			Node<E> oldNode = this.first; // copy of actual first node.
			this.first = new Node<>(e, oldNode); // actual first node becomes the next.
			size++;
			checkRep();
			return true;
		}
		return false;
	}

	@Override
	public boolean remove(E e) {
		final E element = e; 
		if (e == null) {
			return false;
		}
		if (this.isEmpty()) {
			return false;
		}
		Node<E> actual = this.first;
		// Operation cost O(n) (best case O(1), worst, O(n)
		if (actual.item.equals(element)) {
			return removeFirst();			
		} else {
			return unlinkElement(element);
		}
	}

	private boolean removeFirst() {
		if (this.first.isEmpty()) {
			// the list is empty. no operation
			return false;
		}
		final Node<E> firstNode = first.next; // next will become 1st.
		first = firstNode;
		size--;
		checkRep();
		return true;
	}
	
	private boolean unlinkElement(E e) {
		final E element = e; 
		boolean checker = true;
		Node<E> actual = this.first;
		Node<E> previous;
		int counter = 0;
		do {
			checker = !actual.item.equals(element);
			previous = actual;
			actual = actual.next;
			counter++;
			
			if (counter > size) { // list doesn't contains element
				return false;
			}
		}
		while (checker);
		// found the item, now unlink.
		previous.next = actual.next;
		return true;
	}

	@Override
	public void clear() {
		// O(1) operation.
		this.first = new EmptyNode<E>();
		checkRep();
	}

	@Override
	public int size() {
		checkRep();
		// O(1) operation
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		checkRep();
		return (this.size == 0 && first.isEmpty()) ? true : false;
	}

	@Override
	public boolean contains(E e) {
		if (e == null) {
			return false;
		}
		final E element = e;
		Node<E> node = first;
		for (int i = 0; i < size; i++) {
			if (node.item.equals(element)) {
				return true;
			} else {
				node = node.next;
			}
		}
			
		return false;
	}

	@Override
	public E get(int index) {
		if (this.isEmpty() || index > size) {
			throw new IndexOutOfBoundsException();
		}
		// O(1)
		if (index == 0) {
			return first.item;
		} // O(1)
		if (index == 1) {
			if (first.isEmpty()) {
				throw new IndexOutOfBoundsException();
			}
			return first();
		}
		// Remaining cases: O(1) [Best] to O(n) [Worst]
		Node<E> actual = this.first;
		int counter = 0;
		while (counter < index) {
			actual = actual.next;
			counter++;
		}
		
		return actual.item;
	}
		
	@Override
	public E first() {
		checkRep();
		return this.first.item;
	}

	@Override
	public E last() {
		// O(1) if size == 1, then O(n) worst case
		checkRep();
		int counter = 0;
		Node<E> element = this.first;
		while (counter < (size - 1)) {
			element = element.next;
			counter++;
		}
		return element.item;
	}

	@Override
	public String toString() {
		StringBuffer nodes = new StringBuffer();
		Node<E> node = first;
		for (int i = 0; i < size; i++) {
			if (i == (size -1)) {
				nodes.append(node.item);
			} else {
				nodes.append(node.item + ", ");				
			}
			node = node.next;
		}
		return "["+ nodes.toString() +"]";
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
		 * 
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
			return (next == null) ? true : next.isLast();
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

		@Override
		public boolean isEmpty() {
			return true;
		}

		@Override
		public boolean isLast() {
			return true;
		}

	}

	

}
