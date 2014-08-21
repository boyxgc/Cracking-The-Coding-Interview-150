package chapter2;

import dataStructure.LinkedListNode;

/**
 * Implement an algorithm to delete a node in the middle of a singly linmked
 * list, given only access to that node. (you are given with that node instead
 * of the head)
 * 
 * @author boyxgc
 * 
 */
public class Q3 {
	public static void deleteNode(LinkedListNode<Object> middle) {
		/* this node is the tail */
		if (middle == null || middle.next == null) {
			middle = null;
		} else {
			/* copy data of next node to this one, and delete the next node */
			middle.data = middle.next.data;
			middle.next = middle.next.next;
		}
	}
}
