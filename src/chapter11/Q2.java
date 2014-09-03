package chapter11;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.LinkedList;

/**
 * Write a method to sort an array of strings so that all the anagrams are next
 * to each other
 * 
 * @author boyxgc
 * 
 */
public class Q2 {

	public static void groupByAnagrams(String[] strs) {
		Hashtable<String, LinkedList<String>> hashtable = new Hashtable<String, LinkedList<String>>();

		for (String str : strs) {
			char[] array = str.toCharArray();
			Arrays.sort(array);
			String sorted = new String(array);

			if (!hashtable.containsKey(sorted)) {
				hashtable.put(sorted, new LinkedList<String>());
			}
			hashtable.get(sorted).add(str);
		}

		int index = 0;
		for (String key : hashtable.keySet()) {
			LinkedList<String> list = hashtable.get(key);
			for (String item : list) {
				strs[index++] = item;
			}
		}
	}

	public static void main(String[] args) {
		String[] strs = { "hello", "world", "usc", "dlwro", "llohe", "ucla" };
		groupByAnagrams(strs);
		for (int i = 0; i < strs.length; ++i) {
			System.out.print(strs[i] + " ");
		}
	}
}
