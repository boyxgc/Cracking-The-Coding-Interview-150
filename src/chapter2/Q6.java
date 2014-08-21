package chapter2;

import dataStructure.LinkedListNode;

/**
 * Given a circular singly linked list, implement an algorithm to find the
 * beginning of the loop
 * 
 * @author boyxgc
 * 
 */
public class Q6 {

	/*
	 * Use two pointers, one slow pointer with one move per time, and the other
	 * fast pointer with twice the speed.
	 */
	public static LinkedListNode<?> findLoopBeginning(LinkedListNode<?> head) {
		LinkedListNode<?> slow = head;
		LinkedListNode<?> fast = head;

		/* move with different speed until meeting with each other */
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				break;
			}
		}

		/* no meeting point, no loop */
		if (fast == null || fast.next == null) {
			return null;
		}

		/*
		 * slow pointer restarts from the head with speed of one move per time,
		 * fast pointer stays at the point it is and changes its speed to
		 * slow's, move simultaneously until meeting with each other
		 */
		slow = head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}

		return slow;
	}

	public static void main(String[] args) {
		LinkedListNode<Integer> head = new LinkedListNode<Integer>(0);
		LinkedListNode<Integer> node1 = new LinkedListNode<Integer>(1);
		LinkedListNode<Integer> node2 = new LinkedListNode<Integer>(2);
		LinkedListNode<Integer> node3 = new LinkedListNode<Integer>(3);
		LinkedListNode<Integer> node4 = new LinkedListNode<Integer>(4);
		LinkedListNode<Integer> node5 = new LinkedListNode<Integer>(5);

		head.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node3; // node3 is the beginning of the loop

		System.out.println(findLoopBeginning(head).data);
	}
}
