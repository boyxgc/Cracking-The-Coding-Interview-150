package chapter17;

/**
 * Write an algorithm which computes the number of trailing zeros in n factorial
 * 
 * @author boyxgc
 * 
 */
public class Q3 {

	public static int countZeroInFactorial(int n) {
		int count = 0;
		for (int i = 5; i <= n; i += 5) {
			count += i / 5;
		}
		return count;
	}
}
