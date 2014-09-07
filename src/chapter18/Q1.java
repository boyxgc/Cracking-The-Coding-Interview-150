package chapter18;

/**
 * Write a function that adds two numbers. You should not use + or any
 * arithmetic operators
 * 
 * @author boyxgc
 * 
 */
public class Q1 {

	public static int add(int a, int b) {
		if (b == 0)
			return a;
		int sum = a ^ b; // add without carry
		int carry = (a & b) << 1; // carry, but don't add
		return add(sum, carry);
	}

	public static void main(String[] args) {
		System.out.println(add(3, -8));
	}
}
