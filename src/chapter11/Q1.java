package chapter11;

/**
 * You are given two sorted arrays, a And B, where A has a large enough buffer
 * at the end to hold B. Write a method to merge B into A.
 * 
 * @author boyxgc
 * 
 */
public class Q1 {

	public static int merge(int[] A, int na, int[] B, int nb) {
		int pos = na + nb - 1;
		int pos_a = na - 1;
		int pos_b = nb - 1;
		while (pos_b >= 0) {
			if (pos_a >= 0 && A[pos_a] <= B[pos_b]) {
				A[pos] = A[pos_a--];
			} else {
				A[pos] = B[pos_b--];
			}
			pos--;
		}

		return na + nb;
	}

	public static void main(String[] args) {
		int A[] = { 10, 8, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		int B[] = { 11, 10, 9, 3, 1 };

		int newlen = merge(A, 3, B, 5);

		for (int i = 0; i < newlen; ++i) {
			System.out.print(A[i] + " ");
		}
	}
}
