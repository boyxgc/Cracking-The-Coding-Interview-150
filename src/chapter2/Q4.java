package chapter2;

import java.util.Arrays;

import util.Utils;
import dataStructure.LinkedListNode;

/**
 * Write code to partition a linked list around a value x, such that all nodes
 * less than x come before all nodes greater than or equal x.
 * 
 * @author boyxgc
 * 
 */
public class Q4 {

	/*
	 * using two pointers to track nodes less than x and nodes gteq x, one scan
	 * of the list, time complexity O(n)
	 */
	public static LinkedListNode<Integer> partition(
			LinkedListNode<Integer> head, int x) {
		/* lead list of nodes that are less than x */
		LinkedListNode<Integer> less = new LinkedListNode<Integer>();
		LinkedListNode<Integer> p1 = less;
		/* lead list of nodes that are greater than or equal x */
		LinkedListNode<Integer> greatOrEqual = new LinkedListNode<Integer>();
		LinkedListNode<Integer> p2 = greatOrEqual;

		LinkedListNode<Integer> p = head;

		while (p != null) {
			if (p.data.intValue() < x) {
				p1.next = p;
				p1 = p1.next;
			} else {
				p2.next = p;
				p2 = p2.next;
			}

			LinkedListNode<Integer> tmp = p.next;
			/* cutoff connection from old list */
			p.next = null;

			p = tmp;
		}

		LinkedListNode<Integer> newNode = new LinkedListNode<Integer>();
		if (less.next == null) {
			newNode.next = greatOrEqual.next;
		} else {
			newNode.next = less.next;
			p1.next = greatOrEqual.next;
		}

		return newNode.next;
	}

	public static void main(String[] args) {
		LinkedListNode<Integer> head = Utils.createLinkedList(Arrays.asList(2,
				5, 4, 1, -1, 8));

		Utils.printLinkedList(head);

		Utils.printLinkedList(partition(head, 2));
	}
}
