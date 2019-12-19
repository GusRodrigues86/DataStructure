/*
   Description of this class
   
   Revision History
  		Gustavo, 2019.12.14: Created
 */
package com.gustavo.dataStructure.linear.LinkedList;

import org.junit.jupiter.api.BeforeEach;

import com.gustavo.dataStructure.Linear.MyList;
import com.gustavo.dataStructure.Linear.Sequential.MyDoubleLinkedList;
import com.gustavo.dataStructure.linear.MyListTest;

/**
 * @author Gustavo
 *
 */
public class MyDoubleLinkedListTest extends MyListTest {
	
	@Override
	public MyList<String> emptyList() {
		return new MyDoubleLinkedList<>();
	}	
	
}