package chapter17;

/**
 * Implements a method rand7() given rand5(). That is, given a method that
 * generates a random number between 0 and 4 (inclusive), write a method that
 * generates a random number between 0 and 6 (inclusive)
 * 
 * @author boyxgc
 * 
 */
public class Q11 {

	public static int rand5() {
		throw new UnsupportedOperationException();
	}

	/**
	 * Non-deterministic approach
	 * 
	 * generate a number between 0 (inclusive) and a multiple of 7 (exclusive),
	 * with each number having equal probability
	 * 
	 * @return
	 */
	public static int rand7() {
		while (true) {

			int num = 5 * rand5() + rand5();
			if (num < 21) { // discard value between 21 and 24 to give us the
							// value in range 0 to 6 with equal probability,
							// since we discard values, there is no guarantee
							// this will return a value, that's why it's
							// non-deterministic
				return num % 7;
			}
		}
	}
}
