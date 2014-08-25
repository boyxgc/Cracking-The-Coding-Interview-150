package chapter5;

public class Q5 {

	public static int flipCost(int num1, int num2) {
		int xor = num1 ^ num2;
		int count = 0;
		while (xor > 0) {
			count += (xor & 1);
			xor >>= 1;
		}
		return count;
	}

	public static int flipCost2(int num1, int num2) {
		int xor = num1 ^ num2;
		int count = 0;
		while (xor > 0) {
			count++;
			/* Continuously clear least significant 0s */
			xor &= xor - 1;
		}
		return count;
	}

	public static void main(String[] args) {
		int num1 = Integer.parseInt("1110100", 2);
		int num2 = Integer.parseInt("0111100", 2);

		System.out.println(flipCost2(num1, num2));
	}
}
