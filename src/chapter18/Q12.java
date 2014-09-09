package chapter18;

import java.util.Arrays;

/**
 * Given an NxN matrix of positive and negative integers, write code to find the
 * sub-matrix with the largest possible sum
 * 
 * @author boyxgc
 * 
 */
public class Q12 {

	public static class Square {
		int leftTopRow;
		int leftTopCol;
		int rightBottomRow;
		int rightBottomCol;

		public Square(int _leftTopRow, int _leftTopCol, int _rightBottomRow,
				int _rightBottomCol) {
			leftTopCol = _leftTopCol;
			leftTopRow = _leftTopRow;
			rightBottomRow = _rightBottomRow;
			rightBottomCol = _rightBottomCol;
		}
	}

	/*
	 * Solution 1: dynamic programming, runtime O(n^4)
	 */
	public Square findMaxSumSubMatrix(int[][] matrix) {

		// areaMatrix[x][y] : sum between (0, 0) and (x, y)
		int[][] areaMatrix = preCalculateAreaMatrix(matrix);

		Square maxSquare = null;
		int maxArea = Integer.MIN_VALUE;

		for (int tlx = 0; tlx < matrix.length; ++tlx) { // top left x
			for (int tly = 0; tly < matrix[0].length; ++tly) { // top left y
				for (int brx = tlx; brx < matrix.length; ++brx) { // bottom
																	// right x
					for (int bry = tly; bry <= matrix[0].length; ++bry) { // bottom
																			// right
																			// y
						int tmparea = calculateArea(areaMatrix, tlx, tly, brx,
								bry);
						if (tmparea > maxArea) {
							maxArea = tmparea;
							maxSquare = new Square(tlx, tly, brx, bry);
						}
					}
				}
			}
		}

		return maxSquare;
	}

	private int[][] preCalculateAreaMatrix(int[][] matrix) {
		int[][] areaMatrix = new int[matrix.length][matrix[0].length];

		int nRow = matrix.length;
		int nCol = matrix[0].length;

		areaMatrix[0][0] = matrix[0][0];
		for (int col = 1; col < nCol; ++col) {
			areaMatrix[0][col] = areaMatrix[0][col - 1] + matrix[0][col];
		}
		for (int row = 1; row < nRow; ++row) {
			areaMatrix[row][0] = areaMatrix[row - 1][0] + matrix[row][0];
		}

		for (int row = 1; row < nRow; row++) {
			for (int col = 1; col < nCol; ++col) {
				areaMatrix[row][col] = areaMatrix[row - 1][col]
						+ areaMatrix[row][col - 1]
						- areaMatrix[row - 1][col - 1] + matrix[row][col];
			}
		}

		return areaMatrix;
	}

	private int calculateArea(int[][] areaMatrix, int tlRow, int tlCol,
			int brRow, int brCol) {

		return areaMatrix[brRow][brCol] - areaMatrix[tlRow][brCol]
				- areaMatrix[brRow][tlCol] + areaMatrix[tlRow][tlCol];
	}

	/*
	 * Solution 2: compress rows into one row, run findMaxSum algorithm in an
	 * array on each compressed row, runtime O(n^3)
	 */

	public static class ColSumCell {
		int sum;
		int lCol;
		int rCol;

		public ColSumCell(int _sum, int _lCol, int _rCol) {
			sum = _sum;
			lCol = _lCol;
			rCol = _rCol;
		}
	}

	public static Square findMaxSumSubMatrix2(int[][] matrix) {

		int nRow = matrix.length;
		int nCol = matrix[0].length;

		int maxSum = Integer.MIN_VALUE;
		Square maxSquare = null;

		int[] colsSumCache = new int[nCol];
		for (int rowUp = 0; rowUp < nRow; ++rowUp) {
			Arrays.fill(colsSumCache, 0);
			for (int rowDown = rowUp; rowDown < nRow; ++rowDown) {
				for (int col = 0; col < nCol; ++col) {
					colsSumCache[col] += matrix[rowDown][col];
				}
				ColSumCell cell = findMaxSum(colsSumCache);
				int currMaxSum = cell.sum;
				if (currMaxSum > maxSum) {
					maxSum = currMaxSum;
					maxSquare = new Square(rowUp, cell.lCol, rowDown, cell.rCol);
				}
			}
		}

		return maxSquare;
	}

	private static ColSumCell findMaxSum(int[] arr) {
		int head = 0;
		int tail = -1;
		int maxSum = -1;

		int tmpSum = 0;
		for (int i = 0; i < arr.length; ++i) {
			tmpSum += arr[i];
			if (tmpSum > 0) {
				if (tmpSum > maxSum) {
					tail = i;
					maxSum = tmpSum;
				}
			} else {
				head = i + 1;
				tmpSum = 0;
			}
		}

		// no positive sum found, find the max negative number
		if (maxSum == -1) {
			maxSum = arr[0];
			for (int i = 0; i < arr.length; ++i) {
				if (arr[i] > maxSum) {
					tail = head = i;
					maxSum = arr[i];
				}
			}
		}

		return new ColSumCell(maxSum, head, tail);
	}
}
