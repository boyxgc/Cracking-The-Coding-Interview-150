package chapter2;

import java.util.Arrays;

import util.Utils;
import dataStructure.LinkedListNode;

/**
 * Implement a function to check if a linked list is a palindrome
 * 
 * @author boyxgc
 * 
 */
public class Q7 {

	/*
	 * Reverse the second half and compare with fist half, then reverse the
	 * second half back to its original order, time complexity O(n), space
	 * complexity O(1)
	 */
	public static boolean isPalindrome(LinkedListNode<?> head) {
		if (head == null) {
			return false;
		}

		if (head.next == null) {
			return true;
		}
		/* use two pointers with different speed to split list into two halves */
		LinkedListNode<?> slow = head;
		LinkedListNode<?> fast = head;
		while (fast != null && fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		LinkedListNode<?> secondHalf = slow.next;
		slow.next = null;

		secondHalf = reverse(secondHalf);

		LinkedListNode<?> firstHalf = head;
		while (firstHalf != null && secondHalf != null) {
			if (!firstHalf.data.equals(secondHalf.data)) {
				return false;
			}
			firstHalf = firstHalf.next;
			secondHalf = secondHalf.next;
		}

		/* skipping the part of reversing the second half back */

		return true;
	}

	private static <T> LinkedListNode<T> reverse(LinkedListNode<T> head) {
		LinkedListNode<T> p = head;
		LinkedListNode<T> q = head;

		LinkedListNode<T> tmp;
		while (p.next != null) {
			tmp = p.next.next;
			p.next.next = q;
			q = p.next;
			p.next = tmp;
		}

		return q;
	}

	public static void main(String[] args) {
		LinkedListNode<Integer> head = Utils.createLinkedList(Arrays.asList(1,
				2, 3, 2, 1));

		System.out.println(isPalindrome(head));
	}
}
