package chapter18;

/**
 * Write a method to shuffle a deck of cards. It must be a perfect shuffle -- in
 * other words, each of the 52! permutations of the deck has to be equally
 * likely. Assume that you are given a random number generator which is perfect.
 * 
 * @author boyxgc
 * 
 */
public class Q2 {

	public static int rand(int low, int high) {
		return low + (int) (Math.random() * (high - low + 1));
	}

	public static void shuffle(int[] cards) {
		int n = cards.length;
		for (int i = 0; i < n; ++i) {
			int rand = rand(0, i);
			int tmp = cards[rand];
			cards[rand] = cards[i];
			cards[i] = tmp;
		}
	}
}
