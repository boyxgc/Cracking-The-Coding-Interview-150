package chapter9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * You have a stack of n boxes, with widths wi, heights hi, and depths di. The
 * boxes cannot be rotated and can only be stacked on top of one another if each
 * box in the stack is strictly larger than the box above it in width, height,
 * and depth. Implement a method to build the tallest stack possible, where the
 * height of a stack is the sum of the heights of each box
 * 
 * @author boyxgc
 * 
 */
public class Q10 {

	public static class Box {
		public int id;
		public int width;
		public int height;
		public int depth;

		public Box(int _id, int _width, int _height, int _depth) {
			id = _id;
			width = _width;
			height = _height;
			depth = _depth;
		}
	}

	public static class Result {
		int height;
		ArrayList<Box> stack;

		public Result() {
			height = 0;
			stack = null;
		}

		@SuppressWarnings("unchecked")
		public Result clone() {
			Result result = new Result();
			result.height = height;
			result.stack = (ArrayList<Box>) stack.clone();
			return result;
		}
	}

	public static ArrayList<Box> buildHighestStack(List<Box> boxes) {

		Result result = new Result();
		HashMap<Box, Result> cache = new HashMap<Box, Result>();
		for (Box box : boxes) {
			Result tmp = buildHighestStack(boxes, box, cache);
			if (tmp.height > result.height) {
				result = tmp;
			}
		}

		return result.stack;
	}

	private static Result buildHighestStack(List<Box> boxes, Box bottom,
			HashMap<Box, Result> cache) {
		if (cache.containsKey(bottom)) {
			return cache.get(bottom);
		}

		Result maxResult = new Result();

		for (Box box : boxes) {
			/* box can be above bottom */
			if (Math.min(box.width, box.depth) > Math.min(bottom.width,
					bottom.depth)
					&& Math.max(box.width, box.depth) > Math.max(bottom.width,
							bottom.depth)) {
				Result res = buildHighestStack(boxes, box, cache);
				if (res.height > maxResult.height) {
					maxResult = res;
				}
			}
		}

		if (maxResult.stack == null) {
			maxResult.stack = new ArrayList<Box>();
		}
		maxResult.height += bottom.height;
		maxResult.stack.add(bottom);

		cache.put(bottom, maxResult);

		/*
		 * must return a cloned new object, maxResult might be modifies later
		 * which will change the value in the cache map
		 */
		return maxResult.clone();
	}

	public static void main(String[] args) {
		ArrayList<Box> boxes = new ArrayList<Box>();
		boxes.add(new Box(0, 3, 1, 4));
		boxes.add(new Box(1, 2, 2, 3));
		boxes.add(new Box(2, 4, 6, 5));
		boxes.add(new Box(3, 5, 5, 5));

		ArrayList<Box> stack = buildHighestStack(boxes);
		for (Box box : stack) {
			System.out.println(box.id);
		}
	}

}
