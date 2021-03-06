package chapter4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import dataStructure.TreeNode;

/**
 * Write a program to print all the paths that sum up to a given value. The path
 * does not need to start or end at the root or leaf.
 * 
 * @author boyxgc
 * 
 */
public class Q9 {

	public static class Path {
		int sum;
		List<TreeNode<Integer>> nodes;

		public Path() {
			nodes = new LinkedList<TreeNode<Integer>>();
		}

		public Path(Path path) {
			sum = path.sum;
			nodes = new LinkedList<TreeNode<Integer>>(path.nodes);
		}
	}

	public static List<Path> findPaths(TreeNode<Integer> root, int sum) {
		List<Path> paths = new ArrayList<Path>();

		generatePaths(root, new Q9.Path(), sum, paths);

		return paths;
	}

	/*
	 * SOLUTION 1
	 * 
	 * time complexity O(n^2) , n is number of nodes
	 */
	private static void generatePaths(TreeNode<Integer> node, Path path,
			int aimSum, List<Path> paths) {
		if (node == null) {
			return;
		}

		path.sum += node.data;
		path.nodes.add(node);

		if (path.sum == aimSum) {
			paths.add(path);
		}

		/* extend current path */
		generatePaths(node.left, new Path(path), aimSum, paths);
		generatePaths(node.right, new Path(path), aimSum, paths);

		/* start two new paths */
		generatePaths(node.left, new Path(), aimSum, paths);
		generatePaths(node.right, new Path(), aimSum, paths);
	}

	/*
	 * SOLUTION 2
	 * 
	 * find the paths upwards from the current node that sum up to the value
	 * 
	 * pre-new a node array as path with its size be the depth of the tree
	 * 
	 * time complexity O(n*log(n))
	 */
	public static void generatePath(TreeNode<Integer> root, int sum,
			TreeNode<Integer>[] path, int level) {
		if (root == null) {
			return;
		}

		path[level] = root;
		int tmpSum = 0;
		/* find paths ending with this node that sum up to the given value */
		for (int i = level; i >= 0; --i) {
			tmpSum += path[i].data;
			if (tmpSum == sum) {
				/*
				 * print path[i...level] here
				 */
			}
		}

		generatePath(root.left, sum, path, level + 1);
		generatePath(root.right, sum, path, level + 1);

		/*
		 * remove the node from the current path, not necessary here, but good
		 * practice
		 */
		path[level] = null;
	}

	public static void main(String[] args) {
		TreeNode<Integer> nodea = new TreeNode<Integer>("a", 1);
		TreeNode<Integer> nodeb = new TreeNode<Integer>("b", 2);
		TreeNode<Integer> nodec = new TreeNode<Integer>("c", 3);
		TreeNode<Integer> noded = new TreeNode<Integer>("d", 1);
		TreeNode<Integer> nodee = new TreeNode<Integer>("e", 2);
		TreeNode<Integer> nodef = new TreeNode<Integer>("f", 3);
		TreeNode<Integer> nodeg = new TreeNode<Integer>("g", 3);
		TreeNode<Integer> nodeh = new TreeNode<Integer>("h", 4);
		TreeNode<Integer> nodei = new TreeNode<Integer>("i", 2);

		nodea.left = nodeb;
		nodeb.left = nodec;
		nodec.left = noded;
		noded.left = nodee;
		nodea.right = nodeh;
		nodeb.right = nodef;
		nodeh.right = nodei;
		nodef.right = nodeg;

		List<Path> paths = findPaths(nodea, 8);

		for (Path path : paths) {
			for (TreeNode<Integer> node : path.nodes) {
				System.out.print(node.name + "#" + node.data + " ");
			}
			System.out.println();
		}
	}
}
