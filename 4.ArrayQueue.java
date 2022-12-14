/**
 * Author:  Sherali Ozodov
 * File name: ArrayQueue.java
 * Course:  CSC 210
 * Purpose: This program implements a queue using a dynamic array
 * and determine the time complexity of each method (Big-O).
 * 
 */

package pa4;

public class ArrayQueue implements QueueInterface{

	private DynamicArray queue;
	
	
	public ArrayQueue() {
		/**
		 * Creates a constructor with default parameter
		 * and create an instance of DynamicArray.
		 * Big-O is O(1)
		 */
		queue = new DynamicArray();
	}
	public ArrayQueue(DynamicArray queue) {
		/**
		 * Copy instructor
		 * Big-O is O(1)
		 */
		this.queue = queue;
	}
	
	@Override
	public void enqueue(int value) {
		/*
	     * Add an element to the back of the queue.
	     * Big-O is O(1) Constant or worst case O(N) linear
	     */
		queue.add(value);
		
	}

	@Override
	public int dequeue() {
	    /*
	     * Remove and return the front element in the queue.
	     * 
	     * If the user attempts to dequeue from an empty queue, ignore the
	     * request (i.e. make no changes to your queue) and return -1.
	     * Big-O is O(1)
	     */
		if(isEmpty()) return -1;
		int front = queue.get(0);
		queue.remove(0);
		return front;
	}

	@Override
	public int peek() {
	    /*
	     * Return (but do NOT remove) the front element of the queue.
	     * If the user tries to peek on an empty queue, ignore the
	     * request (i.e. make no changes to your queue) and return -1.
	     * Big-O is O(1)
	     */
		if(isEmpty()) return -1;
		return queue.get(0);
	}
	
	@Override
	public boolean isEmpty() {
	    /*
	     * Returns true if the queue has no elements.
	     * Big-O is O(1)
	     */
		return this.size() == 0;
	}

	@Override
	public int size() {
		/*
	     * Returns the number of elements in the queue.
	     * Big-O is O(1)
	     */
		return queue.size();
	}

	@Override
	public void clear() {
		/*
	     * Removes all elements from the stack.
	     * Big-O is O(n)
	     */
		int index = 0;
		while (queue.size() != 0) {
			queue.remove(queue.get(index));
			index++;
		}
	}
	
	public String toString()  {
		/**
		 * Return a queue as a string in the format {0,1,2,3,4,5}
		 * where ???0??? would be at the front of the queue and ???5??? would be at the back.
		 * Big-O is O(n)
		 */
		String result = "{";
		if (!isEmpty()) {
	      for (int i=0; i < queue.size()-1; i++) 
		     result += queue.get(i) + ","; 
	      result += queue.get(queue.size()-1) + "}";
		  return result;
		}
		return "{}";
		
	}
	
	@Override
    public boolean equals(Object obj) {	
		/**
		 * Returns a boolean after checking 
		 * two queues are equal if their sizes and all of their elements are equal.
		 * First it convert object to an dynamic array and compares the each element and 
		 * the size of queues.
		 * Big-O is O(n)
		 */
		ListQueue obj_queue = (ListQueue) obj;
		
		if (obj_queue.size() == this.queue.size()) {
			for (int i = 0; i<this.queue.size(); i++) {
				if (this.peek() == (obj_queue.peek())) {
					return true;
				}
			}
		}
		return false;
    }
}
