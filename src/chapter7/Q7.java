package chapter7;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Design an algorithm to find the kth number such that the only prime factor
 * are 3,5,and 7.
 * 
 * @author boyxgc
 * 
 */
public class Q7 {

	public static int findKthMagicNumber(int k) {

		Queue<Integer> queue3 = new LinkedList<Integer>();
		Queue<Integer> queue5 = new LinkedList<Integer>();
		Queue<Integer> queue7 = new LinkedList<Integer>();

		queue3.add(1);

		int min = 0;
		for (int i = 0; i <= k; ++i) {
			int v3 = !queue3.isEmpty() ? queue3.peek() : Integer.MAX_VALUE;
			int v5 = !queue5.isEmpty() ? queue5.peek() : Integer.MAX_VALUE;
			int v7 = !queue7.isEmpty() ? queue7.peek() : Integer.MAX_VALUE;

			min = Math.min(v3, Math.min(v5, v7));
			if (v3 == min) {
				int val = queue3.remove();
				queue3.add(val * 3);
				queue5.add(val * 5);
				queue7.add(val * 7);
			} else if (v5 == min) {
				int val = queue5.remove();
				queue5.add(val * 5);
				queue7.add(val * 7);
			} else {
				int val = queue7.remove();
				queue7.add(val * 7);
			}
		}

		return min;
	}

	public static void main(String[] args) {

		System.out.println(findKthMagicNumber(4));
	}
}
