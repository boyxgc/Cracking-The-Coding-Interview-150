package chapter1;

import util.Utils;

/**
 * Write a algorithm such that if an element in an MxN matrix is 0, its entire
 * row and column are set to 0
 * 
 * @author boyxgc
 * 
 */
public class Q7 {
	public static void setZeroColumn(int[][] matrix, int m, int n) {

		/* use column 0 and row 0 to mark other columns and rows */
		for (int i = 1; i < m; ++i) {
			for (int j = 1; j < n; ++j) {
				if (matrix[i][j] == 0) {
					/* mark 0 */
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}

		for (int i = 1; i < n; ++i) {
			/* set column to 0 */
			if (matrix[0][i] == 0) {
				for (int j = 1; j < m; ++j) {
					matrix[j][i] = 0;
				}
			}
		}

		for (int i = 1; i < m; ++i) {
			/* set row to 0 */
			if (matrix[i][0] == 0) {
				for (int j = 1; j < n; ++j) {
					matrix[i][j] = 0;
				}
			}
		}

		if (matrix[0][0] == 0) {
			/* set col 0 */
			for (int i = 0; i < n; ++i) {
				matrix[0][i] = 0;
			}
			/* set row 0 */
			for (int i = 0; i < m; ++i) {
				matrix[i][0] = 0;
			}
		}
	}

	public static void main(String[] args) {
		int[][] matrix = { { 0, 1, 2, 0 }, { 4, 5, 6, 1 }, { 7, 8, 9, 1 } };
		Utils.printIntMatrix(matrix, 3, 4);
		System.out.println();
		setZeroColumn(matrix, 3, 4);
		Utils.printIntMatrix(matrix, 3, 4);
	}

}
