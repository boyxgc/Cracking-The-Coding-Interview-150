package chapter2;

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
	
	public static void main(String [] args) {
		LinkedListNode<Integer> head = new LinkedListNode<Integer>(1);
		LinkedListNode<Integer> node1 = new LinkedListNode<Integer>(2);
		LinkedListNode<Integer> node2 = new LinkedListNode<Integer>(3);
		LinkedListNode<Integer> node3 = new LinkedListNode<Integer>(4);
		LinkedListNode<Integer> node4 = new LinkedListNode<Integer>(5);
		LinkedListNode<Integer> node5 = new LinkedListNode<Integer>(6);
		head.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		
		System.out.println(findLastKth(head, 3).data);
	}
}
