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
		while (pos >= 0) {
			if (pos_a >= 0
					&& ((pos_b >= 0 && A[pos_a] < B[pos_b]) || pos_b < 0)) {
				A[pos--] = A[pos_a--];
			} else if (pos_b >= 0
					&& ((pos_a >= 0 && B[pos_b] <= A[pos_a]) || pos_a < 0)) {
				A[pos--] = B[pos_b--];
			}
		}

		return na + nb;
	}

	public static void main(String[] args) {
		int A[] = { 10, 8, 5, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		int B[] = { 11, 10, 9 };

		int newlen = merge(A, 5, B, 3);

		for (int i = 0; i < newlen; ++i) {
			System.out.print(A[i] + " ");
		}
	}
}
