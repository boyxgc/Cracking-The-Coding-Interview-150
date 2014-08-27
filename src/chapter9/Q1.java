package chapter9;

import java.util.Arrays;

/**
 * Achild is running up a staircase with n steps, and can hop either 1 step, 2
 * steps, or 3 steps at a time. Implement a method to count how many possible
 * ways the child run up the stairs.
 * 
 * @author boyxgc
 * 
 */
public class Q1 {

	/**
	 * recursive function :
	 * 
	 * S(n) = S(n-1) + S (n-2) + S(n-3), n > 2
	 * 
	 * S(n) = n; n < 2 && n >= 0
	 * 
	 */

	public static int countWays(int n) {
		if (n == 0) {
			return 1;
		}
		if (n < 3) {
			return n;
		}

		int s0 = 1, s1 = 1, s2 = 2;
		int s = 0;
		for (int i = 3; i <= n; ++i) {
			s = s0 + s1 + s2;
			s0 = s1;
			s1 = s2;
			s2 = s;
		}

		return s;
	}

	/* use recursion */
	public static int countWays2(int n) {
		int[] ways = new int[n + 1];
		Arrays.fill(ways, -1);
		return countWays2Helper(n, ways);
	}

	private static int countWays2Helper(int n, int[] ways) {
		if (n < 0) {
			return 0;
		}
		if (n == 0) {
			return 1;
		}
		if (ways[n] > -1) {
			return ways[n];
		}

		ways[n] = countWays2Helper(n - 1, ways) + countWays2Helper(n - 2, ways)
				+ countWays2Helper(n - 3, ways);
		return ways[n];
	}

	public static void main(String[] args) {
		System.out.println(countWays(3));
		System.out.println(countWays2(3));
	}
}
