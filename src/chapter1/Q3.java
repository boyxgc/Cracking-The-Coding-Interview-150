package chapter1;

import java.util.Arrays;

public class Q3 {

	public static boolean isPermutationOfEachOther(String str1, String str2) {
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

	public static void main(String[] args) {
		System.out.println(isPermutationOfEachOther("hello", "llhoe"));
		System.out.println(isPermutationOfEachOther("hello", "llhoed"));
	}
}
