package dataStructure;

public class LinkedListNode<T> {

	public T data;

	public LinkedListNode<T> next;

	public LinkedListNode(T data) {
		this.data = data;
		this.next = null;
	}

	public LinkedListNode() {
		this.data = null;
		this.next = null;
	}
}
