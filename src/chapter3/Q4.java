package chapter3;

import java.util.Stack;

/**
 * Towers of Hanoi, you have 3 towers and N disks of different size which can
 * slide into any tower. The puzzle starts with disks sorted in asscending order
 * of size from top to bottom (i.e., each disk sits on top of an even larger
 * one). You have the following constrains:
 * 
 * (1) Only one disk can be move at a time. (2) A disk is slid off the top of
 * one tower onto the next tower. (3) A disk can only be placed on the top of a
 * larger disk.
 * 
 * Write a program to move disks from the first tower to the last using stacks.
 * 
 * @author boyxgc
 * 
 */
public class Q4 {

	public static int moveDisks(int n, Tower origin, Tower destination,
			Tower buffer) {
		if (n <= 0) {
			return 0;
		}
		int move = 0;

		/* move n-1 disks from origin to buffer using destination as buffer */
		move += moveDisks(n - 1, origin, buffer, destination);

		/* move top of origin to destination */
		destination.addToTop(origin.removeFromTop());
		move += 1;

		/* move n-1 disks from buffer to destination using origin as buffer */
		move += moveDisks(n - 1, buffer, destination, origin);

		return move;
	}

	public class Tower {
		Stack<Integer> disks;

		public Tower() {
			disks = new Stack<Integer>();
		}

		public void addToTop(Integer disk) {
			disks.push(disk);
		}

		public Integer removeFromTop() {
			return disks.pop();
		}

		public boolean isEmpty() {
			return disks.isEmpty();
		}
	}

	public static void main(String[] args) {
		Tower origin = new Q4().new Tower();
		origin.addToTop(4);
		origin.addToTop(3);
		origin.addToTop(2);
		origin.addToTop(1);

		int moves = moveDisks(4, origin, new Q4().new Tower(),
				new Q4().new Tower());

		System.out.println("Moves: " + moves);

	}

}
