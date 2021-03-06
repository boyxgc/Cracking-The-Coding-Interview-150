package chapter1;

/**
 * check if a string contains only unique characters
 * 
 * @author boyxgc
 * 
 */
public class Q1 {
	/*
	 * Assuming the input string could contain any ASCII character
	 */
	public static boolean hasUniqueCharacters(String inputStr) {
		if (inputStr.length() > 256) {
			return false;
		}
		boolean charArray[] = new boolean[256];

		for (char c : inputStr.toCharArray()) {
			if (charArray[(int) c]) {
				return false;
			}
			charArray[(int) c] = true;
		}

		return true;
	}

	public static void main(String[] args) {
		System.out.println(hasUniqueCharacters("hello"));
		System.out.println(hasUniqueCharacters("helo"));
	}
}
