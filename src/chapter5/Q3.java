package chapter5;

public class Q3 {

	public static int findNextMinNumWithSame1s(int num) {

		int tmp = 1;

		/* skip the rightmost 0s */
		while (tmp < num && (tmp & num) == 0) {
			tmp <<= 1;
		}

		/* from right to left, find the first 1 with a 0 on its left */
		while (tmp < num && (tmp & num) > 0) {
			/* exceed 31 bits */
			if (tmp == (1 << 30)) {
				return -1;
			}
			tmp <<= 1;
		}

		return num & ~(tmp >> 1) | tmp;
	}

	public static int findNextMaxNumWithSame1s(int num) {

		int countOne = 0;

		int tmpnum = num;
		/* count the number of 1s */
		while (tmpnum > 0) {
			if ((tmpnum & 1) > 0) {
				countOne++;
			}
			tmpnum >>= 1;
		}

		/* put same number of 1s on the leftmost */
		int result = 0;
		for (int i = 0; i < countOne; ++i) {
			result |= (1 << 30 - i);
		}
		/* if result is the same as the original number, then no bigger number */
		return ((result == num) ? -1 : result);
	}

	public static void main(String[] args) {

		int num = Integer.parseInt("1110000", 2);
		System.out.println(Integer.toBinaryString(num));
		System.out.println(Integer
				.toBinaryString(findNextMinNumWithSame1s(num)));
		System.out.println(Integer
				.toBinaryString(findNextMaxNumWithSame1s(num)));
	}
}
