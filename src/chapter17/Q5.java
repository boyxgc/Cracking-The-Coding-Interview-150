package chapter17;

/**
 * 4 slots, and each slot will contain a ball that is Red(R), yellow(Y),
 * green(G), or blue(B). For example, it might be RGGB.
 * 
 * You, the user, are trying to guess the solution.You might, for example,
 * guess, YRGB
 * 
 * when you guess the correct color for the correct slot, you get a "hit". If
 * you guess a color that exists but is in the wrong slot, you get a
 * "pseudo-hit". Note that a slot that is a hit can never count as a pseudo-hit.
 * 
 * If actual solution is RGBY, your guess is GGRR, you have one hit and one
 * pseudo-hit.
 * 
 * Write a method to count the numbers of hit and pseudo-hit.
 * 
 * @author boyxgc
 * 
 */
public class Q5 {

	public static class Result {
		int hits;
		int pseudo_hits;
	}

	private static int code(char c) {
		switch (c) {
		case 'B':
			return 0;
		case 'G':
			return 1;
		case 'R':
			return 2;
		case 'Y':
			return 3;
		default:
			return -1;
		}
	}

	public static Result count(String solution, String guess) {

		Result result = new Result();
		int[] freq = new int[4];

		for (int i = 0; i < solution.length(); ++i) {
			char ch = solution.charAt(i);
			if (ch == guess.charAt(i)) {
				result.hits++;
			} else {
				freq[code(ch)]++;
			}
		}

		for (int i = 0; i < guess.length(); ++i) {
			char ch = guess.charAt(i);
			int code = code(ch);
			if (ch != solution.charAt(i) && code >= 0 && freq[code] > 0) {
				freq[code]--;
				result.pseudo_hits++;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		Result result = count("RGBY", "GGRR");
		System.out.println(result.hits + "," + result.pseudo_hits);
	}
}
