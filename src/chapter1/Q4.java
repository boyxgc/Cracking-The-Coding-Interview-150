package chapter1;

/**
 * write a method to replace all spaces in a string with '%20'. You may assume
 * that the string has sufficient space at the end of the string to hold the
 * additional characters and you're given the true length of the string.
 * 
 * EXAMPLE: input: "Mr John Smith    ", 13 ; output: "Mr%20John%20Smith"
 * 
 * @author boyxgc
 * 
 */
public class Q4 {
	public static char[] replaceSpace(char[] str, int length) {
		int spaceCount = 0;
		for (int i = length - 1; i >= 0; i--) {
			if (str[i] == ' ') {
				spaceCount++;
			}
		}

		int end = length + 2 * spaceCount - 1;

		for (int i = length - 1; i >= 0; i--) {
			if (str[i] == ' ') {
				str[end--] = '0';
				str[end--] = '2';
				str[end--] = '%';
			} else {
				str[end--] = str[i];
			}
		}

		return str;
	}

	public static void main(String[] args) {
		char[] str = { ' ', 'h', 'e', 'l', ' ', 'l', ' ', ' ', ' ', ' ', ' ',
				' ', ' ', ' ' };
		System.out.println("input: \"" + String.valueOf(str) + "\"");
		System.out.println("output: \"" + String.valueOf(replaceSpace(str, 6))
				+ "\"");
	}
}
