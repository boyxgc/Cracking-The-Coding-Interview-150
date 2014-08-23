package chapter4;

import util.Utils;
import dataStructure.TreeNode;

/**
 * Given a sorted array (in ascending order), create a binary search tree with
 * minimal height
 * 
 * @author boyxgc
 * 
 */
public class Q3 {

	public static <T> TreeNode<T> createMinHeightBST(T[] data) {
		return createMinHeightBST(data, 0, data.length - 1);
	}

	/*
	 * select the middle one as the root of the tree, do this recursively
	 */
	private static <T> TreeNode<T> createMinHeightBST(T[] data,
			int fromIndex, int toIndex) {

		if (fromIndex > toIndex) {
			return null;
		}

		int middleIndex = (fromIndex + toIndex) / 2;

		TreeNode<T> root = new TreeNode<T>(data[middleIndex]);

		root.left = createMinHeightBST(data, fromIndex, middleIndex - 1);
		root.right = createMinHeightBST(data, middleIndex + 1, toIndex);

		return root;
	}

	public static void main(String[] args) {

		Integer data[] = { 1, 2, 3, 4, 5, 6, 7 };
		TreeNode<Integer> root = createMinHeightBST(data);

		Utils.printBiTreePreorder(root);
	}
}
