package chapter17;

/**
 * Given any integer, print an English phrase that describes the integer (e.g.,
 * "One Thousand, Two Hundred Thirty Four"
 * 
 * @author boyxgc
 * 
 */
public class Q7 {

	private static String[] digits = { "", "One", "Two", "Three", "Four",
			"Five", "Six", "Seven", "Eight", "Nine" };
	private static String[] tens = { "", "Ten", "Twenty", "Thirty", "Forty",
			"Fifty", "Sixty", "Seventy", "Eighty", "Ninty" };

	public static String convert(int num) {

		String res = "";
		if (num > 1000000000) {
			res += convert_small(num / 1000000000) + " Billion,";
			num = num % 1000000000;
		}

		if (num > 1000000) {
			res += convert_small(num / 1000000) + " Million,";
			num = num % 1000000;
		}

		if (num > 1000) {
			res += convert_small(num / 1000) + " Thousand,";
			num = num % 1000;
		}

		res += convert_small(num);

		return res;
	}

	private static String convert_small(int num) {
		String res = "";
		int hundred = num / 100;
		int ten = (num % 100) / 10;
		int digit = (num % 10);

		if (hundred > 0) {
			res += " " + digits[hundred] + " Hundred";
		}
		if (ten > 0) {
			res += " " + tens[ten];
		}
		if (digit > 0) {
			res += " " + digits[digit];
		}
		return res;
	}

	public static void main(String[] args) {
		String res = convert(Integer.MAX_VALUE).trim();
		System.out.println(Integer.MAX_VALUE + ":" + "\"" + res + "\"");
	}
}
