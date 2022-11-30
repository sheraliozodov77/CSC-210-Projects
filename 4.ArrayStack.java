/**
 * Author:  Sherali Ozodov
 * File name: ArrayStack.java
 * Course:  CSC 210
 * Purpose: This program implements a stack using a dynamic list
 * and determine the time complexity of each method (Big-O).
 */

package pa4;

public class ArrayStack implements StackInterface {
		
	private DynamicArray stack;
    
	public ArrayStack() {
		/**
		 * Creates a constructor with default parameter
		 * and create an instance of DynamicArray.
		 * Big-O is O(1)
		 */
		stack = new DynamicArray();
	}
	public ArrayStack(DynamicArray stack) {
		/**
		 * Copy instructor
		 * Big-O is O(1)
		 */
		this.stack = stack;
	}

	@Override
	public void push(int value) {
		/*
	     * Add an element to the top of the stack.
	     * Big-O is O(1) Constant or worst case O(N) linear
	     */
		stack.add(value);
	}

	@Override
	public int pop() {
		/*
	     * Remove and return the top element in the stack.
	     * If the user attempts to pop an empty stack, ignore the
	     * request (i.e. make no changes to the stack) and return -1.
	     * Big-O is O(1)
	     */
		if(isEmpty()) return -1;
		int top = stack.get(stack.size()-1);
		stack.remove(stack.size()-1);
		return top;
	}
	
	@Override
	public int peek() {
		/*
	     * Return (but do NOT remove) the top element of the stack.
	     * If the user attempts to peek on an empty stack, ignore the
	     * request (i.e. make no changes to the stack) and return -1.
	     * Big-O is O(1)
	     */
		if(isEmpty( )) return -1;
		return stack.get(stack.size()-1);
	}
	
	@Override
	public boolean isEmpty() {
		/*
	     * Returns true if the stack has no elements.
	     * Big-O is O(1)
	     */
		return this.size() == 0;
	}

	@Override
	public int size() {
		/*
	     * Returns the number of elements in the stack.
	     * Big-O is O(1)
	     */
		return stack.size();
	}

	@Override
	public void clear() {
		/*
	     * Removes all elements from the stack.
	     * Big-O is O(n)
	     */
		int index = 0;
		while (stack.size() != 0) {
			stack.remove(stack.get(index));
			index++;
		}
	}
	
	public String toString() {
		/**
		 * Return a stack as a string in the format {0,1,2,3,4,5}
		 * where ’0’ would be at the bottom of the stack and ’5’ would be at the top.
		 * Big-O is O(n)
		 */
		String result = "{";
		if (!isEmpty()) {
	      for (int i=0; i < stack.size()-1; i++) 
		     result += stack.get(i) + ","; 
	      result += stack.get(stack.size()-1) + "}";
		  return result;
		}
		return "{}";	
	}
	
	@Override
    public boolean equals(Object obj) {	
		/**
		 * Returns a boolean after checking 
		 * two stacks are equal if their sizes and all of their elements are equal.
		 * First it convert object to an dynamic array and compares the each element and 
		 * the size of dynamic arrays. 
		 * Big-O is O(n)
		 */
		ArrayStack obj_stack = (ArrayStack) obj;
		
		if (obj_stack.size() == this.stack.size()) {
			for (int i = 0; i<this.stack.size(); i++) {
				if (this.peek() == (obj_stack.peek())) {
					return true;
				}
			}
		}
		return false;
    }
}
