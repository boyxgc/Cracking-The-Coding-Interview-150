package chapter9;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Write a method to return all the subsets of a set
 * 
 * @author boyxgc
 * 
 */
public class Q4 {

	public static ArrayList<ArrayList<Integer>> getSubSets(
			final ArrayList<Integer> set) {

		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		/* add empty set as the first subset */
		ArrayList<Integer> emptySet = new ArrayList<Integer>();
		result.add(emptySet);

		subsets(set, result, -1, emptySet);

		return result;
	}

	private static void subsets(final ArrayList<Integer> set,
			ArrayList<ArrayList<Integer>> result, int position,
			ArrayList<Integer> lastSubSet) {

		for (int i = position + 1; i < set.size(); ++i) {
			ArrayList<Integer> newSubSet = new ArrayList<Integer>(lastSubSet);
			newSubSet.add(set.get(i));
			result.add(newSubSet);
			subsets(set, result, i, newSubSet);
		}
	}

	public static ArrayList<ArrayList<Integer>> getSubSets2(
			final ArrayList<Integer> set) {
		return getSubSets2(set, 0);
	}

	private static ArrayList<ArrayList<Integer>> getSubSets2(
			final ArrayList<Integer> set, int index) {
		ArrayList<ArrayList<Integer>> allSubSets;
		if (index == set.size()) {
			allSubSets = new ArrayList<ArrayList<Integer>>();
			/* add empty set */
			allSubSets.add(new ArrayList<Integer>());
		} else {
			allSubSets = getSubSets2(set, index + 1);
			Integer item = set.get(index);
			ArrayList<ArrayList<Integer>> moreSubSets = new ArrayList<ArrayList<Integer>>();
			for (ArrayList<Integer> subset : allSubSets) {
				ArrayList<Integer> newSubSet = new ArrayList<Integer>(subset);
				newSubSet.add(item);
				moreSubSets.add(newSubSet);
			}
			allSubSets.addAll(moreSubSets);
		}
		return allSubSets;
	}

	public static void main(String[] args) {
		ArrayList<Integer> set = new ArrayList<Integer>(Arrays.asList(3, 1, 2,
				4));
		ArrayList<ArrayList<Integer>> allSubSets = getSubSets(set);

		for (int i = 0; i < allSubSets.size(); ++i) {
			System.out.print(i + ":\t");
			for (Integer integer : allSubSets.get(i)) {
				System.out.print(integer + " ");
			}
			System.out.println();
		}
	}
}
