package dataStructure;

public class BiTreeNode<T> {

	public T data;
	public BiTreeNode<T> left;
	public BiTreeNode<T> right;

	public BiTreeNode() {
	}

	public BiTreeNode(T _data) {
		data = _data;
	}

	public BiTreeNode(T _data, BiTreeNode<T> _left, BiTreeNode<T> _right) {
		data = _data;
		left = _left;
		right = _right;
	}
}
