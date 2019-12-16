/*
   Description of this class
   
   Revision History
  		Gustavo, 2019.12.14: Created
 */
package com.gustavo.dataStructure.Linear.Sequential;

import com.gustavo.dataStructure.Linear.MyList;

/**
 * CircularList is a subclass of {@code MySinglyLinkedList} with one extra method:
 * Rotate().
 * Rotate will change who is the head of the list.
 * 
 * Because SinglyLinkedList only refers to the Head, rotate is O(n) operation
 * 
 * @author Gustavo
 *
 */
public class MyCircularlyLinkedList<E> extends MySingleLinkedList<E> {
	/**
	 * Constructs a new Circular List
	 */
	public MyCircularlyLinkedList() {
		super();
	}
	
	public MyCircularlyLinkedList(MyList<? extends E> convert) {
		this();
		for (int j = 0; j < convert.size(); j++) {
			this.add(convert.get(j));			
		}
	}

	/**
	 * @return true if able to rotate the list.
	 */
	public boolean rotate() {
		if (this.isEmpty()) {
			return false;
		}
		Node<E> node = first;
		
		final Node<E> firstNode = this.first; // will become the second
		
		int counter = 0;
		while (counter < (size -2)) {
			node = node.next;
			counter++;
		}
		Node<E> last = node.next; // copy the last node
		// node is the second last.
		
		// last becomes the head.
		this.first = node.next;
		// change the second last to last.
		node.next = last;
		// old head becomes the second
		first.next = firstNode;
		
		return true;
	}
	
	
}
