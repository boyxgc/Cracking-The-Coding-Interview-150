package chapter17;

/**
 * Write a function to swap a number in place (that is, without temporary
 * variables)
 * 
 * @author boyxgc
 * 
 */
public class Q1 {

	public static void main(String[] args) {
		int x = 5;
		int y = 3;

		System.out.println(x + "," + y);

		x = x ^ y; 
		y = x ^ y; 
		x = x ^ y; 

		System.out.println(x + "," + y);
	}
}
