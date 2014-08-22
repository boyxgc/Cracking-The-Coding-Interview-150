package chapter4;

import dataStructure.TreeNode;

/**
 * Implement a function to check if a binary tree is balanced. A balanced tree
 * is defined to be a tree such that the heights of the two subtrees of any node
 * never differ by more than one
 * 
 * @author boyxgc
 * 
 */
public class Q1 {

	/*
	 * a traverse of all the nodes, time complexity O(n), space complexity O(h)
	 */
	public static <T> boolean isBalanced(TreeNode<T> root) {
		return (root == null || height(root) != -1);
	}

	private static <T> int height(TreeNode<T> root) {
		if (root == null) {
			return 0;
		}

		int leftHeight = height(root.left);
		if (leftHeight == -1) {
			return -1;
		}

		int rightHeight = height(root.right);
		if (rightHeight == -1) {
			return -1;
		}

		if (Math.abs(leftHeight - rightHeight) > 1) {
			return -1;
		}
		return Math.max(leftHeight, rightHeight) + 1;
	}

	public static void main(String[] args) {
		TreeNode<Integer> root = new TreeNode<Integer>();
		TreeNode<Integer> left1 = new TreeNode<Integer>();
		TreeNode<Integer> right1 = new TreeNode<Integer>();
		TreeNode<Integer> left11 = new TreeNode<Integer>();
		TreeNode<Integer> left111 = new TreeNode<Integer>();
		root.left = left1;
		left1.left = left11;
		left11.left = left111;
		root.right = right1;

		System.out.println(isBalanced(root));
	}

}
