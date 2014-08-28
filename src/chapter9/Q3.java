package chapter9;

/**
 * A magic index in an array A[0...n-1] is defined to be an index such that A[i]
 * = i, Given a sorted array of distinct integers, write a method to find a
 * magic index, if one exists, in array A.
 * 
 * FOLLOW UP
 * 
 * what if the values are not distinct?f
 * 
 * @author boyxgc
 * 
 */
public class Q3 {

	/*
	 * values are distinct
	 * 
	 * time O(log(n))
	 */
	public static int findMagicIndexWoDups(int[] array) {
		return findMagicIndexWoDups(array, 0, array.length - 1);
	}

	private static int findMagicIndexWoDups(int[] array, int low, int high) {
		if (low > high) {
			return -1;
		}
		int mid = (low + high) / 2;
		if (array[mid] == mid) {
			return mid;
		} else if (array[mid] > mid) {
			return findMagicIndexWoDups(array, low, mid - 1);
		} else {
			return findMagicIndexWoDups(array, mid + 1, high);
		}
	}

	/*
	 * values are not distinct
	 * 
	 * time O(n)
	 */
	public static int findMagicIndexWDups(int[] array) {
		return findMagicIndexWDups(array, 0, array.length - 1);
	}

	private static int findMagicIndexWDups(int[] array, int low, int high) {
		if (low > high) {
			return -1;
		}
		int mid = (low + high) / 2;
		if (array[mid] == mid) {
			return mid;
		}

		/* small optimization, choose min between mid-1 and array[mid] */
		int left = findMagicIndexWDups(array, low,
				Math.min(mid - 1, array[mid]));

		if (left != -1) {
			return left;
		}

		/* smal optimization, choose max between mid+1 and array[mid] */
		int right = findMagicIndexWDups(array, Math.max(mid + 1, array[mid]),
				high);

		return right;
	}

	public static void main(String[] args) {
		int[] array = { -40, -20, -1, 1, 2, 3, 5, 7/* magic index */, 9, 12,
				13 };

		System.out.println(findMagicIndexWoDups(array));

		int[] array2 = { -1, 1/* magic index */, 2, 2, 2, 6, 7, 9, 9 };

		System.out.println(findMagicIndexWDups(array2));
	}

}
