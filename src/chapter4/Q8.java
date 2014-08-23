package chapter4;

import dataStructure.TreeNode;

/**
 * You have two large binary trees: T1, with millions of nodes, and T2, with
 * hundreds of nodes. Create an algorithm to decide if T2 is a subtree of T1
 * 
 * T2 is subtree of T1 if there exists a node n such that the subtree of n is
 * identical to T2
 * 
 * @author boyxgc
 * 
 */
public class Q8 {

	public boolean containsTree(TreeNode<?> root, TreeNode<?> subTreeRoot) {
		if (subTreeRoot == null) {
			return true;
		}
		return isSubTree(root, subTreeRoot);
	}

	public boolean isSubTree(TreeNode<?> root, TreeNode<?> subTreeRoot) {

		if (root == null) {
			return false;
		}
		if (root.data == subTreeRoot.data) {
			if (matchTree(root, subTreeRoot)) {
				return true;
			}
		}

		return (isSubTree(root.left, subTreeRoot) || isSubTree(root.right,
				subTreeRoot));
	}

	private boolean matchTree(TreeNode<?> root1, TreeNode<?> root2) {
		if (root1 == null && root2 == null) {
			return true;
		}

		if (root1 == null || root2 == null) {
			return false;
		}

		if (root1.data != root2.data) {
			return false;
		}

		return matchTree(root1.left, root2.left)
				&& matchTree(root1.right, root2.right);
	}

}
