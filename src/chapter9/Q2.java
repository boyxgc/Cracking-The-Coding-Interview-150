package chapter9;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;

/**
 * Imaging a robot sitting on the upper left corner of an X by Y grid. The robot
 * can only move in two directions: right and down. How many possible paths are
 * there for the robot to go from (0,0) to (X, Y) ?
 * 
 * Follow up:
 * 
 * Imagine certain sports are "off limits", such that the robot cannot step on
 * them. Design an algorithm to find a path for the robot from the top left to
 * the bottom right.
 * 
 * @author boyxgc
 * 
 */
public class Q2 {

	public static int countPathsWithoutOffpoints(Point endPoint) {

		if (endPoint.x == 0 || endPoint.y == 0) {
			return 1;
		}
		int X = endPoint.x;
		int Y = endPoint.y;
		int[][] count = new int[X + 1][Y + 1];

		/* init 0th col and 0th row */
		Arrays.fill(count[0], 1);
		for (int i = 0; i <= Y; ++i) {
			count[i][0] = 1;
		}

		for (int i = 1; i <= X; i++) {
			for (int j = 1; j <= Y; ++j) {
				count[i][j] += count[i - 1][j];
				count[i][j] += count[i][j - 1];
			}
		}

		return count[X][Y];
	}

	public static boolean getPathWithOffpoints(Point endPoint,
			List<Point> offPoints) {

		if (offPoints.contains(new Point(endPoint.x, endPoint.y))
				|| offPoints.contains(new Point(0, 0))) {
			return false;
		}

		Hashtable<Point, Boolean> cache = new Hashtable<Point, Boolean>();
		return getPathWithOffpoints(endPoint.x, endPoint.y, new HashSet<Point>(
				offPoints), cache);
	}

	private static boolean getPathWithOffpoints(int x, int y,
			HashSet<Point> offPoints, Hashtable<Point, Boolean> cache,
			List<Point> path) {
		Point point = new Point(x, y);
		if (x == 0 && y == 0) {
			return true;
		}
		if (x < 0 || y < 0) {
			return false;
		}
		if (cache.containsKey(point)) {
			return cache.get(point);
		}

		boolean success = false;
		if (!offPoints.contains(new Point(x - 1, y))) {
			success = getPathWithOffpoints(x - 1, y, offPoints, cache, path);
		}

		if (!success && !offPoints.contains(new Point(x, y - 1))) {
			success = getPathWithOffpoints(x, y - 1, offPoints, cache, path);
		}

		if (success) {
			path.add(point);
		}

		cache.put(point, success);
		return success;
	}

	public static class Point {
		public int x;
		public int y;

		public Point(int _x, int _y) {
			x = _x;
			y = _y;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj instanceof Point) {
				return ((Point) obj).x == x && ((Point) obj).y == y;
			}
			return false;
		}

		/* for using Hashtable and HashSet */
		@Override
		public int hashCode() {
			return (new Integer(x + y)).hashCode();
		}
	}
}
