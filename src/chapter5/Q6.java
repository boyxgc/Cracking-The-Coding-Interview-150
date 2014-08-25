package chapter5;

/**
 * Write a program to swap odd and even bits in an integer with as few
 * instructions as possible (e.g., bit 0 and bit 1 are swapped, bit 2 and bit 3
 * are swapped, and so on)
 * 
 * @author boyxgc
 * 
 */
public class Q6 {

	public static int swapBits(int num) {
		return (((num & 0xaaaaaaaa) >> 1) | ((num & 0x55555555) << 1));
	}

	public static void main(String[] args) {
		int num = Integer.parseInt("11010110", 2);
		System.out.println(Integer.toBinaryString(num));
		System.out.println(Integer.toBinaryString(swapBits(num)));
	}
}
