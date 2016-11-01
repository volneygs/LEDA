package roteiro02.r02;

public abstract class AbstractSorting <T extends Comparable<T>> implements Sorting<T> {

	@Override
	public void sort(T[] array) {
		sort(array, 0, array.length-1);
	}
	
	/**
	 * This method sorts an interval of the array, starting
	 * in leftIndex and ending in rightIndex, both inclusive.
	 * 
	 * @param array  the target of the sorting algorithm
	 * @param leftIndex  where the sorting should begin
	 * @param rightIndex  where the sorting should end
	 */
	public abstract void sort(T[] array, int leftIndex, int rightIndex);
	
}
