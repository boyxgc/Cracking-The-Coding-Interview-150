package chapter18;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Given a list of words, write a program to find the longest word made of other
 * words in the list.
 * 
 * @author boyxgc
 * 
 */
public class Q7 {

	public static String findLongestCombinedWord(ArrayList<String> words) {
		// Set<String> wordSet = new HashSet<String>(words);
		HashMap<String, Boolean> wordMap = new HashMap<String, Boolean>();
		for (String word : words) {
			wordMap.put(word, true);
		}

		String found = "";
		for (String word : words) {
			if (word.length() > found.length()) {
				if (check(wordMap, word, false)) {
					found = word;
				}
			}
		}
		System.out.println(wordMap.toString());

		return found;
	}

	private static boolean check(HashMap<String, Boolean> wordMap, String word,
			boolean isSub) {
		if (isSub && wordMap.containsKey(word)) { // don't check for the
													// original
													// word, only for sub-words
			System.out.println(word);
			return wordMap.get(word);
		}
		for (int len = 1; len < word.length(); ++len) {
			String sub = word.substring(0, len);
			if (wordMap.containsKey(sub) && wordMap.get(sub)
					&& check(wordMap, word.substring(len), true)) {
				wordMap.put(word, true);
				return true;
			}
		}
		if (isSub) {
			wordMap.put(word, false);
		}
		return false;
	}

	public static void main(String[] args) {
		ArrayList<String> words = new ArrayList<String>();
		words.add("hello");
		words.add("word");
		words.add("usc");
		words.add("sjtu");
		words.add("sjtuhaha");
		words.add("helloword");
		words.add("wordusc");

		System.out.println("#" + findLongestCombinedWord(words) + "#");
	}
}
