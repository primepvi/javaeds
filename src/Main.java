public class Main {
	public static void main(String[] args) {
		int[] numbers = { 3, 1, 5, 10, 0, 9, -1 };

		printArray(numbers);
		printArray(Sorter.quickSort(numbers));
	}

	private static void printArray(int[] array) {
		for (int element : array) {
			System.out.print(element);
			System.out.print(" ");
		}

		System.out.print("\n");
	}
}
