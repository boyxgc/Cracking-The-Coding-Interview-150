package chapter9;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Given a boolean expression consisting of the symbols 0, 1, &, |, and ^, and a
 * desired boolean result value result, implement a function to count the number
 * of ways of parenthesizing the expression such that it evaluates to result.
 * 
 * @author boyxgc
 * 
 */
public class Q11 {

	public static int countParenthExpr(String expr, boolean result) {
		HashMap<String, Integer> cache = new HashMap<String, Integer>();
		return countParenthExpr(expr, result, 0, expr.length() - 1, cache);
	}

	private static int countParenthExpr(String expr, boolean result, int b,
			int e, HashMap<String, Integer> cache) {
		String key = "" + b + e + result;
		if (cache.containsKey(key)) {
			return cache.get(key);
		}

		int count = 0;
		if (b == e) {
			if (result && expr.charAt(b) == '1' || !result
					&& expr.charAt(b) == '0') {
				count = 1;
			} else {
				count = 0;
			}
			return count;
		}
		for (int i = b + 1; i < e; i += 2) {
			char op = expr.charAt(i);
			if (result) {
				if (op == '&') {
					/* 1 & 1 */
					count += countParenthExpr(expr, true, b, i - 1, cache)
							* countParenthExpr(expr, true, i + 1, e, cache);
				} else if (op == '|') {
					/* 1 | 0 */
					count += countParenthExpr(expr, true, b, i - 1, cache)
							* countParenthExpr(expr, false, i + 1, e, cache);
					/* 0 | 1 */
					count += countParenthExpr(expr, false, b, i - 1, cache)
							* countParenthExpr(expr, true, i + 1, e, cache);
					/* 1 | 1 */
					count += countParenthExpr(expr, true, b, i - 1, cache)
							* countParenthExpr(expr, true, i + 1, e, cache);
				} else if (op == '^') {
					/* 1 ^ 0 */
					count += countParenthExpr(expr, true, b, i - 1, cache)
							* countParenthExpr(expr, false, i + 1, e, cache);
					/* 0 ^ 1 */
					count += countParenthExpr(expr, false, b, i - 1, cache)
							* countParenthExpr(expr, true, i + 1, e, cache);
				}
			} else {
				if (op == '&') {
					/* 1 & 0 */
					count += countParenthExpr(expr, true, b, i - 1, cache)
							* countParenthExpr(expr, false, i + 1, e, cache);
					/* 0 & 1 */
					count += countParenthExpr(expr, false, b, i - 1, cache)
							* countParenthExpr(expr, true, i + 1, e, cache);
					/* 0 & 0 */
					count += countParenthExpr(expr, false, b, i - 1, cache)
							* countParenthExpr(expr, false, i + 1, e, cache);
				} else if (op == '|') {
					/* 0 | 0 */
					count += countParenthExpr(expr, false, b, i - 1, cache)
							* countParenthExpr(expr, false, i + 1, e, cache);
				} else if (op == '^') {
					/* 1 ^ 1 */
					count += countParenthExpr(expr, true, b, i - 1, cache)
							* countParenthExpr(expr, true, i + 1, e, cache);
					/* 0 ^ 0 */
					count += countParenthExpr(expr, false, b, i - 1, cache)
							* countParenthExpr(expr, false, i + 1, e, cache);
				}
			}
		}

		cache.put(key, count);

		return count;
	}

	public static ArrayList<String> parenthExpr(String expr, boolean result) {

		HashMap<String, ArrayList<String>> cache = new HashMap<String, ArrayList<String>>();
		ArrayList<String> ret = parenthExpr(expr, result, cache);

		return new ArrayList<String>(ret);
	}

	private static ArrayList<String> parenthExpr(String expr, boolean result,
			HashMap<String, ArrayList<String>> cache) {
		String key = expr + "=" + result;
		if (cache.containsKey(key)) {
			return cache.get(key);
		}
		ArrayList<String> ret = new ArrayList<String>();
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

	private static ArrayList<String> parenthSubExpr(String expr,
			int splitIndex, boolean leftResult, boolean rightResult,
			HashMap<String, ArrayList<String>> cache) {
		ArrayList<String> leftSub = parenthExpr(expr.substring(0, splitIndex),
				leftResult, cache);
		ArrayList<String> rightSub = parenthExpr(
				expr.substring(splitIndex + 1), rightResult, cache);

		ArrayList<String> ret = new ArrayList<String>();
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

		System.out.println(countParenthExpr(expr, true));

		ArrayList<String> ret = parenthExpr(expr, true);
		for (String str : ret) {
			System.out.println(str);
		}
	}
}
