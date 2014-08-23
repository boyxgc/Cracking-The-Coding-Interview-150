package util;

import java.util.List;

import dataStructure.LinkedListNode;
import dataStructure.TreeNode;

public class Utils {
	public static void printIntMatrix(int[][] matrix, int m, int n) {
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				System.out.print(matrix[i][j] + "  ");
			}
			System.out.println();
		}
	}

	public static void printLinkedList(LinkedListNode<?> head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();
	}

	public static <T> LinkedListNode<T> createLinkedList(List<T> data) {
		if (data.size() == 0) {
			return null;
		}
		LinkedListNode<T> head = new LinkedListNode<T>();
		LinkedListNode<T> p = head;
		for (int i = 0; i < data.size(); ++i) {
			p.next = new LinkedListNode<T>(data.get(i));
			p = p.next;
		}

		return head.next;
	}

	public static <T> void printBiTreePreorder(TreeNode<T> root) {
		if (root != null) {
			System.out.print(root.data + " ");
			printBiTreePreorder(root.left);
			printBiTreePreorder(root.right);
		}
	}
}
