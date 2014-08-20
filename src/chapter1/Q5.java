package chapter1;

/**
 * compress string "aaabbc" -> "a3b2c1". if compressed string is not smaller
 * than the original one, return the original string
 * 
 * @author boyxgc
 * 
 */
public class Q5 {
	/*
	 * using StringBuffer to achieve O(n) time complexity
	 */
	public static String compress(String str) {
		if (str == null || str.length() == 0) {
			return str;
		}

		StringBuffer stringBuffer = new StringBuffer();

		/* append the first char */
		int charCount = 1;
		stringBuffer.append(str.charAt(0));

		for (int i = 1; i < str.length(); ++i) {
			if (str.charAt(i) != stringBuffer.charAt(stringBuffer.length() - 1)) {
				/* append count for the previous char */
				stringBuffer.append(charCount);
				/* append new char */
				stringBuffer.append(str.charAt(i));
				charCount = 1;
			} else {
				charCount++;
			}
		}
		/* append count for the last char */
		stringBuffer.append(charCount);

		return (stringBuffer.length() >= str.length() ? str : stringBuffer
				.toString());
	}

	public static void main(String[] args) {
		print(compress("hello"));
		print(compress("heeeeellllllllo"));
		print(compress("heeeeellllllllooo"));
	}

	private static void print(String str) {
		System.out.println("\"" + str + "\"");
	}
}
