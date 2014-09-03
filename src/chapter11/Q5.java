package chapter11;

/**
 * Given a sorted array of strings which is interspersed with empty strings,
 * write a method to find the location of a string
 * 
 * EXAMPLE
 * 
 * input: find "ball" in {"at", "", "", "", "balll", "", "", "car", "", "",
 * "dad", ""}
 * 
 * output: 4
 * 
 * @author boyxgc
 * 
 */
public class Q5 {

	public static int findString(String[] array, String str) {
		return findString(array, str, 0, array.length - 1);
	}

	private static int findString(String[] array, String str, int low, int high) {

		if (low > high) {
			return -1;
		}

		int mid = (low + high) / 2;

		int left_padding = mid - 1;
		int right_padding = mid + 1;

		/* find closest non-empty string */
		while (true) {
			if (left_padding < low && right_padding > high) {
				return -1;
			}
			if (left_padding >= low && !array[left_padding].equals("")) {
				mid = left_padding;
				break;
			}
			if (right_padding <= high && !array[right_padding].equals("")) {
				mid = right_padding;
				break;
			}
			left_padding--;
			right_padding++;
		}

		int cmp = array[mid].compareTo(str);
		if (cmp == 0) {
			return mid;
		} else if (cmp < 0) {
			return findString(array, str, mid + 1, high);
		} else {
			return findString(array, str, low, mid + 1);
		}
	}

	public static void main(String[] args) {
		String[] array = { "at", "", "", "", "ball", "balll", "", "bbbb", "",
				"car", "", "", "dad", "" };

		System.out.println(findString(array, "balll"));
	}
}
