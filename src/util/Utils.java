package util;

public class Utils {
	public static void printIntMatrix(int [][] matrix, int m, int n) {
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				System.out.print(matrix[i][j] + "  ");
			}
			System.out.println();
		}
	}
}
