package chapter8;

import java.util.LinkedList;

/**
 * Design and implement a hash table which uses chaining to handle collisions
 * 
 * @author boyxgc
 * 
 */
public class Q10 {

	public static class HashTable<K, V> {

		private static final int MAX_SIZE = 20;

		private LinkedList<Pair<K, V>>[] items;

		@SuppressWarnings("unchecked")
		public HashTable() {
			items = (LinkedList<Pair<K, V>>[]) new LinkedList[MAX_SIZE];
		}

		private int getHashCode(K key) {
			return key.toString().hashCode() % MAX_SIZE;
		}

		public void add(K key, V value) {
			int index = getHashCode(key);
			LinkedList<Pair<K, V>> bucket = items[index];
			if (bucket == null) {
				bucket = new LinkedList<Pair<K, V>>();
			}
			for (Pair<K, V> pair : bucket) {
				if (pair.keyEqual(key)) {
					bucket.remove(pair);
					break;
				}
			}
			bucket.add(new Pair<K, V>(key, value));
		}

		public V get(K key) {
			int index = getHashCode(key);
			LinkedList<Pair<K, V>> bucket = items[index];
			if (bucket == null) {
				return null;
			}

			for (Pair<K, V> pair : bucket) {
				if (pair.keyEqual(key)) {
					return pair.getValue();
				}
			}

			return null;
		}

		public void remove(K key) {
			int index = getHashCode(key);
			LinkedList<Pair<K, V>> bucket = items[index];

			if (bucket != null) {
				for (Pair<K, V> pair : bucket) {
					if (pair.keyEqual(key)) {
						bucket.remove(pair);
						break;
					}
				}
			}
		}
	}

	public static class Pair<K, V> {
		private K key;
		private V value;

		public Pair(K _key, V _value) {
			key = _key;
			value = _value;
		}

		public K getKey() {
			return key;
		}

		public V getValue() {
			return value;
		}

		public boolean equal(Pair<K, V> pair) {
			return key.equals(pair.getKey()) && value.equals(pair.getValue());
		}

		public boolean keyEqual(K _key) {
			return key.equals(_key);
		}
	}
}
