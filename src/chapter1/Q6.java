package chapter1;

/**
 * Given an image represented by NxN matrix, each pixel in the image is 4 bytes,
 * write a method to rotate the image by 90 degrees in place.
 * 
 * @author boyxgc
 * 
 */
public class Q6 {

	/*
	 * use one int(4 bytes) to represent one pixel
	 */
	public static void rotate(int[][] matrix, int d) {
		int m = d / 2;
		int n = d - m;

		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[d - 1 - j][i];
				matrix[d - 1 - j][i] = matrix[d - 1 - i][d - 1 - j];
				matrix[d - 1 - i][d - 1 - j] = matrix[j][d - 1 - i];
				matrix[j][d - 1 - i] = tmp;
			}
		}
	}

	public static void main(String[] args) {
		int[][] matrix1 = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
				{ 13, 14, 15, 16 } };
		rotate(matrix1, 4);
		print(matrix1, 4);

		int[][] matrix2 = { { 1 } };
		rotate(matrix2, 1);
		print(matrix2, 1);

		int[][] matrix3 = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 },
				{ 11, 12, 13, 14, 15 }, { 16, 17, 18, 19, 20 },
				{ 21, 22, 23, 24, 25 } };
		rotate(matrix3, 5);
		print(matrix3, 5);
	}

	private static void print(int[][] matrix, int d) {
		for (int i = 0; i < d; ++i) {
			for (int j = 0; j < d; ++j) {
				System.out.print(matrix[i][j] + "  ");
			}
			System.out.println();
		}
	}
}
