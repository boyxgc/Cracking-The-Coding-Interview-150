package chapter1;

/**
 * Assume you have a method isSubstring which checks if one word is a substring
 * of another. Given two strings, s1 and s2, write code to check if s2 is a
 * rotation of s1 using only one call to isSubstring (e.g.,"waterbottle" is a
 * rotation of "erbottlewat").
 * 
 * @author boyxgc
 * 
 */
public class Q8 {

	public static boolean isRotation(String str, String rotation) {
		if (str == null || rotation == null
				|| str.length() != rotation.length()) {
			return false;
		}
		/*
		 * we need to find a division that satisfies: str = xy, rotation = yx.
		 * but rotation(yx) is always substring of xyxy (strstr)
		 */
		String strstr = str + str;
		return isSubstring(rotation, strstr);
	}

	public static boolean isSubstring(String sub, String str) {
		return str.contains(sub);
	}

	public static void main(String[] args) {
		System.out.println(isRotation("waterbottle", "erbottlewat"));
		System.out.println(isRotation("waterbottle", "erbottlewad"));
	}
}
