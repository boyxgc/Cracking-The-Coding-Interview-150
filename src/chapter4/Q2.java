package chapter4;

import dataStructure.GraphNode;

/**
 * In a directed graph, find if there is any route between two nodes
 * 
 * @author boyxgc
 * 
 */
public class Q2 {

	public static <T> boolean isRoute(GraphNode<T> node1, GraphNode<T> node2) {

		if (node1 == null || node2 == null) {
			return false;
		}

		/* start a DFS traverse from node1 and check node2 has been visited */
		dfs(node1);

		return node2.isVisited;
	}

	/*
	 * time complexity O(V + E), space complexity O(depth)
	 */
	private static <T> void dfs(GraphNode<T> node1) {
		if (node1 == null) {
			return;
		}

		node1.isVisited = true;

		for (GraphNode<T> next : node1.nexts) {
			if (next != null && !next.isVisited) {
				dfs(next);
			}
		}
	}

	public static void main(String[] args) {
		GraphNode<Integer> node1 = new GraphNode<Integer>();
		GraphNode<Integer> node2 = new GraphNode<Integer>();
		GraphNode<Integer> node3 = new GraphNode<Integer>();
		GraphNode<Integer> node4 = new GraphNode<Integer>();
		GraphNode<Integer> node5 = new GraphNode<Integer>();

		/*
		 * 1 -> 2 -> 3 -> 4 <- 5, 3 -> 1
		 */
		node1.nexts.add(node2);
		node2.nexts.add(node3);
		node3.nexts.add(node4);
		node3.nexts.add(node1);
		node5.nexts.add(node4);

		System.out.println("-Is there any route between node1 and node5 ?\n-"
				+ isRoute(node1, node5));
		System.out.println("-Is there any route between node1 and node4 ?\n-"
				+ isRoute(node1, node4));
	}
}
