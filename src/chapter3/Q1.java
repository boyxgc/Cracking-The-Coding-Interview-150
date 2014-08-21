package chapter3;

/**
 * describe how you could use a single array to implement three stacks
 * 
 * @author boyxgc
 * 
 */
public class Q1 {

	/*
	 * For simplicity, use fixed space allocation
	 */
	public class ThreeStacks {
		private int capacity;
		private int[] data;

		private int[] pointer;

		private int[] top;

		public ThreeStacks(int _capacity) {
			capacity = _capacity;
			data = new int[_capacity];

			pointer = new int[3];
			top = new int[3];

			pointer[0] = 0;
			pointer[1] = _capacity / 3;
			pointer[2] = _capacity / 3 + _capacity / 3;

			top[0] = top[1] = top[2] = -1;
		}

		public void push(int stackNum, int value) throws Exception {
			if (top[stackNum - 1] + 1 >= capacity / 3) {
				throw new Exception("Error pushing element to full stack "
						+ stackNum);
			}
			data[pointer[stackNum - 1] + (++top[stackNum - 1])] = value;
		}

		public int pop(int stackNum) throws Exception {
			if (top[stackNum - 1] < 0) {
				throw new Exception("Error pop empty stack " + stackNum);
			}
			return data[--top[stackNum - 1]];
		}

		public void printData() {

			for (int stack = 0; stack < 3; ++stack) {
				System.out.print("\nStack " + (stack + 1) + ": ");
				for (int i = 0; i <= top[stack]; ++i) {
					System.out.print(data[pointer[stack] + i] + " ");
				}
			}

		}
	}

	public static void main(String[] args) {
		try {
			ThreeStacks threeStacks = new Q1().new ThreeStacks(9);
			threeStacks.push(1, 1);
			threeStacks.push(2, 2);
			threeStacks.push(2, 3);
			threeStacks.push(2, 4);
			threeStacks.pop(2);
			threeStacks.push(3, 3);

			threeStacks.printData();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
