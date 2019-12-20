/*
   Description of this class
   
   Revision History
  		Gustavo, 2019.12.19: Created
 */
package com.gustavo.dataStructure.linear.Stacks;

import com.gustavo.dataStructure.Linear.Sequential.Stacks.SimpleStack;
import com.gustavo.dataStructure.Linear.Sequential.Stacks.StackList;

/**
 * @author Gustavo
 *
 */
public class SimpleStackListTest extends SimpleStackTest {

	@Override
	public SimpleStack<String> emptyInstance() {
		return new StackList<>();
	}

}
