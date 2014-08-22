package chapter3;

import java.util.Queue;
import java.util.Stack;

/**
 * Implement a MyQueue class which implements a queue using two stacks.
 * 
 * @author boyxgc
 * 
 */
public class Q5 {

	/*
	 * add new elements to newStack, remove from oldStack (if oldStack is empty,
	 * move data in newStack to oldStack)
	 */
	public class MyQueue<T> {
		Stack<T> newStack;
		Stack<T> oldStack;

		public MyQueue() {
			newStack = new Stack<T>();
			oldStack = new Stack<T>();
		}

		/* time complexity O(1) */
		public void add(T item) {
			newStack.push(item);
		}

		/* average time complexity O(1) */
		public T remove() {
			if (oldStack.isEmpty()) {
				/* shift data from newStack to oldStack */
				while (!newStack.isEmpty()) {
					oldStack.push(newStack.pop());
				}
			}
			return oldStack.pop();
		}
	}

	public static void main(String[] args) {
		MyQueue<Integer> queue = new Q5().new MyQueue<Integer>();
		queue.add(1);
		queue.add(2);
		queue.add(3);
		queue.add(4);

		System.out.println(queue.remove());
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		System.out.println(queue.remove());
	}
}
