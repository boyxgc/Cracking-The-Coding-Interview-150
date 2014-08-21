package chapter2;

import java.util.Arrays;
import java.util.HashSet;

import util.Utils;
import dataStructure.LinkedListNode;

/**
 * Remove duplicates from an unsorted linked list
 * 
 * @author boyxgc
 * 
 */
public class Q1 {

	public static void removeDups1(LinkedListNode<Integer> head) {
		if (head == null || head.next == null) {
			return;
		}
		HashSet<Integer> hashSet = new HashSet<Integer>();

		LinkedListNode<Integer> node = new LinkedListNode<Integer>();
		node.next = head;

		while (node.next != null) {
			Integer data = node.next.data;
			if (hashSet.contains(data)) {
				// remove duplicate
				node.next = node.next.next;
			} else {
				hashSet.add(data);
				node = node.next;
			}
		}
	}

	public static void removeDups2(LinkedListNode<Integer> head) {
		if (head == null || head.next == null) {
			return;
		}

		LinkedListNode<Integer> node1 = head;
		LinkedListNode<Integer> node2;
		Integer data;

		while (node1 != null) {
			data = node1.data;
			node2 = node1;
			while (node2.next != null) {
				if (node2.next.data.equals(data)) {
					node2.next = node2.next.next;
				} else {
					node2 = node2.next;
				}
			}
			node1 = node1.next;
		}
	}

	public static void main(String[] args) {
		LinkedListNode<Integer> head = Utils.createLinkedList(Arrays.asList(1,
				1, 2, 1, 3, 3));

		Utils.printLinkedList(head);

		removeDups2(head);

		Utils.printLinkedList(head);
	}
}
