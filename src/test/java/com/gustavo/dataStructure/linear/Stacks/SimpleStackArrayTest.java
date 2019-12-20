
package com.gustavo.dataStructure.linear.Stacks;

import com.gustavo.dataStructure.Linear.Sequential.Stacks.SimpleStack;
import com.gustavo.dataStructure.Linear.Sequential.Stacks.StackArray;

/**
 * @author Gustavo
 *
 */
public class SimpleStackArrayTest extends SimpleStackTest {

	@Override
	public SimpleStack<String> emptyInstance() {
		return new StackArray<>();
	}

}
