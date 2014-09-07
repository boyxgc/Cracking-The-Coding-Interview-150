package chapter18;

/**
 * Write a method to randomly generate a set of m integers from an array of size
 * n. Each element must have equal probability of being chosen
 * 
 * @author boyxgc
 * 
 */
public class Q3 {

	public static int rand(int low, int high) {
		return low + (int) (Math.random() * (high - low + 1));
	}

	public static int[] pick(int[] arr, int m) {
		int[] subset = new int[m];

		for (int i = 0; i < m; ++i) {
			subset[i] = arr[m];
		}

		for (int i = m; i < arr.length; ++i) {
			int k = rand(0, i);
			if (k < m) {
				subset[k] = arr[i];
			}
		}

		return subset;
	}
}
