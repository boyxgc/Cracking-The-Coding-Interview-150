package chapter1;

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
}
