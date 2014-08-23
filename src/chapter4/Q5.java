package chapter4;

import dataStructure.TreeNode;

/**
 * Implement a function to check if a binary tree is a binary search tree
 * @author boyxgc
 *
 */
public class Q5 {

	public static boolean isBST(TreeNode<Integer> root) {
		
		//Wrong solution
		//return (root != null && isBST2(root));
		
		return (root != null && isBST3(root, null, null));
	}
	
	/**
	 * Wrong Solution !!!!! 
	 * 
	 * Try BST: 20.left = 10, 20.right = 30, 10.right = 25
	 */
	public static boolean isBST2(TreeNode<Integer> root) {
		if(root == null) {
			return true;
		}
		if(root.left != null && root.data < root.left.data ) {
			return false;
		}
		if(root.right != null && root.data >= root.right.data) {
			return false;
		}
		
		if(!isBST2(root.left)) {
			return false;
		}
		
		return isBST2(root.right);
	}
	
	/*
	 * root.data mustn't be lesseq than min or greater than max
	 */
	public static boolean isBST3(TreeNode<Integer> root, Integer min, Integer max) {
		
		if(root == null) {
			return true;
		}
		
		if(min != null && root.data <= min || max != null && root.data > max) {
			return false;
		}
		
		if(!isBST3(root.left, min, root.data) || !isBST3(root.right, root.data, max)) {
			return false;
		}
		
		return true;
	}
	
	public static void main(String [] args) {
		TreeNode<Integer> node20 = new TreeNode<Integer>(20);
		TreeNode<Integer> node10 = new TreeNode<Integer>(10);
		TreeNode<Integer> node25 = new TreeNode<Integer>(25);
		TreeNode<Integer> node30 = new TreeNode<Integer>(30);
		TreeNode<Integer> node40 = new TreeNode<Integer>(40);
		
		node20.left = node10;
		node20.right = node30;
		node30.left = node25;
		System.out.println(isBST(node20));
		
		node25.right = node40;
		System.out.println(isBST(node20));
		
		System.out.println(isBST(null));
	}
}
