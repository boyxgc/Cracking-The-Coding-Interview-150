package chapter4;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import dataStructure.TreeNode;

/**
 * Given a binary tree, design an algorithm which creates a linked list of all
 * the nodes at each depth (e.g., if you have a tree with depth D, you'll have D
 * linked lists)
 * 
 * @author boyxgc
 * 
 */
public class Q4 {

	public static List<LinkedList<TreeNode<?>>> createLinkedList(
			TreeNode<?> root) {
		
		List<LinkedList<TreeNode<?>>> lists = new LinkedList<LinkedList<TreeNode<?>>>();
		
		if(root == null) {
			return lists;
		}
		
		Queue<TreeNode<?>> queue = new LinkedList<TreeNode<?>>();
		Queue<Integer> nodeCountQueue = new LinkedList<Integer>();

		queue.add(root);
		nodeCountQueue.add(1);

		while (!queue.isEmpty()) {

			LinkedList<TreeNode<?>> list = new LinkedList<TreeNode<?>>();
			int nodesTobePopped = nodeCountQueue.remove();
			int nextNodesTobePopped = 0;

			while (nodesTobePopped > 0) {
				TreeNode<?> node = queue.remove();
				list.add(node);

				if (node.left != null) {
					queue.add(node.left);
					++nextNodesTobePopped;
				}
				if (node.right != null) {
					queue.add(node.right);
					++nextNodesTobePopped;
				}
				--nodesTobePopped;
			}

			lists.add(list);
			nodeCountQueue.add(nextNodesTobePopped);
		}

		return lists;
	}
	
	public static void main(String [] args) {
		Integer data[] = { 1, 2, 3, 4, 5, 6, 7 };
		TreeNode<Integer> root = Q3.createMinHeightBST(data);
		
		List<LinkedList<TreeNode<?>>> lists = createLinkedList(root);
		
		for(LinkedList<TreeNode<?>> list : lists) {
			for(TreeNode<?> node : list) {
				System.out.print(node.data + " ");
			}
			System.out.println();
		}
	}
}
