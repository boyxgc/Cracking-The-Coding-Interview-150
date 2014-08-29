package chapter9;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a infinite number of quarters(25 cents), dimes(10 cents), nickels(5
 * cents) and pennies(1 cent), write code to calculate the number of ways of
 * representing n cents
 * 
 * @author boyxgc
 * 
 */
public class Q8 {

	public static int representingWays(int n) {
		if (n <= 0) {
			return 0;
		}
		int[] cents = { 1, 5, 10, 25 };
		return countWays(n, 0, cents);
	}

	private static int countWays(int n, int index, int[] cents) {
		if (n == 0) {
			return 1;
		}
		int ways = 0;

		for (int i = index; i < cents.length; ++i) {
			/*
			 * only use cents greater or equal than last used cent to avoid
			 * duplicates
			 */
			if (n >= cents[i]) {
				ways += countWays(n - cents[i], i, cents);
			}
		}
		return ways;
	}

	public static int representingWays2(int n) {
		if (n == 0) {
			return 0;
		}
		int[] cents = { 25, 10, 5, 1 };
		int[][] cache = new int[n + 1][cents.length];
		return countWays2(n, 0, cents, cache);
	}

	/*
	 * store cache
	 */
	private static int countWays2(int n, int index, int[] cents, int[][] cache) {
		if (cache[n][index] > 0) {
			return cache[n][index];
		}
		/* only 1 cents left for use */
		if (index >= cents.length - 1) {
			return 1;
		}

		int ways = 0;
		for (int i = 0; i * cents[index] <= n; ++i) {
			ways += countWays2(n - i * cents[index], index + 1, cents, cache);
		}

		cache[n][index] = ways;
		return ways;
	}

	public static void main(String[] args) {
		System.out.println(representingWays(100));

		System.out.println(representingWays2(100));
	}
}
