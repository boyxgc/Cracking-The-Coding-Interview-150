package chapter17;


/**
 * Given an array of integers, write a method to find indices m and n such that
 * if you sorted elements m through n, the entire array would be sorted.
 * Minimize n - m
 * 
 * EXAMPLE:
 * 
 * input: 1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19
 * 
 * output: (3, 9)
 * 
 * 
 * @author boyxgc
 * 
 */
public class Q6 {

	public static class Result {
		private int m;
		private int n;

		public Result(int _m, int _n) {
			m = _m;
			n = _n;
		}

		public String toString() {
			return "(" + m + ", " + n + ")";
		}
	}

	public static Result findIndices(int[] array) {

		int m = 0, n = array.length - 1;

		while (m < array.length - 1 && array[m] <= array[m + 1]) {
			m++;
		}

		while (n > 0 && n > m && array[n] >= array[n - 1]) {
			n--;
		}

		int min = array[m];
		int max = array[n];

		for (int i = m + 1; i < n; ++i) {
			if (array[i] < min) {
				min = array[i];
			}
			if (array[i] > max) {
				max = array[i];
			}
		}

		while (array[m] > min || array[n] < max) {
			while (min < array[m] && m > 0) {
				if (array[m] < min) {
					min = array[m];
				}
				if (array[m] > max) {
					max = array[m];
				}
				m--;
			}

			while (max > array[n] && n < array.length - 1) {
				if (array[n] < min) {
					min = array[n];
				}
				if (array[n] > max) {
					max = array[n];
				}
				n++;
			}
		}

		return new Result(m + 1, n - 1);
	}

	public static void main(String[] args) {

		int[] array = { 1, 2, 4, 7, 10, 11, 7, 12, 2, 6, 7, 16, 18, 19 };

		System.out.println(findIndices(array).toString());
	}
}
