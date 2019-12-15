/*
   Description of this class
   
   Revision History
  		Gustavo, 2019.12.14: Created
 */
package com.gustavo.dataStructure;

import org.junit.jupiter.api.BeforeEach;

import com.gustavo.dataStructure.Linear.Sequential.MyDoubleLinkedList;

/**
 * @author Gustavo
 *
 */
public class MyDoubleLinkedListTest extends MyListTest {
	
	@BeforeEach
	void init() {
		super.list = new MyDoubleLinkedList<>(); 
	}
	
	
}
