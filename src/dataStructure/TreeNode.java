package dataStructure;

public class TreeNode<T> {
	public T data;
	public TreeNode<T> left;
	public TreeNode<T> right;
	
	public String name;
	public TreeNode<T> parent;

	public TreeNode() {
	}

	public TreeNode(T _data) {
		data = _data;
	}
	
	public TreeNode(String _name, T _data) {
		name = _name;
		data = _data;
	}

	public TreeNode(T _data, TreeNode<T> _left, TreeNode<T> _right) {
		data = _data;
		left = _left;
		right = _right;
	}
}
