package chapter18;

/**
 * Imaging you have a square matrix, where each cell(pixel) is either black or
 * white. Design an algorithm to find the maximum sub-square such that all four
 * borders are filled with black pixels
 * 
 * @author boyxgc
 * 
 */
public class Q11 {

	public static class SquareCell {
		int rightBlacks;
		int belowBlacks;
	}

	public static class Square {
		int leftTopRow;
		int leftTopCol;
		int size;

		public Square(int _leftTopRow, int _leftTopCol, int _size) {
			leftTopCol = _leftTopCol;
			leftTopRow = _leftTopRow;
			size = _size;
		}
	}

	public static Square findMaxSubSquare(int[][] matrix) {// 0 for while 1 for
															// black
		SquareCell[][] markedMatrix = preprocess(matrix);

		for (int i = matrix.length; i > 0; i--) {
			Square sq = findSquareWithSize(markedMatrix, i);
			if (sq != null) {
				return sq;
			}
		}
		return null;
	}

	private static SquareCell[][] preprocess(int[][] matrix) {
		SquareCell[][] markedMatrix = new SquareCell[matrix.length][matrix.length];

		for (int row = matrix.length - 1; row >= 0; --row) {
			for (int col = matrix.length - 1; col >= 0; --col) {
				markedMatrix[row][col].rightBlacks = matrix[row][col];
				markedMatrix[row][col].belowBlacks = matrix[row][col];
				if (col != matrix.length - 1) {
					markedMatrix[row][col].rightBlacks += markedMatrix[row][col + 1].rightBlacks;
				}
				if (row != matrix.length - 1) {
					markedMatrix[row][col].belowBlacks += markedMatrix[row + 1][col].belowBlacks;
				}

			}
		}

		return markedMatrix;
	}

	private static Square findSquareWithSize(SquareCell[][] matrix, int size) {

		for (int i = 0; i <= matrix.length - size; ++i) {
			for (int j = 0; j <= matrix.length - size; ++i) {
				if (checkBorder(matrix, i, j, size)) {
					return new Square(i, j, size);
				}
			}
		}
		return null;
	}

	private static boolean checkBorder(SquareCell[][] matrix, int ltrow,
			int ltcol, int size) {

		SquareCell leftTop = matrix[ltrow][ltcol];
		SquareCell rightTop = matrix[ltrow][ltcol + size - 1];
		SquareCell leftBottom = matrix[ltcol + size - 1][ltcol];

		if (leftTop.rightBlacks < size || leftTop.belowBlacks < size) {
			return false;
		}

		if (rightTop.belowBlacks < size) {
			return false;
		}

		if (leftBottom.rightBlacks < size) {
			return false;
		}

		return true;
	}
}
