package dataStructure;

import java.util.LinkedList;
import java.util.List;

public class GraphNode<T> {

	public T data;
	public List<GraphNode<T>> nexts;
	public boolean isVisited;

	public GraphNode() {
		nexts = new LinkedList<GraphNode<T>>();
	}

	public GraphNode(T _data) {
		data = _data;
		nexts = new LinkedList<GraphNode<T>>();
	}
}
