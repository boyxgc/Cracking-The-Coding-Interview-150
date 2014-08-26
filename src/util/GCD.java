package util;

/**
 * Greatest common divisor
 * 
 * @author boyxgc
 * 
 */
public class GCD {

	/* u is no less than v */
	public static int gcd(int u, int v) {
		if (u < v) {
			return gcd(v, u);
		}
		if (u == v) {
			return u;
		}
		if (v == 0) {
			return u;
		}

		/* u is even */
		if ((~u & 1) > 0) {
			/* v is even */
			if ((~v & 1) > 0) {
				return gcd(u >> 1, v >> 1) << 1;
			}
			/* v is odd */
			else {
				return gcd(u >> 1, v);
			}
		}
		/* u is odd */
		else {
			/* v is even */
			if ((~v & 1) > 0) {
				return gcd(u, v >> 1);
			}
			/* v is odd */
			else {
				return gcd((u - v), v);
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(gcd(15, 25));
	}
}
