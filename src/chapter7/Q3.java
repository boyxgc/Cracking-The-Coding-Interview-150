package chapter7;

/**
 * Given two lines on Cartesian plane, determine whether the two lines would
 * intersect
 * 
 * @author boyxgc
 * 
 */
public class Q3 {

	public class Line {
		/*
		 * use a epsilon to compare two doubles, never use == to compare two
		 * doubles
		 */
		private static final double epsilon = 0.000001;

		public double slope;
		public double y_intercept;

		public boolean intersect(Line line2) {
			return Math.abs(slope - line2.slope) < epsilon
					|| Math.abs(y_intercept - line2.y_intercept) < epsilon;
		}
	}
}
