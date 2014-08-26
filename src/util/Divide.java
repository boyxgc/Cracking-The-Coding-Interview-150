package util;

public class Divide {

	public static class Result {
		public int quotient;
		public int reminder;

		public Result(int _quotient, int _reminder) {
			quotient = _quotient;
			reminder = _reminder;
		}
	}

	public static Result divide(int x, int y) {
		if (x == 0) {
			return new Result(0, 0);
		}

		Result result = divide(x >> 1, y);
		int q = result.quotient << 1;
		int r = result.reminder << 1;

		/* x is odd */
		if ((x & 1) > 0) {
			r += 1;
		}

		if (r >= y) {
			r -= y;
			q += 1;
		}

		return new Result(q, r);
	}

	public static void main(String[] args) {
		Result result = divide(13, 5);
		System.out.println(result.quotient + "..." + result.reminder);
	}
}
