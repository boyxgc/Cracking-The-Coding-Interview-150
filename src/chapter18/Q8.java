package chapter18;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Given a string s and an array of smaller strings T, design a method to search
 * s for each small string in T
 * 
 * @author boyxgc
 * 
 */
public class Q8 {

	public static class SuffixTreeNode {
		private HashMap<Character, SuffixTreeNode> children;
		private char value;
		private ArrayList<Integer> indexes;

		public SuffixTreeNode() {
			children = new HashMap<Character, SuffixTreeNode>();
			indexes = new ArrayList<Integer>();
		}

		public void insertString(String s, int index) {
			indexes.add(index);
			if (s != null && s.length() > 0) {
				value = s.charAt(0);
				SuffixTreeNode child = null;
				if (children.containsKey(value)) {
					child = children.get(value);
				} else {
					child = new SuffixTreeNode();
					children.put(value, child);
				}
				child.insertString(s.substring(1), index);
			}
		}

		public ArrayList<Integer> search(String s) {
			if (s == null || s.length() == 0) {
				return indexes;
			} else {
				char first = s.charAt(0);
				if (children.containsKey(first)) {
					return children.get(first).search(s.substring(1));
				}
			}
			return null;
		}
	}

	public static class SuffixTree {
		private SuffixTreeNode root;

		public SuffixTree(String s) {
			root = new SuffixTreeNode();
			for (int i = 0; i < s.length(); ++i) {
				root.insertString(s.substring(i), i);
			}
		}

		public ArrayList<Integer> search(String s) {
			return root.search(s);
		}
	}

	public static void main(String[] args) {
		SuffixTree sftree = new SuffixTree("bibsabs");
		System.out.println(sftree.search("bs").toString());
	}
}
