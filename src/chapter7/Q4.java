package chapter7;

/**
 * Write methods to implement the multiply, subtract, and divide operations for
 * integers. Use only add operator.
 * 
 * @author boyxgc
 * 
 */
public class Q4 {

	public static int negate(int num) {
		if (num == 0) {
			return 0;
		}
		int negAtom = num > 0 ? -1 : 1;
		int neg = 0;
		while (num != 0) {
			num += negAtom;
			neg += negAtom;
		}
		return neg;
	}

	public static int subtract(int num1, int num2) {
		return num1 + negate(num2);
	}

	public static int multiply(int num1, int num2) {
		if (num1 == 0 || num2 == 0) {
			return 0;
		}

		if (num1 < 0 && num2 < 0) {
			return multiply(negate(num1), negate(num2));
		} else if (num1 < 0 && num2 > 0) {
			return negate(multiply(negate(num1), num2));
		} else if (num1 > 0 && num2 < 0) {
			return negate(multiply(num1, negate(num2)));
		} else {
			if (num1 > num2) {
				return multiply(num2, num1);
			}

			int result = 0;
			while (num1 > 0) {
				result += num2;
				num1--;
			}
			return result;
		}
	}

	public static int divide(int num1, int num2) {
		if (num2 == 0) {
			throw new RuntimeException("Divisor cannot be 0!");
		}

		if (num1 == 0) {
			return 0;
		}

		if (num1 < 0 && num2 < 0) {
			return divide(negate(num1), negate(num2));
		} else if (num1 < 0 && num2 > 0) {
			return negate(divide(negate(num1), num2));
		} else if (num1 > 0 && num2 < 0) {
			return negate(divide(num1, negate(num2)));
		} else {
			int result = 0;
			while (num1 >= num2) {
				num1 += negate(num2);
				result++;
			}

			return result;
		}
	}

	public static void main(String[] args) {
		System.out.println(negate(3));
		System.out.println(subtract(19, 10));
		System.out.println(multiply(3, -2));
		System.out.println(divide(-9, 3));
	}
}
