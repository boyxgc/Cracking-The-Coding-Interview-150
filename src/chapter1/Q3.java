package chapter1;

import java.util.Arrays;

public class Q3 {

	/*
	 * time complexity O(n*log(n))
	 */
	public static boolean isPermutationOfEachOther(String str1, String str2) {
		if (str1 == null || str2 == null || str1.length() != str2.length()) {
			return false;
		}

		return sort(str1).equals(sort(str2));
	}

	private static String sort(String str) {
		if (str == null) {
			return null;
		}
		char[] charArray = str.toCharArray();
		Arrays.sort(charArray);
		String sortedStr = new String(charArray);
		return sortedStr;
	}

	/*
	 * Assuming the two strings only contains ASCII characters time complexity
	 * O(n)
	 */
	public static boolean isPermutationOfEachOther2(String str1, String str2) {
		if (str1 == null || str2 == null || str1.length() != str2.length()) {
			return false;
		}

		int charCount[] = new int[256];

		for (char c : str1.toCharArray()) {
			charCount[(int) c]++;
		}

		for (char c : str2.toCharArray()) {
			int newCount = --charCount[(int) c];
			if (newCount < 0) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		System.out.println(isPermutationOfEachOther("hello", "llhoe"));
		System.out.println(isPermutationOfEachOther("hello", "llhoed"));

		System.out.println(isPermutationOfEachOther2("hello", "llhoe"));
		System.out.println(isPermutationOfEachOther2("hello", "llhee"));
	}
}
