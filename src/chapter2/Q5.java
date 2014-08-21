package chapter2;

import java.util.Arrays;

import util.Utils;
import dataStructure.LinkedListNode;

/**
 * You have two numbers represented by a linked list, where each node contains a
 * single digit. The digits are store in forward order, such that the 1 's digit
 * is at the head of the list. Write a function that adds the two numbers and
 * returns and sum as a linked list.
 * 
 * EXAMPLE: input: (6->1->7) + (2->9->5). That is, 617 + 295. Output: 9->1->2.
 * That is, 912;
 * 
 * @author boyxgc
 * 
 */
public class Q5 {

	/*
	 * we first reverse two list and add two reverse ord list, O(n)
	 */

	public static LinkedListNode<Integer> add(LinkedListNode<Integer> num1,
			LinkedListNode<Integer> num2) {
		num1 = reverse(num1);
		num2 = reverse(num2);

		LinkedListNode<Integer> newHead = new LinkedListNode<Integer>();
		LinkedListNode<Integer> p = newHead;
		int carry = 0;
		while (num1 != null || num2 != null) {
			int sum = carry;

			if (num1 != null) {
				sum += num1.data;
				num1 = num1.next;
			}

			if (num2 != null) {
				sum += num2.data;
				num2 = num2.next;
			}

			carry = sum / 10;

			p.next = new LinkedListNode<Integer>(sum - carry * 10);
			p = p.next;
		}

		if (carry > 0) {
			p.next = new LinkedListNode<Integer>(carry);
		}

		return reverse(newHead.next);
	}

	public static LinkedListNode<Integer> reverse(LinkedListNode<Integer> head) {
		if (head == null) {
			return null;
		}

		LinkedListNode<Integer> p = head, q = head;

		while (p.next != null) {
			LinkedListNode<Integer> tmp = p.next.next;
			/* set p->next's next to be q */
			p.next.next = q;
			q = p.next;

			p.next = tmp;
		}

		return q;
	}

	public static void main(String[] args) {
		LinkedListNode<Integer> num1 = Utils.createLinkedList(Arrays.asList(6,
				1, 7));
		LinkedListNode<Integer> num2 = Utils.createLinkedList(Arrays.asList(1, 3,
				9, 5));

		Utils.printLinkedList(num1);
		System.out.println("+");
		Utils.printLinkedList(num2);
		System.out.println("=");

		LinkedListNode<Integer> sum = add(num1, num2);

		Utils.printLinkedList(sum);
	}
}
