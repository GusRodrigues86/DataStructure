package com.gustavo.dataStructure.Linear;

/**
 * List is an ordered collection of nodes. This interfaces describes the desired
 * behavior of the Lists.
 * <p>
 * Lists allow duplicated entry. The list allows insertion, removal and search
 * of elements by it's index (some Lists may not allow this). Lists should not
 * allow null. The list expects that empty nodes represents the tail or the head
 * of it.
 * <p>
 * List are 0 (zero) indexed, just like arrays.
 * 
 * @author Gustavo
 *
 */
public interface MyList<E> {
	// Mutators
	/**
	 * Add the element to the list.
	 * 
	 * @param e element to be added
	 * @return true if and only if the list was changed because of the insertion
	 * @throws NullPointerException if element is null.
	 */
	boolean add(E e);

	/**
	 * Remove the first occurrence of that element in the list.
	 * 
	 * @param e element to be removed.
	 * @return true if and only if the list was changed because of the removal.
	 * @throws NullPointerException if the element is null
	 */
	boolean remove(E e);

	/**
	 * Clears the list of all elements, if any.
	 * 
	 */
	void clear();

	// Observers

	/**
	 * Returns the amount of elements that the list holds.
	 * 
	 * @return the amount of elements that the list holds.
	 */
	int size();

	/**
	 * Returns {@code true} if and only if this list has zero elements on it and
	 * size is zero.
	 * 
	 * @return {@code true} if and only if this list has zero elements on it and
	 *         size is zero.
	 */
	boolean isEmpty();

	/**
	 * Returns {@code true} if and only if the list contains an element equals to
	 * {@code e}.
	 * 
	 * @param e element whose existence in the list will be tested.
	 * @return true if and only if the list contains at least one equal element.
	 * @throws NullPointerException if the specified element is null
	 */
	boolean contains(E e);

	// Producers
	/**
	 * Returns the element that was on the specified index.
	 * 
	 * @param index the index of the element.
	 * @return the element at the given index.
	 * @throws IndexOutOfBoundsException if ({@code index < 0 || index >= size()})
	 */
	E get(int index);
	
	/**
	 * 
	 * @return the element at the head of the list.
	 */
	E first();
	
	/**
	 * 
	 * @return the element at the tail of the list.
	 */
	E last();
}
