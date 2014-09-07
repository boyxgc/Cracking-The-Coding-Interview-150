package chapter17;

/**
 * Write a method which finds the maximum of two numbers. You should not use
 * if-else or any other comparison operator
 * 
 * @author boyxgc
 * 
 */
public class Q4 {

	/**
	 * returns 1 if a is positive, 0 otherwise
	 * 
	 * @param a
	 * @return
	 */
	private static int sign(int a) {
		return (a >> 31) & (0x1);
	}

	/**
	 * flips 1 to 0, 0 to 1
	 * 
	 * @param a
	 * @return
	 */
	private static int flip(int bit) {
		return bit ^ (0x1);
	}

	public static int max(int a, int b) {
		int c = a - b;

		int sa = sign(a);
		int sb = sign(b);
		int sc = sign(c);

		/*
		 * if a, b have the same sign, then there is no overflow, we don't need
		 * a, just use c; otherwise, we use the sign of a
		 */
		int use_sign_of_a = sa ^ sb;
		int use_sign_of_c = flip(sa ^ sb);

		int k = use_sign_of_a * sa + use_sign_of_c * sc;
		int q = flip(k);

		return a * k + b * q;

	}
}
