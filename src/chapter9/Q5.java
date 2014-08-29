package chapter9;

import java.util.ArrayList;

/**
 * Write a method to return all permutations of a string of unique characters
 * 
 * @author boyxgc
 * 
 */
public class Q5 {

	public static ArrayList<String> permutations(String str) {
		ArrayList<String> perms = new ArrayList<String>();
		if (str == null) {
			return perms;
		}
		if (str.length() <= 1) {
			perms.add(str);
			return perms;
		} else {
			/* make every char as the first */
			for (int i = 0; i < str.length(); ++i) {
				char first = str.charAt(i);
				ArrayList<String> subPerms = permutations(str.substring(0, i)
						+ str.substring(i + 1));
				for (String subPerm : subPerms) {
					perms.add(first + subPerm);
				}
			}
			return perms;
		}
	}

	public static void main(String[] args) {
		ArrayList<String> perms = permutations("abcd");
		System.out.println("Size: " + perms.size());
		for (String perm : perms) {
			System.out.println(perm);
		}
	}
}
