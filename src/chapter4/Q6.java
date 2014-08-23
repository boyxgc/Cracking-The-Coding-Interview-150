package chapter4;

import dataStructure.TreeNode;

/**
 * Write an algorithm to find the 'next' node (i.e., in-order successor) of a
 * given node, you may assume that each node has a link to its parent
 * 
 * @author boyxgc
 * 
 */
public class Q6 {

	public static TreeNode<?> findNext(TreeNode<?> node) {

		if(node == null) {
			return null;
		}
		/* if it has right subtree */
		if (node.right != null) {
			/* get the leftmost of the subtree */
			TreeNode<?> leftMost = node.right;
			while (leftMost.left != null) {
				leftMost = leftMost.left;
			}
			return leftMost;
		}
		/*get its ancestor which is a left child of some node*/
		else {
			TreeNode<?> tmp = node;
			while(tmp.parent != null && tmp.parent.left != tmp) {
				tmp = tmp.parent;
			}
			
			/*if node is already the rightmost one, then tmp.parent is null*/
			
			return tmp.parent;
		}
	}
}
