package chapter11;

/**
 * Given a MxN matrix in which each row and each column is sorted in descending
 * order, Write a method to find a element
 * 
 * EXAMPLE:
 * 
 * {{ 15, 20, 70, 85 },
 * 
 * { 20, 35, 80, 95 },
 * 
 * { 30, 55, 95, 105 },
 * 
 * { 40, 80, 100, 120 }}
 * 
 * @author boyxgc
 * 
 */
public class Q6 {

	public static class Position implements Cloneable {
		int row;
		int col;

		public Position(int _row, int _col) {
			row = _row;
			col = _col;
		}

		public boolean equals(Position pos) {
			return row == pos.row && col == pos.col;
		}

		public Position clone() {
			return new Position(row, col);
		}

		public void setPos(int newRow, int newCol) {
			row = newRow;
			col = newCol;
		}

	}

	/**
	 * WRONG ANSWER !! Lines below are not guaranteed to be larger than lines
	 * above
	 * 
	 * @param matrix
	 * @param elem
	 * @return
	 */
	public static Position findElementWrong(int[][] matrix, int elem) {
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

	/**
	 * CORRECT ANWSER
	 * 
	 * @param matrix
	 * @param elem
	 * @return
	 */
	public static Position findElement(int[][] matrix, int elem) {

		return findElement(matrix, elem, new Position(0, 0), new Position(
				matrix.length - 1, matrix[0].length - 1));
	}

	private static Position findElement(int[][] matrix, int elem,
			Position origin, Position dest) {

		if (origin.equals(dest)) {
			if (matrix[origin.row][origin.col] == elem) {
				return new Position(origin.row, origin.col);
			} else {
				return new Position(-1, -1);
			}
		}

		// System.out.print("(" + origin.row + "," + origin.col + ") -> ("
		// + dest.row + "," + dest.col + ")");

		// find middle of diagonal
		Position low = origin.clone();
		Position high = dest.clone();
		int mid_row = 0, mid_col = 0;
		while (low.row <= high.row && low.col <= high.col) {
			mid_row = (low.row + high.row) / 2;
			mid_col = (low.col + high.col) / 2;

			int tmpElem = matrix[mid_row][mid_col];
			if (tmpElem == elem) {
				return new Position(mid_row, mid_col);
			} else if (tmpElem > elem) {
				high.setPos(mid_row - 1, mid_col - 1);
			} else {
				low.setPos(mid_row + 1, mid_col + 1);
			}
		}

		// System.out.println(mid_row + "," + mid_col);

		// search sub areas
		if (matrix[mid_row][mid_col] < elem) {
			if (mid_row == dest.row && mid_col == dest.col) { // couldn't find
																// larger
																// elements
				return new Position(-1, -1);
			}
			Position find1 = findElement(matrix, elem,
					new Position(Math.min(mid_row + 1, dest.row), origin.col),
					new Position(dest.row, mid_col));
			if (!find1.equals(new Position(-1, -1))) {
				return find1;
			}
			return findElement(matrix, elem,
					new Position(origin.row, Math.min(mid_col + 1, dest.col)),
					new Position(mid_row, dest.col));
		} else {
			if (mid_row == origin.row && mid_col == origin.col) { // couldn't
																	// find
																	// smaller
																	// elements
				return new Position(-1, -1);
			}
			Position find1 = findElement(matrix, elem, new Position(mid_row,
					origin.col),
					new Position(dest.row, Math.max(mid_col - 1, origin.col)));
			if (!find1.equals(new Position(-1, -1))) {
				return find1;
			}
			return findElement(matrix, elem, new Position(origin.row, mid_col),
					new Position(Math.max(mid_row - 1, origin.row), dest.col));
		}

	}

	public static void main(String[] args) {
		// test case 1
		int[][] matrix0 = { { 15, 20, 70, 85 }, { 20, 35, 80, 95 },
				{ 30, 55, 95, 105 }, { 40, 80, 100, 120 } };

		Position position0 = findElement(matrix0, 85);
		System.out.println("(" + position0.row + "," + position0.col + ")");

		Position position0_1 = findElement(matrix0, 10);
		System.out.println("(" + position0_1.row + "," + position0_1.col + ")");

		Position position0_2 = findElement(matrix0, 1000);
		System.out.println("(" + position0_2.row + "," + position0_2.col + ")");

		// test case 2
		int[][] matrix1 = { { 15, 20, 70, 85 } };

		Position position1 = findElement(matrix1, 70);
		System.out.println("(" + position1.row + "," + position1.col + ")");

		Position position1_1 = findElement(matrix1, 10);
		System.out.println("(" + position1_1.row + "," + position1_1.col + ")");

		Position position1_2 = findElement(matrix1, 95);
		System.out.println("(" + position1_2.row + "," + position1_2.col + ")");

		// test case 3
		int[][] matrix2 = { { 15 }, { 20 }, { 30 }, { 40 } };

		Position position2 = findElement(matrix2, 30);
		System.out.println("(" + position2.row + "," + position2.col + ")");

		Position position2_1 = findElement(matrix2, 10);
		System.out.println("(" + position2_1.row + "," + position2_1.col + ")");

		Position position2_2 = findElement(matrix2, 50);
		System.out.println("(" + position2_2.row + "," + position2_2.col + ")");
	}
}
