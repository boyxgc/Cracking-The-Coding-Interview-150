package chapter17;

/**
 * Consider a simple node-like structure call BiNode,
 * 
 * public class BiNode {
 * 
 * public BiNode node1, node2;
 * 
 * public int data;
 * 
 * }
 * 
 * BiNode can represent binary tree and also doubly-linked list, Implement a
 * method to convert a binary search tree into a doubly linked list. The values
 * should be kept in order.
 * 
 * @author boyxgc
 * 
 */
public class Q13 {

	public static class BiNode {
		public BiNode node1;
		public BiNode node2;
		public int data;

		public BiNode(int d) {
			data = d;
		}
	}

	public static BiNode convert(BiNode root) {
		return convert(root, true);
	}

	private static BiNode convert(BiNode root, boolean returnListLeft) {
		if (root == null) {
			return null;
		}

		BiNode leftMax = convert(root.node1, false);// convert left
		if (leftMax != null)
			leftMax.node2 = root;
		root.node1 = leftMax;

		BiNode rightMin = convert(root.node2, true);// convert right
		if (rightMin != null)
			rightMin.node1 = root;
		root.node2 = rightMin;

		if (returnListLeft) {
			while (root.node1 != null) {
				root = root.node1;
			}
			return root;
		} else {
			while (root.node2 != null) {
				root = root.node2;
			}
			return root;
		}
	}

	public static void main(String[] args) {
		BiNode n1 = new BiNode(1);
		BiNode n2 = new BiNode(2);
		BiNode n3 = new BiNode(3);
		BiNode n4 = new BiNode(4);
		BiNode n5 = new BiNode(5);
		BiNode n6 = new BiNode(6);
		BiNode n7 = new BiNode(7);
		BiNode n8 = new BiNode(8);

		n6.node1 = n2;
		n2.node1 = n1;
		n2.node2 = n4;
		n4.node1 = n3;
		n4.node2 = n5;
		n6.node2 = n8;
		n8.node1 = n7;

		BiNode listhead = convert(n6);

		BiNode tmp = listhead;
		while (tmp != null) {
			System.out.print(tmp.data + " ");
			tmp = tmp.node2;
		}
	}
}
