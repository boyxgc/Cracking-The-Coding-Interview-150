package chapter5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * An array a contains all the integers from 0 to n, except for one number which
 * is missing In this problem, we cannot access an entire integer inA with a
 * single operation. The elements of A are represented in binary, and the only
 * operation we can use to access them is "fetch the jth bit of A[i]",which
 * takes constant time. Write code to find the missing integer. Can you do this
 * in O(n) time?
 * 
 * @param nums
 * @return
 */
public class Q7 {

	/* int visited each time n, n/2, n/4 ...1 , log(n) times in total */
	public static int findMissingInt(List<Integer> A) {
		/* calculate number of bits */
		double log = Math.log(A.size() + 1) / Math.log(2);
		int bitNum = (log - (int) log > 0.0) ? (int) log + 1 : (int) log;

		return findMissingInt(A, 0, bitNum);
	}

	private static int findMissingInt(List<Integer> A, int colum, int bitNum) {

		if (colum >= bitNum) {
			return 0;
		}

		List<Integer> zeroBits = new ArrayList<Integer>();
		List<Integer> oneBits = new ArrayList<Integer>();

		for (int i = 0; i < A.size(); ++i) {
			if (getBit(A.get(i), colum) == 0) {
				zeroBits.add(A.get(i));
			} else {
				oneBits.add(A.get(i));
			}
		}

		if (zeroBits.size() <= oneBits.size()) {
			int v = findMissingInt(zeroBits, colum + 1, bitNum);
			return (v << 1) | 0;
		} else {
			int v = findMissingInt(oneBits, colum + 1, bitNum);
			return (v << 1) | 1;
		}
	}

	private static int getBit(int num, int j) {
		return num & (1 << j);
	}

	public static void main(String[] args) {
		System.out
				.println(findMissingInt(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 8)));
	}
}
