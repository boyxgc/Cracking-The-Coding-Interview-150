package chapter3;

import java.util.Stack;

/**
 * Sort a stack in ascending order (with the highest on the top), you may use at
 * most one additional stack
 * 
 * @author boyxgc
 * 
 */
public class Q6 {

	/*
	 * time complexity O(n^2)
	 */
	public static void sortStack(Stack<Integer> stack) {
		int sortedNum = 0;
		int tobeSortedNum = stack.size();

		Stack<Integer> buffer = new Stack<Integer>();
		while (sortedNum < tobeSortedNum) {
			int min = Integer.MAX_VALUE;
			/* copy from unsorted stack to buffer to find min */
			while (stack.size() > sortedNum) {
				int item = stack.pop();
				if (item < min) {
					min = item;
				}
				buffer.push(item);
			}

			/* push the min to the bottom of other unsorted items */
			stack.push(min);

			/* copy back to unsorted stack, skip the min */
			boolean skippMin = true;
			while (buffer.size() > 0) {
				int item = buffer.pop();
				if (item == min && skippMin) {
					/* only skip one item that equals to min */
					skippMin = false;
				} else {
					stack.push(item);
				}
			}

			sortedNum++;
		}
	}

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(3);
		stack.push(2);
		stack.push(5);
		stack.push(1);
		stack.push(4);
		stack.push(2);

		sortStack(stack);

		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
	}
}
