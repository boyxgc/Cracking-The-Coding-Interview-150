package chapter9;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Implement an algorithm to print all valid (i.e., properly opened and closed)
 * combinations of n-pairs of parentheses
 * 
 * @author boyxgc
 * 
 */
public class Q6 {

	public static ArrayList<String> printParentheses(int n) {
		ArrayList<String> result = new ArrayList<String>();

		genP(n, 0, 0, result, "");

		return result;
	}

	/*
	 * countLeft: number of left parentheses already added
	 * 
	 * score: the number of left parentheses remain unmatched
	 */
	private static void genP(int n, int countLeft, int score,
			ArrayList<String> result, String str) {
		if (str.length() == n * 2 && score == 0) {
			result.add(str);
			return;
		}

		if (score > 0) {
			genP(n, countLeft, score - 1, result, str + ")");
		}
		if (countLeft < n) {
			genP(n, countLeft + 1, score + 1, result, str + "(");
		}
	}

	/**
	 * Not very efficient
	 * 
	 * @param n
	 * @return
	 */
	public static Set<String> printParentheses2(int n) {
		Set<String> result = new HashSet<String>();

		if (n == 0) {
			return null;
		} else if (n == 1) {
			result.add("()");
			return result;
		} else {
			Set<String> subResult = printParentheses2(n - 1);
			for (String str : subResult) {
				for (int i = 0; i < str.length(); ++i) {
					if (str.charAt(i) == '(') {
						result.add(str.substring(0, i + 1) + "()"
								+ str.substring(i + 1));
					}
				}
				result.add("()" + str);
			}
			return result;
		}
	}

	public static void main(String[] args) {
		ArrayList<String> parens = printParentheses(10);

		System.out.println(parens.size());

		Set<String> parens2 = printParentheses2(10);

		System.out.println(parens2.size());
	}
}
