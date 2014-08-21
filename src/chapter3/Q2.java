package chapter3;

import java.util.Stack;

/**
 * Implement a stack which has a function min which returns the minimum element,
 * push, pop and min all operate in O(1) time
 * 
 * @author boyxgc
 * 
 */
public class Q2 {

	/*
	 * use another stack to track mins
	 */
	public class StackWithMin extends Stack<Integer> {

		private static final long serialVersionUID = 1L;

		Stack<Integer> minStack;

		public StackWithMin() {
			minStack = new Stack<Integer>();
		}

		public void push(int data) {
			super.push(data);
			if (minStack.size() == 0
					|| (!minStack.isEmpty() && data <= minStack.peek())) {
				minStack.push(data);
			}
		}

		public Integer pop() {
			int data = super.pop();
			if (data == minStack.peek()) {
				minStack.pop();
			}
			return data;
		}

		public Integer min() throws Exception {
			if (!minStack.isEmpty()) {
				return minStack.peek();
			} else {
				throw new Exception("Error getting min from emtpy stack!");
			}
		}
	}
}
