package chapter1;

public class Q2 {

	/*
	 * Using StringBuffer, time complexity O(n)
	 */
	public static String reverse(String inputStr) {
		int nullIndex = inputStr.indexOf("\0");
		nullIndex = (nullIndex == -1) ? inputStr.length() : nullIndex;
		
		/*get null-terminated string (http://en.wikipedia.org/wiki/Null-terminated_string)*/
		String stringBeforeNull = inputStr.substring(0, nullIndex);
		
		StringBuffer reverseString = new StringBuffer();
		
		for (int i = stringBeforeNull.length() - 1; i >= 0; i--) {
			reverseString.append(inputStr.charAt(i));
		}
		
		return reverseString.toString();
	}

	public static void main(String[] args) {
		System.out.println("#" + reverse("hello world\0fsfas") + "#");
		System.out.println("#" + reverse("") + "#");
	}
}
