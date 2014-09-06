package chapter14;

import java.util.Iterator;

/**
 * Implement a CircularArray class that supports an array-like data structure
 * which can be effectively rotated. This class should use a generic type, and
 * should support iteration via the standard for (Obj o : circularArray)
 * notation.
 * 
 * @author boyxgc
 * 
 */
public class Q6 {

	public class CircularArray<T> implements Iterable<T> {

		private int head;
		private T[] items;
		private int length;

		@SuppressWarnings("unchecked")
		public CircularArray(int size) {
			items = (T[]) new Object[size];
		}

		private int convert(int index) {
			if (index < 0) {
				return convert(index + length);
			}
			return (head + index) % length;
		}

		public void rotate(int offset) {
			head = convert(offset);
		}

		public T get(int i) {
			if (i < 0 || i >= length) {
				throw new IndexOutOfBoundsException("...");
			}
			return items[convert(i)];
		}

		public void add(T item) {
			if (length < items.length) {
				items[length++] = item;
			} else {
				throw new RuntimeException("array is full");
			}
		}

		@Override
		public Iterator<T> iterator() {

			return new CircularArrayIterator<T>(this);
		}

		private class CircularArrayIterator<TI> implements Iterator<TI> {

			private int _current = -1;
			private TI[] _items;

			public CircularArrayIterator(CircularArray<TI> array) {
				_items = array.items;
			}

			@Override
			public boolean hasNext() {
				return _current < length - 1;
			}

			@Override
			public TI next() {
				return _items[convert(_current++)];
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException("...");
			}

		}

	}
}
