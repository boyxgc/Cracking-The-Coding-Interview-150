package chapter5;

/**
 * A monochrome screen is stored as a single array of bytes, allowing eight
 * consecutive pixels to be stored in one byte. The screen has width w, where w
 * is divisible by 8 (that is, no byte will be split across rows). The height of
 * screen, of course can be derived from the length of the array and the width.
 * Implement a function drawHorizontalLine(byte[] screen, int width, int x1, int
 * x2, int y) with draws a horizontal line from (x1, y) to (x2, y)
 * 
 * @author boyxgc
 * 
 */
public class Q8 {

	public static void drawHorizontalLine(byte[] screen, int width, int x1,
			int x2, int y) {

		int byteStartOffset = y * width / 8 + x1 / 8;
		int byteEndOffset = y * width / 8 + x2 / 8;
		int pixelStartOffset = x1 % 8;
		int pixelEndOffset = x2 % 8;

		byte startMask = (byte) ((0xFF >> pixelStartOffset));
		byte endMask = (byte) ~(0xFF >> (pixelEndOffset + 1));
		/* x1 and x2 are in the same byte */
		if (byteStartOffset == byteEndOffset) {
			screen[byteStartOffset] = (byte) (startMask & endMask);
		}
		/* x1 and x2 are not in the same byte */
		else {
			screen[byteStartOffset] = startMask;
			screen[byteEndOffset] = endMask;
			for (int i = byteStartOffset + 1; i < byteEndOffset; ++i) {
				screen[i] = (byte) 0xFF;
			}
		}
	}
}
