package chapter5;

/**
 * Given a real number between 0 and 1 (e.g., 0.72) that is passed in as a
 * double, print the binary representation. If the number cannot be represented
 * accurately in binary with at most 32 characters, print "ERROR"
 * 
 * @author boyxgc
 * 
 */
public class Q2 {

	public static String printInBinary(double num) {
		if (num <= 0 || num >= 1) {
			return "ERROR";
		}

		double frac = 0.5;
		StringBuilder binary = new StringBuilder();
		binary.append("0.");
		while (num > 0) {
			if (binary.length() >= 32) {
				return "ERROR";
			}
			if (num >= frac) {
				binary.append('1');
				num -= frac;
			} else {
				binary.append('0');
			}

			frac /= 2;
		}

		return binary.toString();
	}

	public static void main(String[] args) {
		System.out.println(printInBinary(0.75));
	}
}
