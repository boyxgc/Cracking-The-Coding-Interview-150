package chapter11;

/**
 * Imagine you are reading in a stream of integers. Periodically, you wish to be
 * able to look up the rank of a number x(the number of values less than or
 * equal to x). Implement the data structures and algorithms to support these
 * operations. That is, implement the method track(int x), which is called when
 * each number is generated, and the method getRankOfNumber(int x), which
 * returns the number of values less than or equal to x(not including x itself)
 * 
 * EXAMPLE
 * 
 * Stream (in order of appearance): 5, 1, 4, 4, 5, 9, 7, 13, 3
 * 
 * getRankOfNumber(1) = 0
 * 
 * getRankOfNumber(3) = 1
 * 
 * getRankOfNumber(4) = 3
 * 
 * @author boyxgc
 * 
 */
public class Q8 {

	/*
	 * use binary search tree
	 */

	public static class Node {
		int data;
		int leftSize;

		Node left;
		Node right;

		public Node(int _data, int _leftSize) {
			data = _data;
			leftSize = _leftSize;
		}
	}

	public static class RankTree {

		private Node root;

		public RankTree() {
		}

		public void track(int x) {
			if (root == null) {
				root = new Node(x, 0);
			} else {
				add(x, root);
			}
		}

		private void add(int x, Node r) {
			if (x == r.data) {
				r.leftSize++;
				return;
			} else if (x < r.data) {
				if (r.left == null) {
					r.left = new Node(x, 0);
				} else {
					add(x, r.left);
				}
				r.leftSize++;
				return;
			} else {
				if (r.right == null) {
					r.right = new Node(x, 0);
				} else {
					add(x, r.right);
				}
				return;
			}
		}

		public int getRankOfNumber(int x) {

			return search(x, root);
		}

		private int search(int x, Node r) {
			if (r == null) {
				return -1;
			}
			if (x == r.data) {
				return r.leftSize;
			} else if (x < r.data) {
				return search(x, r.left);
			} else {
				int right = search(x, r.right);
				return (right == -1) ? -1 : right + r.leftSize + 1;
			}
		}
	}

}
