package chapter4;

import dataStructure.TreeNode;

/**
 * Design an algorithm and write code to find the first common ancestor of two
 * nodes in a binary tree. Avoid storing additional nodes in a data structure.
 * 
 * @author boyxgc
 * 
 */
public class Q7 {

	private static class Result {
		TreeNode<?> node;
		boolean isAncestor;

		public Result(TreeNode<?> _node, boolean _isAncestor) {
			node = _node;
			isAncestor = _isAncestor;
		}
	}

	public static TreeNode<?> findFirstCommonAncestor(TreeNode<?> root,
			TreeNode<?> node1, TreeNode<?> node2) {

		if (root == null || node1 == null || node2 == null) {
			return null;
		}

		Result result = findFirstCommonAncestorHelper(root, node1, node2);

		/*if one node belongs to the tree, the other doesn't, result.node is not null*/
		return (result.isAncestor) ? result.node : null;
	}

	private static Result findFirstCommonAncestorHelper(TreeNode<?> root,
			TreeNode<?> node1, TreeNode<?> node2) {

		if (root == null) {
			return new Result(null, false);
		}

		Result leftResult = findFirstCommonAncestorHelper(root.left, node1,
				node2);
		if (leftResult.isAncestor) {
			return leftResult;
		}

		Result rightResult = findFirstCommonAncestorHelper(root.left, node1,
				node2);
		if (rightResult.isAncestor) {
			return rightResult;
		}

		if (leftResult.node != null && rightResult.node != null) {
			return new Result(root, true);
		} else if (root == node1 || root == node2) {
			return new Result(root, leftResult.node != null || rightResult.node != null);
		} else {
			return leftResult.node != null ? leftResult : rightResult;
		}

	}
}
