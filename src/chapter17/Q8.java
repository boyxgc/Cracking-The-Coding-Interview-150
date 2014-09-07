package chapter17;

/**
 * You are given an array of integers (both positive and negative). Find the
 * continuous sequence with the largest sum. Return the sum
 * 
 * Example:
 * 
 * input: 2, -8, 3, -2, 4, -10
 * 
 * output: 5 (i.e., {3, -2, 4})
 * 
 * @author boyxgc
 * 
 */
public class Q8 {

	public static int maxSubSum(int[] array) {

		int max_sum = -1;

		int cur_sum = 0;
		for (int i = 0; i < array.length; ++i) {
			int tmp = cur_sum + array[i];
			if (tmp < 0) {
				cur_sum = 0;
			} else {
				cur_sum = tmp;
				if (cur_sum > max_sum) {
					max_sum = cur_sum;
				}
			}
		}

		if (max_sum == -1) {
			max_sum = array[0];
			for (int i = 0; i < array.length; ++i) {
				if (array[i] > max_sum) {
					max_sum = array[i];
				}
			}
		}

		return max_sum;
	}

	public static void main(String[] args) {
		int[] array = { 2, -8, 3, -2, 4, -10 };

		System.out.println(maxSubSum(array));
	}
}
