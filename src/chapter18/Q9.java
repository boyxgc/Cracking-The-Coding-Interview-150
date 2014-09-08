package chapter18;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Numbers are randomly generated and passed to a method. Write a program to
 * find and maintain the median values as new values are generated
 * 
 * @author boyxgc
 * 
 */
public class Q9 {

	public class IntComparator implements Comparator<Integer> {

		private boolean flip;

		public IntComparator(boolean isMaxQueue) {
			flip = isMaxQueue;
		}

		@Override
		public int compare(Integer arg0, Integer arg1) {
			// TODO Auto-generated method stub

			if (arg0 == arg1) {
				return 0;
			} else if (arg0 < arg1) {
				return flip ? 1 : -1;
			} else {
				return flip ? -1 : 1;
			}
		}

	}

	public class DataStream {
		private PriorityQueue<Integer> leftMaxQueue; // for numbers <= median
		private PriorityQueue<Integer> rightMinQueue; // for numbers > median

		public DataStream() {
			leftMaxQueue = new PriorityQueue<Integer>(100, new IntComparator(
					true));
			rightMinQueue = new PriorityQueue<Integer>(100, new IntComparator(
					false));
		}

		public void addData(int num) {
			if (leftMaxQueue.isEmpty() && rightMinQueue.isEmpty()) {
				rightMinQueue.add(num);
				return;
			} else {
				int leftMax = leftMaxQueue.peek();
				int rightMin = rightMinQueue.peek();
				if (num < leftMax) {
					if (leftMaxQueue.size() > rightMinQueue.size()) {
						rightMinQueue.add(leftMaxQueue.remove());
					}
					leftMaxQueue.add(num);
				} else if (num < rightMin) {
					if (leftMaxQueue.size() < rightMinQueue.size()) {
						leftMaxQueue.add(num);
					} else {
						rightMinQueue.add(num);
					}
				} else {
					if (rightMinQueue.size() > leftMaxQueue.size()) {
						leftMaxQueue.add(rightMinQueue.remove());
					}
					rightMinQueue.add(num);
				}
			}
		}

		public double getMedian() {

			if (leftMaxQueue.size() > rightMinQueue.size()) {
				return leftMaxQueue.peek();
			} else if (leftMaxQueue.size() < rightMinQueue.size()) {
				return rightMinQueue.peek();
			} else {
				if (leftMaxQueue.isEmpty()) {
					return 0;
				}
				return ((double) leftMaxQueue.peek() + (double) rightMinQueue
						.peek()) / 2;
			}
		}

	}
}
