package chapter18;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Given a list of words, write a program to find the longest word made of other
 * words in the list.
 * 
 * @author boyxgc
 * 
 */
public class Q7 {

	public static String findLongestCombinedWord(ArrayList<String> words) {
		Set<String> wordSet = new HashSet<String>(words);

		String found = "";
		for (String word : words) {
			if (word.length() > found.length()) {
				if (check(wordSet, word, false)) {
					found = word;
				}
			}
		}

		return found;
	}

	private static boolean check(Set<String> words, String word, boolean isSub) {
		if (isSub && words.contains(word)) { // don't check for the original
												// word, only for sub-words
			return true;
		}
		for (int len = 1; len < word.length(); ++len) {
			String sub = word.substring(0, len);
			if (words.contains(sub) && check(words, word.substring(len), true)) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		ArrayList<String> words = new ArrayList<String>();
		words.add("hello");
		words.add("word");
		words.add("usc");
		words.add("sjtu");
		words.add("helloword");
		words.add("wordusc");

		System.out.println("#" + findLongestCombinedWord(words) + "#");
	}
}
