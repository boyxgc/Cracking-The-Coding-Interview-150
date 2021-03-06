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
		queue.add(root);

		while (!queue.isEmpty()) {

			LinkedList<TreeNode<?>> list = new LinkedList<TreeNode<?>>();
			Queue<TreeNode<?>> nextQueue = new LinkedList<TreeNode<?>>();

			while (!queue.isEmpty()) {
				TreeNode<?> node = queue.remove();
				list.add(node);

				if (node.left != null) {
					nextQueue.add(node.left);
				}
				if (node.right != null) {
					nextQueue.add(node.right);
				}
			}

			lists.add(list);
			queue = nextQueue;
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
