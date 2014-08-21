package chapter3;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Implement a set of stack, it starts a new stack when the previous stack
 * exceeds some threshold, also implement a function popAt(int index) which
 * performs a pop operation on a specific sub-stack
 * 
 * @author boyxgc
 * 
 */
public class Q3 {

	public class SetofStacks<T> {
		List<Stack<T>> stackSet;
		int threshold;

		public SetofStacks(int _threshold) {
			stackSet = new ArrayList<Stack<T>>();
			threshold = _threshold;

			stackSet.add(new Stack<T>());
		}

		public void push(T item) {
			if (stackSet.get(stackSet.size() - 1).size() >= threshold) {
				stackSet.add(new Stack<T>());
			}
			stackSet.get(stackSet.size() - 1).add(item);
		}

		public T pop() {
			if (stackSet.size() > 0) {
				T item = stackSet.get(stackSet.size() - 1).pop();

				if (stackSet.get(stackSet.size() - 1).isEmpty()) {
					stackSet.remove(stackSet.size() - 1);
				}
				return item;
			} else {
				return null;
			}
		}

		public T popAt(int index) {
			if (index < 0 || index >= stackSet.size()) {
				return null;
			}

			T item = stackSet.get(index).pop();

			if (stackSet.get(index).isEmpty()) {
				stackSet.remove(index);
			}
			return item;
		}

	}
}
