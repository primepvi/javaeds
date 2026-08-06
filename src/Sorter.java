import java.util.Arrays;

public class Sorter {
	public static void insertionSort(int[] array) {
		for (int i = 1; i < array.length; i++) {
			int currentElement = array[i];
			int j = i - 1;

			while (j >= 0 && array[j] > currentElement) {
				array[j + 1] = array[j];
				j--;
			}

			array[j + 1] = currentElement;
		}
	}

	public static int[] mergeSort(int[] array) {
		if (array.length <= 1)
			return array;

		int[] arrayA = mergeSort(Arrays.copyOfRange(array, 0, array.length / 2));
		int[] arrayB = mergeSort(Arrays.copyOfRange(array, array.length / 2, array.length));
		int[] result = new int[arrayA.length + arrayB.length];

		int cursorA = 0;
		int cursorB = 0;

		while (cursorA < arrayA.length && cursorB < arrayB.length) {
			if (arrayA[cursorA] <= arrayB[cursorB]) {
				result[cursorA + cursorB] = arrayA[cursorA];
				cursorA++;
			} else {
				result[cursorA + cursorB] = arrayB[cursorB];
				cursorB++;
			}
		}

		if (cursorA < arrayA.length) {
			for (int i = cursorA; i < arrayA.length; i++) {
				result[cursorA + cursorB] = arrayA[cursorA];
				cursorA++;
			}
		}

		if (cursorB < arrayB.length) {
			for (int i = cursorB; i < arrayB.length; i++) {
				result[cursorA + cursorB] = arrayB[cursorB];
				cursorB++;
			}
		}

		return result;
	}

	public static int[] quickSort(int[] array) {
		if (array.length <= 1)
			return array;

		int pivot = array[0];

		int[] arrayLeft = new int[array.length];
		int[] arrayRight = new int[array.length];

		int cursorLeft = 0;
		int cursorRight = 0;

		for (int i = 1; i < array.length; i++) {
			if (array[i] >= pivot) {
				arrayRight[cursorRight++] = array[i];
			} else {
				arrayLeft[cursorLeft++] = array[i];
			}
		}

		int[] resultArrayLeft = quickSort(Arrays.copyOf(arrayLeft, cursorLeft));
		int[] resultArrayRight = quickSort(Arrays.copyOf(arrayRight, cursorRight));
		int[] resultArray = new int[resultArrayLeft.length + resultArrayRight.length + 1];
		int resultCursor = 0;

		for (int num : resultArrayLeft) {
			resultArray[resultCursor++] = num;
		}

		resultArray[resultCursor++] = pivot;

		for (int num : resultArrayRight) {
			resultArray[resultCursor++] = num;
		}

		return resultArray;
	}
}
