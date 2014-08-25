package chapter5;

/**
 * You are given two 32-bit numbers, N and M, and two bit positions , i and j.
 * Write a method to insert M into N such that M starts at bit j and ends at bit
 * i. You can assume that the bits j through i have enough space to fit all of
 * M. That is, if M = 10011. you can assume that there are at least 5 bits
 * between j and i. You would not, for example, have j = 3 and i = 2, because M
 * could not fully fit between 3 and 2.
 * 
 * EXAMPLE
 * 
 * input: N = 10000000000, M = 10011, i = 2, j = 6; output: N = 10001001100
 * 
 * @author boyxgc
 * 
 */
public class Q1 {

	public static int insert(int N, int M, int i, int j) {
		/* mask to clear bits between ith and jth */
		int mask = ~(-1 >>> (31 - j)) | (-1 >>> (32 - i));

		return (N & mask) | (M << i);
	}

	public static void main(String[] args) {

		int N = Integer.parseInt("10000010000", 2);
		int M = Integer.parseInt("10011", 2);

		System.out.println(Integer.toBinaryString(insert(N, M, 2, 6)));

	}
}
