package chapter11;

/**
 * Given a MxN matrix in which each row and each column is sorted in descending
 * order, Write a method to find a element
 * 
 * @author boyxgc
 * 
 */
public class Q6 {

	public static class Position {
		int row;
		int col;

		public Position(int _row, int _col) {
			row = _row;
			col = _col;
		}
	}

	public static Position findElement(int[][] matrix, int elem) {
		if (matrix.length == 0) {
			return new Position(-1, -1);
		}
		int low, high, mid = 0;

		low = 0;
		high = matrix.length - 1;

		while (low <= high) {
			mid = (low + high) / 2;

			if (matrix[mid][0] == elem) {
				return new Position(mid, 0);
			} else if (matrix[mid][0] > elem) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}

		int row = matrix[mid][0] > elem && mid > 0 ? mid - 1 : mid;

		low = 0;
		high = matrix[row].length - 1;

		while (low <= high) {
			mid = (low + high) / 2;

			if (matrix[row][mid] == elem) {
				return new Position(row, mid);
			} else if (matrix[row][mid] > elem) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}

		return new Position(-1, -1);
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };

		Position position = findElement(matrix, -1);
		System.out.println("(" + position.row + "," + position.col + ")");
	}
}
