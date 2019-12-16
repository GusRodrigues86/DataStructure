/*
   Description of this class
   
   Revision History
  		Gustavo, 2019.12.14: Created
 */
package com.gustavo.dataStructure.Linear.Sequential;

import java.util.Objects;

import com.gustavo.dataStructure.Linear.MyList;

/**
 * @author Gustavo
 *
 */
public class MyDoubleLinkedList<E> implements MyList<E> {

	private int size = 0;
	private Node<E> first;
	private Node<E> last;

	// Abstract function
	// AF(x) = first and last != null AND size >= 0
	// Rep Invariant
	// size >= 0, first == isHead && last == isTail

	/**
	 * Constructs a new MyDoublyLinkedList
	 */
	public MyDoubleLinkedList() {
		this.first = new Node<>(null, null, null);
		this.last = new Node<>(null, null, null);
	}
	
	/**
	 * Rep Invariant
	 * 	size >= 0 && first == isHead && last == isTail
	 */
	private void checkRep() {
		if (size < 0 && !this.first.isHead() && !this.last.isTail()) {
			throw new RuntimeException("Invalid linked list");
		}
	}

	@Override
	public boolean add(E e) {
		checkRep();
		return addFirst(e);
	}
	
	/**
	 * Add the element to the start of the list.
	 * @param e element to be added.
	 * @return true if and only if the list was changed because of the insertion
	 */
	public boolean addFirst(E e) {
		if (e == null) {
			return false;
		}
		boolean listWasEmpty = this.isEmpty();
		Node<E> newFirst = new Node<E>(first, e, first.next);
		first.setNext(newFirst);
		
		if (listWasEmpty) {
			last.setPrev(newFirst);
		}
		size++;
		checkRep();
		return true;
	}
	
	/**
	 * Add the element to the end of the list.
	 * @param e element to be added.
	 * @return true if and only if the list was changed because of the insertion
	 */
	public boolean addLast(E e) {
		if (e == null) {
			return false;
		}
		boolean listWasEmpty = this.isEmpty();
		Node<E> newLast = new Node<E>(last.prev, e, last);
		last.prev = newLast;

		if (listWasEmpty) {
			first.setNext(newLast);
		}
		size++;
		checkRep();
		return true;
	}

	@Override
	public boolean remove(E e) {
		if (e == null) {
			throw new NullPointerException();
		}
		if (this.isEmpty()) {
			return false;
		}
		if (!this.contains(e)) {
			return false;
		}
		Node<E> node = first.getNext();
		for (int i = 0; i < size; i++) {
			if (node.isHead() || node.isTail()) {
				return false;
			}
			if (e.equals(node.getItem())) {
				Node<E> prev = node.getPrev();
				Node<E> next = node.getNext();
				next.setPrev(prev);
				prev.setNext(next);
				size--;
				checkRep();
				return true;
			}
			node = node.getNext();
		}
		checkRep();
		return false;
	}
	
	/**
	 * Remove the first element of the double linked list
	 * @return true if and only if the list was changed because of the removal.
	 */
	public boolean removeFirst() {
		if (this.isEmpty()) {
			return false;
		}
		if (size == 1) {
			clear();
			return true;
		} else if (size == 2) {
			Node<E> finalNode = this.last.getPrev();
			this.first.setNext(finalNode);
			this.last.setPrev(finalNode);
			size--;
			checkRep();
			return true;
		} else {
			Node<E> secondNode = this.first.getNext().getNext();
			this.first.setNext(secondNode);
			secondNode.setPrev(first);
			size--;
			checkRep();
			return true;
		}
	}

	/**
	 * Remove the last element of the double linked list
	 * @return true if and only if the list was changed because of the removal.
	 */
	public boolean removeLast() {
		if (this.isEmpty()) {
			return false;
		}
		if (size == 1) {
			clear();
			return true;
		} else if (size == 2) {
			Node<E> firstNode = this.first.getNext();
			firstNode.setNext(last);
			firstNode.setPrev(first);
			size--;
			checkRep();
			return true;
		} else {
			Node<E> secondNode = this.last.getPrev().getPrev();
			secondNode.setNext(last);
			last.setPrev(secondNode);
			size--;
			checkRep();
			return true;
		}
	}

	@Override
	public void clear() {
		this.first.next = null;
		this.last.prev = null;
		size = 0;
		checkRep();
	}

	@Override
	public int size() {
		checkRep();
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		return (first.next == null && last.prev == null);
	}

	@Override
	public boolean contains(E e) {
		if (e == null || this.isEmpty()) {
			return false;
		}
		
		Node<E> node = this.first.getNext();
		for (int i = 0; i < size; i++) {
			if (e.equals(node.getItem())) {
				return true;
			}
			node = node.getNext();
		}
		return false;
	}

	@Override
	public E get(int index) {
		if (index > size || this.isEmpty()) {
			throw new IndexOutOfBoundsException();
		}
		Node<E> node = this.first.next;
		for (int i = 0; i < size; i++) {
			if (i == index) {
				return node.getItem();
			}
			node = node.getNext();
		}
		return null;
	}

	@Override
	public E first() {
		checkRep();
		if (this.isEmpty()) {
			return null;
		}
		return this.first.getNext().getItem();
	}

	@Override
	public E last() {
		checkRep();
		if (this.isEmpty()) {
			return null;
		}
		return this.last.getPrev().getItem();
	}

	private static class Node<E> {
		private E item;
		private Node<E> next;
		private Node<E> prev;

		/**
		 * Constructs a full node
		 * 
		 * @param prev    the node before this
		 * @param element element of this node
		 * @param next    the node after this
		 */
		Node(Node<E> prev, E element, Node<E> next) {
			this.item = element;
			this.next = next;
			this.prev = prev;
		}

		boolean isTail() {
			return next == null;
		}

		boolean isHead() {
			return prev == null;
		}

		/**
		 * @return the item
		 */
		public E getItem() {
			return item;
		}

		/**
		 * @return the next
		 */
		public Node<E> getNext() {
			return next;
		}

		/**
		 * @return the prev
		 */
		public Node<E> getPrev() {
			return prev;
		}

		/**
		 * @param next the next to set
		 */
		public void setNext(Node<E> next) {
			this.next = next;
		}

		/**
		 * @param prev the prev to set
		 */
		public void setPrev(Node<E> prev) {
			this.prev = prev;
		}

		@Override
		public int hashCode() {
			return Objects.hash(item, next, prev);
		}

		@Override
		public boolean equals(Object obj) {
			Node<E> other = (Node<E>) obj;

			return item.equals(other);
		}

	}
}
