package chapter18;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Given two words of equal length that are in a dictionary, write a method to
 * transform one word into another word by changing only one letter at a time.
 * The new word you get in each step must be in dictionary.
 * 
 * @author boyxgc
 * 
 */
public class Q10 {

	public static LinkedList<String> transform(String start, String end,
			Set<String> dict) {
		LinkedList<String> res = new LinkedList<String>();

		HashMap<String, String> backTrackMap = new HashMap<String, String>();
		Queue<String> queue = new LinkedList<String>();
		Set<String> visited = new HashSet<String>();

		queue.add(start);
		visited.add(start);
		backTrackMap.put(start, null);

		while (!queue.isEmpty()) {
			String word = queue.remove();

			if (word.equals(end)) {
				String tmp = end;
				res.offerFirst(end);
				while (backTrackMap.get(tmp) != null) {
					tmp = backTrackMap.get(tmp);
					res.offerFirst(tmp);
				}
				return res;
			}
			for (int i = 0; i < word.length(); ++i) {
				char originalCh = word.charAt(i);
				char[] charArr = word.toCharArray();
				for (char ch = 'A'; ch < 'Z'; ++ch) {

					if (ch != originalCh) {
						charArr[i] = ch;
						String newWord = new String(charArr);
						if (dict.contains(newWord)
								&& !visited.contains(newWord)) {
							queue.add(newWord);
							visited.add(newWord);
							backTrackMap.put(newWord, word);
						}
					}
				}
			}
		}

		return res;
	}

	public static void main(String[] args) {
		Set<String> dict = new HashSet<String>();
		dict.add("DAMP");
		dict.add("LAMP");
		dict.add("LIME");
		dict.add("LIMP");
		dict.add("LIKE");

		System.out.println(transform("DAMP", "LIKE", dict));
	}
}
