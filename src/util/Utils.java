package util;

import dataStructure.LinkedListNode;

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
}
