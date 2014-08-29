package chapter9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Given a boolean expression consisting of the symbols 0, 1, &, |, and ^, and a
 * desired boolean result value result, implement a function to count the number
 * of ways of parenthesizing the expression such that it evaluates to result.
 * 
 * @author boyxgc
 * 
 */
public class Q11 {

	public static ArrayList<String> parenthExpr(String expr, boolean result) {

		HashMap<String, Set<String>> cache = new HashMap<String, Set<String>>();
		Set<String> ret = parenthExpr(expr, result, cache);

		return new ArrayList<String>(ret);
	}

	private static Set<String> parenthExpr(String expr, boolean result,
			HashMap<String, Set<String>> cache) {
		String key = expr + "=" + result;
		if (cache.containsKey(key)) {
			return cache.get(key);
		}
		Set<String> ret = new HashSet<String>();
		if (expr.length() == 1) {
			/* value is same as result */
			if (((Integer.parseInt(expr)) ^ (result ? 1 : 0)) == 0) {
				ret.add(expr);
				return ret;
			} else {
				return ret;
			}
		} else {
			for (int i = 0; i < expr.length(); i++) {
				char ch = expr.charAt(i);
				/* if ch is a symbol */
				if (ch == '&' || ch == '|' || ch == '^') {

					if (ch == '&') {
						if (result) {
							/* 1 & 1 */
							ret.addAll(parenthSubExpr(expr, i, true, true,
									cache));
						} else {
							/* 0 & 1 */
							ret.addAll(parenthSubExpr(expr, i, false, true,
									cache));
							/* 1 & 0 */
							ret.addAll(parenthSubExpr(expr, i, true, false,
									cache));
							/* 0 & 0 */
							ret.addAll(parenthSubExpr(expr, i, false, false,
									cache));
						}
					} else if (ch == '|') {
						if (result) {
							/* 1 | 0 */
							ret.addAll(parenthSubExpr(expr, i, true, false,
									cache));
							/* 0 | 1 */
							ret.addAll(parenthSubExpr(expr, i, false, true,
									cache));
							/* 1 | 1 */
							ret.addAll(parenthSubExpr(expr, i, true, true,
									cache));
						} else {
							/* 0 | 0 */
							ret.addAll(parenthSubExpr(expr, i, false, false,
									cache));
						}

					} else if (ch == '^') {
						if (result) {
							/* 0 ^ 1 */
							ret.addAll(parenthSubExpr(expr, i, false, true,
									cache));
							/* 1 ^ 0 */
							ret.addAll(parenthSubExpr(expr, i, true, false,
									cache));
						} else {
							/* 1 ^ 1 */
							ret.addAll(parenthSubExpr(expr, i, true, true,
									cache));
							/* 0 ^ 0 */
							ret.addAll(parenthSubExpr(expr, i, false, false,
									cache));
						}
					}
				}
			}
		}

		cache.put(key, ret);

		return ret;
	}

	private static Set<String> parenthSubExpr(String expr, int splitIndex,
			boolean leftResult, boolean rightResult,
			HashMap<String, Set<String>> cache) {
		Set<String> leftSub = parenthExpr(expr.substring(0, splitIndex),
				leftResult, cache);
		Set<String> rightSub = parenthExpr(expr.substring(splitIndex + 1),
				rightResult, cache);

		Set<String> ret = new HashSet<String>();
		if (leftSub != null && leftSub.size() > 0 && rightSub != null
				&& rightSub.size() > 0) {
			for (String left : new ArrayList<String>(leftSub)) {
				for (String right : new ArrayList<String>(rightSub)) {
					if (left.length() > 1) {
						left = '(' + left + ')';
					}
					if (right.length() > 1) {
						right = '(' + right + ')';
					}
					ret.add(left + expr.charAt(splitIndex) + right);
				}
			}
		}

		return ret;
	}

	public static void main(String[] args) {
		String expr = "1&0|1&1";

		ArrayList<String> ret = parenthExpr(expr, true);
		for (String str : ret) {
			System.out.println(str);
		}
	}
}
