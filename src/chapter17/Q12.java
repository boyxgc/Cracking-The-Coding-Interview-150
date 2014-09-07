package chapter17;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Design an algorithm to find all pairs of integers within an array which sum
 * to a specified value
 * 
 * @author boyxgc
 * 
 */
public class Q12 {

	/**
	 * Using hashtable
	 * 
	 * @param array
	 */
	public static void findSum(int array[], int sum) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < array.length; ++i) {
			int other = sum - array[i];
			if (map.containsKey(other)) {

				System.out.println(other + " + " + array[i]);
				if (map.get(other) <= 1) {
					map.remove(other);
				} else {
					map.put(other, map.get(other) - 1);
				}

			} else {
				if (map.containsKey(array[i])) {
					map.put(array[i], map.get(array[i]) + 1);
				} else {
					map.put(array[i], 1);
				}
			}
		}
	}

	public static void findSum2(int array[], int sum) {
		Arrays.sort(array);

		int left = 0, right = array.length - 1;

		while (left < right) {
			int tmpsum = array[left] + array[right];

			if (tmpsum == sum) {
				System.out.println(array[left] + " + " + array[right]);
				left++;
				right--;
			} else if (tmpsum < sum) {
				left++;
			} else {
				right--;
			}
		}
	}

	public static void main(String[] args) {
		int arr[] = { 1, 1, 3, 5, 7, 7, 9 };
		findSum2(arr, 8);
	}
}
