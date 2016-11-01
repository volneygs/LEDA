package roteiro05.r05;

import java.util.Arrays;

import roteiro05.util.Util;

/**
 * This algorithm simulates a logical partitioning of the input array by considering 
 * different indexing, that is, the first sub-array is indexed by even elements and
 * the second sub-array is indexed by odd elements. Then, it applies a complete bubblesort
 * in the first sub-array considering neighbours (even). After that, 
 * it applies a complete bubblesort in the second sub-array considering
 * neighbours (odd).  After that, the algorithm performs a merge between elements indexed
 * by even and odd numbers.
 */

public class OddEvenBubbleSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		
		bubbleSort(array, leftIndex, rightIndex);
		bubbleSort(array, leftIndex + 1, rightIndex);
		mergeTwoSortedList(array, leftIndex, rightIndex);
	}

	private void bubbleSort(T[] array, int leftIndex, int rightIndex) {
		for (int i = leftIndex; i < rightIndex; i += 2) {
			for (int j = leftIndex; j < rightIndex - 1; j += 2) {
				if ((array[j].compareTo(array[j + 2]) > 0)) {
					Util.swap(array, j, j + 2);
				}
			}
		}
	}

	private void mergeTwoSortedList(T[] array, int leftIndex, int rightIndex) {
		T[] aux = Arrays.copyOf(array, array.length);
		int i = leftIndex;
		int j = leftIndex + 1;
		int k = leftIndex;

		while (i <= rightIndex && j <= rightIndex) {
			if (aux[i].compareTo(aux[j]) <= 0) {
				array[k] = aux[i];
				i += 2;
			} else {
				array[k] = aux[j];
				j += 2;
			}
			k++;
		}

		while (i <= rightIndex) {
			array[k] = aux[i];
			i += 2;
			k++;
		}

		while (j <= rightIndex) {
			array[k] = aux[j];
			j += 2;
			k++;
		}

	}

}
