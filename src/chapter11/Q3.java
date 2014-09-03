package chapter11;

/**
 * Given a sorted array of n integers that has been rotated an unknown number of
 * times, write code to find an element in that array. You may assume that the
 * array was originally sorted in increasing order.
 * 
 * @author boyxgc
 * 
 */
public class Q3 {

	/* assuming no dups of integers */
	public static int findNumInRotatedArray(int[] array, int num) {

		int low = 0;
		int high = array.length - 1;
		int mid;

		while (low <= high) {
			mid = (low + high) / 2;

			if (array[mid] == num) {
				return mid;
			} else if (array[mid] > num) {
				if ((array[low] > array[mid])
						|| (array[low] < array[mid] && array[low] <= num)) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			} else {
				if (array[high] < array[mid]
						|| (array[high] > array[mid] && array[high] >= num)) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			}
		}

		return -1;

	}

	public static void main(String[] args) {
		int array[] = { 3, 4, 5, 8, 9, 0, 1, 2 };

		System.out.println(findNumInRotatedArray(array, 0));
	}
}
