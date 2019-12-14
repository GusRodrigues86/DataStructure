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
		if (e == null) {
			return false;
		}
		// Operation cost O(n) (best case O(1), worst, O(n)
		if (first.item.toString().equalsIgnoreCase(e.toString())) {
			return removeFirst();			
		}
		return false;
	}

	private boolean removeFirst() {
		if (this.first.isEmpty()) {
			// the list is empty. no operation
			checkRep();
			return false;
		}
		Node<E> firstNode = first.next; // next will become 1st.
		first = firstNode;
		size--;
		checkRep();
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
