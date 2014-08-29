package chapter9;

/**
 * Implement the "paint fill" function that one might see on many image editing
 * programs. That is, given a screen(represented by a two-dimensional array of
 * colors), a point, and a new color, fill in the surrounding area until the
 * color changes from the original color
 * 
 * @author boyxgc
 * 
 */
public class Q7 {

	enum Color {
		Red, Green, Blue
	}

	public static void paintFill(Color[][] screen, int x, int y, Color newColor) {
		/*
		 * if new color is same as old color, do nothing, otherwise, the next
		 * code will go in infinite loop
		 */
		if (screen[x][y] == newColor) {
			return;
		}
		paint(screen, x, y, screen[x][y], newColor);
	}

	private static void paint(Color[][] screen, int x, int y, Color oldColor,
			Color newColor) {
		if (x < 0 || y < 0 || x >= screen.length || y >= screen[0].length
				|| screen[x][y] != oldColor) {
			return;
		}
		screen[x][y] = newColor;
		paint(screen, x - 1, y, oldColor, newColor);
		paint(screen, x + 1, y, oldColor, newColor);
		paint(screen, x, y - 1, oldColor, newColor);
		paint(screen, x, y + 1, oldColor, newColor);
	}
}
