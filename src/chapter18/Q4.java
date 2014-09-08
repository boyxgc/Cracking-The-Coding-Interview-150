package chapter18;

/**
 * Write a method to count the number of 2s between 0 and n;
 * 
 * @author boyxgc
 * 
 */
public class Q4 {

	public static int count2s(int n) {
		int count = 0;
		int len = String.valueOf(n).length();
		for (int digit = 0; digit < len; ++digit) {
			count += count2sInRangeAtDigit(n, digit);
		}
		return count;
	}

	public static int count2sInRangeAtDigit(int n, int d) {
		int powerOf10 = (int) Math.pow(10, d);
		int nextPowerOf10 = powerOf10 * 10;
		int right = n % powerOf10;

		int roundDown = n - n % nextPowerOf10;
		int roundUp = roundDown + nextPowerOf10;

		int digit = (n / powerOf10) % 10;
		if (digit < 2) {
			return roundDown / 10;
		} else if (digit == 2) {
			return roundDown / 10 + right + 1;
		} else {
			return roundUp / 10;
		}
	}
}
