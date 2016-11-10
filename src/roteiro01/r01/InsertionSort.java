package roteiro01.r01;

/**
 * As the insertion sort algorithm iterates over the array, it makes the
 * assumption that the visited positions are already sorted in ascending order,
 * which means it only needs to find the right position for the current element
 * and insert it there.
 */
public class InsertionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		
		int i;
		
		for(int j = leftIndex + 1; j <= rightIndex; j++){
			
			T key  = array[j];
			
			i = j - 1;
			
			while(i >= 0 && array[i].compareTo(key) > 0){
				
				array[i+1] = array[i];
				
				i = i - 1;
				
			}
			
			array[i+1] = key;
		}
	
	}
}
