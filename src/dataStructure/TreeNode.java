package dataStructure;

public class TreeNode<T> {
	public T data;
	public TreeNode<T> left;
	public TreeNode<T> right;

	public TreeNode() {
	}

	public TreeNode(T _data) {
		data = _data;
	}

	public TreeNode(T _data, TreeNode<T> _left, TreeNode<T> _right) {
		data = _data;
		left = _left;
		right = _right;
	}
}
