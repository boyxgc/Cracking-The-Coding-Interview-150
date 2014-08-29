package chapter9;

import java.util.Arrays;

/**
 * Write an algorithm to print all of arranging eight queens on an 8x8 chess
 * board so that none of them share the same row, column or diagonal. In this
 * case "diagonal" means all diagonals, not just the two that bisect the board
 * 
 * @author boyxgc
 * 
 */
public class Q9 {

	public static void n_queens(char[][] board, int row, int colMask,
			int diaglMask, int diagrMask) {

		if (row == board.length) {
			printBoard(board);
		}

		int available = ~(colMask | diaglMask | diagrMask);

		for (int col = 0; col < board.length; ++col) {
			/* valid position */
			int pos = 1 << col;
			if ((available & pos) > 0) {
				board[row][col] = 'x';
				n_queens(board, row + 1, colMask | pos, (diaglMask | pos) << 1,
						(diagrMask | pos) >> 1);
				board[row][col] = 'o';
			}
		}
	}

	private static void printBoard(char[][] board) {
		for (int i = 0; i < board.length; ++i) {
			for (int j = 0; j < board[i].length; ++j) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void main(String[] args) {
		char[][] board = new char[4][4];
		Arrays.fill(board[0], 'o');
		Arrays.fill(board[1], 'o');
		Arrays.fill(board[2], 'o');
		Arrays.fill(board[3], 'o');

		printBoard(board);
		n_queens(board, 0, 0, 0, 0);
	}
}
