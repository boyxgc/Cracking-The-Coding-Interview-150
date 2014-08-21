package chapter2;

import java.util.Arrays;

import util.Utils;
import dataStructure.LinkedListNode;

/**
 * Find the kth last element of a singly linked list
 * 
 * @author boyxgc
 * 
 */
public class Q2 {
	public static LinkedListNode<Integer> findLastKth(
			LinkedListNode<Integer> head, int k) {
		if (head == null) {
			return null;
		}
		LinkedListNode<Integer> first = head;
		LinkedListNode<Integer> second = head;

		for (int i = 1; i < k; ++i) {
			if (second == null) {
				return null;
			}
			second = second.next;
		}

		while (second.next != null) {
			first = first.next;
			second = second.next;
		}

		return first;
	}

	public static void main(String[] args) {

		LinkedListNode<Integer> head = Utils.createLinkedList(Arrays.asList(1,
				2, 3, 4, 5, 6));

		System.out.println(findLastKth(head, 3).data);
	}
}
