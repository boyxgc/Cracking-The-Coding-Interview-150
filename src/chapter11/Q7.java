package chapter11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;

/**
 * A circus is designing a tower routine consisting of people standing atop one
 * another's shoulders. For practical and aesthetic reasons, each person must be
 * both shorter and lighter than the person below him or her. Given the heights
 * and weights of each person in the circus, write a method to compute the
 * largest possible number of people in such a tower
 * 
 * EXAMPLE:
 * 
 * input: (65, 100) (70, 150) (56, 90) (75, 100) (60, 95) (68, 110)
 * 
 * output: (56, 90) (60, 95) (65, 100) (68, 110) (70, 150) (75, 100)
 * 
 * @author boyxgc
 * 
 */
public class Q7 {

	public static class Person implements Comparable<Person> {
		int height;
		int weight;

		public Person(int _height, int _weight) {
			height = _height;
			weight = _weight;
		}

		public boolean isOntopOf(Person p) {
			return p.height > height && p.weight > weight;
		}

		@Override
		public int compareTo(Person arg0) {
			if (arg0.height < height && arg0.weight < weight) {
				return 1;
			}
			return -1;
		}

	}

	/*
	 * not the best solution, runtime O(n^2)
	 */
	public static int longestIncreasingSeq(ArrayList<Person> circus) {
		Collections.sort(circus);

		Hashtable<Person, Integer> hashtable = new Hashtable<Person, Integer>();

		for (int i = 0; i < circus.size(); ++i) {
			Person curr = circus.get(i);
			if (!hashtable.containsKey(curr)) {
				hashtable.put(curr, 1);
			}
			int max_prev = 0;
			for (int j = 0; j < i; ++j) {
				Person prev = circus.get(j);
				if (prev.isOntopOf(curr) && hashtable.get(prev) > max_prev) {
					max_prev = hashtable.get(prev);
				}
			}
			hashtable.put(curr, hashtable.get(curr) + max_prev);
		}

		int max = 0;
		for (Person p : circus) {
			if (hashtable.get(p) > max) {
				max = hashtable.get(p);
			}
		}
		return max;
	}

	public static void main(String[] args) {
		ArrayList<Person> list = new ArrayList<Person>();
		list.add(new Person(65, 100));
		list.add(new Person(70, 150));
		list.add(new Person(56, 90));
		list.add(new Person(75, 190));
		list.add(new Person(60, 95));
		list.add(new Person(68, 110));

		System.out.println(longestIncreasingSeq(list));
	}
}
