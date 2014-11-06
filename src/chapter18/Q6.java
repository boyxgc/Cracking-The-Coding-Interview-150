package chapter18;

/**
 * describe an algorithm to find the smallest one million numbers in one billion
 * numbers. Assume that the computer memory can hold all one billion numbers
 * 
 * @author boyxgc
 * 
 */
public class Q6 {

	/*
	 * selection rank algorithm
	 */
	public static int[] findSmallestMillion(int[] nums, int left, int right,
			int rank) {

		int div = partition(nums, left, right);
		int size = div - left + 1;
		if (size == rank + 1) {
			int[] ret = new int[1000000];
			System.arraycopy(nums, 0, ret, 0, 1000000);
			return ret;
		} else if (size > rank + 1) {
			return findSmallestMillion(nums, left, div, rank);
		} else {
			return findSmallestMillion(nums, div + 1, right, rank - size);
		}

	}

	private static int partition(int[] arr, int left, int right) {
		int pivot = arr[left]; // any number
		while (left < right) {
			while (left < right && arr[right] > pivot) {
				right--;
			}
			if (left < right) {
				arr[left++] = arr[right];
			}
			while (left < right && arr[left] <= pivot) {
				left++;
			}
			if (left < right) {
				arr[right--] = arr[left];
			}
		}

		return left;
	}
}
